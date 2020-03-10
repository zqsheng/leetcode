package ds.tree;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.experimental.Accessors;

import java.security.InvalidParameterException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 树形结构工具类
 * @author zqsheng
 *
 */
public class TreeUtils {

    /**
     * 构建树形结构
     * @param nodes
     * @param root
     * @param childrenKey
     * @return
     */
    public static <T extends Node<K,V>,K,V> JSONArray buildTree(List<T> nodes, K root, Integer level, String childrenKey) {
        if (nodes == null || root == null || childrenKey == null || "".equals(childrenKey)) {
            throw new InvalidParameterException("参数错误");
        }
        Map<K, List<T>> map = nodes.stream().collect(Collectors.groupingBy(Node::getPid));
        return buildTree(map,root,level,childrenKey);
    }


    /**
     * 构建树形接口
     * 使用默认值
     * root:0,level:0,childKey:children
     * @param nodes
     * @return
     */
    public static <T extends Node<K,V>,K,V> JSONArray buildTree(List<T> nodes) {
        return buildTree(nodes,(K)Integer.valueOf(0),0,"children");
    }

    /**
     * 构建树形结构
     * 指定根节点
     * @param nodes
     * @param root
     * @return
     */
    public static <T extends Node<K,V>,K,V> JSONArray buildTree(List<T> nodes, K root) {
        return buildTree(nodes,root,0,"children");
    }

    private static <T extends Node<K,V>,K,V> JSONArray buildTree(Map<K,List<T>> map, K root, Integer level, String childrenKey) {
        List<T> nodes = map.get(root);
        if (nodes == null) { return null; }
        JSONArray array = new JSONArray();
        for (T node : nodes) {
            node.setLv(level);
            JSONObject json = (JSONObject) JSONObject.toJSON(node);
            JSONArray children = buildTree(map, node.getId(), level + 1, childrenKey);
            if (children != null) {
                json.put(childrenKey,children);
            }
            array.add(json);
        }
        return array;
    }

    /**
     * @param nodes
     * @param key 顶级根节点键(非数据库实体)
     * @param converter 转换器
     * @param <T>
     * @param <VO>
     * @param <K>
     * @param <V>
     * @return
     */
    public static <T extends Node<K,V>,VO extends TreeVO<VO,K,V>,K,V> List<VO> buildTreeVO(List<T> nodes,K key,Function<T,VO> converter) {
        Map<K, List<T>> map = nodes.stream().collect(Collectors.groupingBy(Node::getPid));
        List<VO> roots = map.get(key).stream().map(converter).collect(Collectors.toList());
        roots.forEach(e -> setChildren(map,e,converter));
        return roots;
    }


    private static <T extends Node<K,V>,K,V,VO extends TreeVO<VO,K,V>> void setChildren(Map<K,List<T>> map,VO vo, Function<T,VO> converter) {
        List<T> children = map.get(vo.getId());
        if(children != null && children.size() > 0) {
           vo.setChildren(children.stream().map(converter).collect(Collectors.toList()));
           vo.getChildren().forEach(e -> setChildren(map,e,converter));
        }
    }
    private static <T extends Node<K,V>,K,V,VO extends AuthorityControlTreeVO<VO,K,V>> void setChildren(Map<K,List<T>> map) {

    }

    /**
     * 设置节点lv
     * @param nodes
     * @param <T>
     * @param <K>
     * @param <V>
     */
    public static <T extends Node<Integer,V>,K,V> void setLv(List<T> nodes) {
        setLv(nodes,0,0);
    }

    /**
     * 设置节点lv
     * @param nodes
     * @param rootId
     * @param startLv
     * @param <T>
     * @param <K>
     * @param <V>
     */
    public static <T extends Node<K,V>,K,V> void setLv(List<T> nodes,K rootId,Integer startLv) {
        if (nodes== null || rootId == null || startLv == null) { throw new InvalidParameterException("参数错误");}
        setLv(nodes.stream().collect(Collectors.groupingBy(Node::getPid)),rootId,startLv);
    }

    /**
     * 方法实现
     * @param pGroups
     * @param rootId
     * @param startLv
     * @param <T>
     * @param <K>
     * @param <V>
     */
    private static <T extends Node<K,V>,K,V> void setLv(Map<K,List<T>> pGroups,K rootId,Integer startLv) {
        List<T> children = pGroups.get(rootId);
        if (children != null && children.size() > 0) {
            for (T child : children) {
                child.setLv(startLv);
                setLv(pGroups,child.getId(),startLv + 1);
            }
        }
    }

    /**
     * 获取树节点ID Set
     * 排重使用
     * @param nodes
     * @param rootId
     * @param <T>
     * @param <K>
     * @param <V>
     * @return
     */
    public static <T extends Node<K,V>,K,V> Set<K> listTreeNodeIdSet(List<T> nodes,K rootId) {
        return listTreeNodes(nodes,rootId).stream().map(Node::getId).collect(Collectors.toSet());
    }

    /**
     * 获取树节点 排除无关联的节点 ID 从 rootId = 0
     * @param nodes
     * @param <T>
     * @param <V>
     * @return
     */
    public static <T extends Node<Integer,V>,V> Set<Integer> listTreeNodeIdSet(List<T> nodes) {
        return listTreeNodeIdSet(nodes,0);
    }

    /**
     * 获取树节点(排除无关联的节点)
     * @param nodes
     * @param rootId
     * @param <T>
     * @param <K>
     * @param <V>
     * @return
     */
    public static <T extends  Node<K,V>,K,V> List<T> listTreeNodes(List<T> nodes,K rootId) {
        if (nodes == null) { throw new InvalidParameterException(); }
        Map<K, List<T>> pGroups = nodes.stream().collect(Collectors.groupingBy(Node::getPid));
        List<T> result = new ArrayList<>();
        listTreeNodes(pGroups,rootId,result);
        return result;
    }

    private static <T extends Node<K,V>,K,V> void listTreeNodes(Map<K,List<T>> pGroups,K rootId, List<T> result) {
        List<T> children = pGroups.get(rootId);
        if (children != null && children.size() > 0) {
            for (T child : children) {
                result.add(child);
                listTreeNodes(pGroups,child.getId(),result);
            }
        }
    }

    /**
     * 递归向上获取节点
     * @return
     */
    public static <T extends Node<K,V>,K,V> List<T> recursionGetParentNodes(List<T> nodes,T node) {
        if (node == null) {
            throw new InvalidParameterException("初始节点不能为空");
        }
        return recursionGetParentNodes(nodes,node.getId());
    }

    public static <T extends Node<K,V>,K,V> List<T> recursionGetParentNodes(List<T> nodes,K id) {
        if (nodes == null) {
            throw new InvalidParameterException("搜索节点列表不能为空");
        }
        Map<K, T> map = nodes.stream().collect(Collectors.toMap(Node::getId, Function.identity()));
        return recursionGetParentNodes(map,id);
    }

    public static <T extends Node<K,V>,K,V> List<K> recursionGetParentNodeIds(List<T> nodes,List<K> ids,boolean isContainSelf) {
        Map<K, T> map = nodes.stream().collect(Collectors.toMap(Node::getId, Function.identity()));
        Set<K> result = new LinkedHashSet<>();
        ids.forEach(e -> {
            List<K> list = recursionGetParentNodes(map, e).stream().map(Node::getId).collect(Collectors.toList());
            if (isContainSelf) { list.add(e); }
            result.addAll(list);
        });
        return new ArrayList<>(result);
    }

    /**
     * 避免多次构建搜索map
     * @param nodeMap
     * @param id
     * @param <T>
     * @param <K>
     * @param <V>
     * @return
     */
    public static <T extends Node<K,V>,K,V> List<T> recursionGetParentNodes(Map<K,T> nodeMap,K id) {
        if (nodeMap == null) {
            throw new InvalidParameterException("搜索节点列表不能为空");
        }
        List<T> result = new ArrayList<>();
        recursionGetParentNodes(nodeMap,id,result);
        Collections.reverse(result);
        return result;
    }

    private static <T extends Node<K,V>,K,V> void recursionGetParentNodes(Map<K, T> map,K id,List<T> result) {
        T node = map.get(id);
        if (node != null) {
            T pnode = map.get(node.getPid());
            if (pnode != null) {
                result.add(pnode);
                recursionGetParentNodes(map,node.getPid(),result);
            }
        }
    }
    /**
     * 递归向下获取子节点
     * @param nodes
     * @param root
     * @return
     */
    public static <T extends Node<K,V>,K,V> List<T> recursionGetChildrenNodes(List<T> nodes,K root) {
        Map<K, List<T>> map = nodes.stream().collect(Collectors.groupingBy(Node::getPid));
        List<T> result = new ArrayList<>();
        recursionGetChildrenNodes(map,root,result);
        return result;
    }

    private static <T extends Node<K,V>,K,V> void recursionGetChildrenNodes(Map<K, List<T>> map, K id,List<T> result) {
        List<T> list = map.get(id);
        if (list != null) {
            result.addAll(list);
            list.forEach(e -> recursionGetChildrenNodes(map,e.getId(),result));
        }
    }

    /**
     * 是否兄弟节点
     * @param t1
     * @param t2
     * @param <T>
     * @param <K>
     * @param <V>
     * @return
     */
    public static  <T extends Node<K,V>,K,V> boolean isSibling(T t1,T t2) {
        return t1.getPid().equals(t2.getPid());
    }

    public static final int BLOOD_NOT = 0;
    public static final int BLOOD_PARENT_CHILD = 1;
    public static final int BLOOD_CHILD_PARENT = 2;

    /**
     *
     * @param map
     * @param n1
     * @param n2
     * @param superKey
     * @param <T>
     * @param <K>
     * @param <V>
     * @return
     */
    public static <T extends Node<K,V>,K,V> int isExistBlood(Map<K,T> map,T n1,T n2,K superKey) {
        return isParentChild(map,n1,n2,superKey) ? BLOOD_PARENT_CHILD : isParentChild(map,n2,n1,superKey) ? BLOOD_CHILD_PARENT : BLOOD_NOT;
    }

    /**
     * 是否存在父子关系
     * @param map
     * @param parent
     * @param child
     * @param superKey
     * @param <T>
     * @param <K>
     * @param <V>
     * @return
     */
    public static <T extends Node<K,V>,K,V> boolean isParentChild(Map<K,T> map,T parent,T child,K superKey) {
        if(child == null || child.getPid() == superKey) {
            return false;
        }
        if(child.getPid().equals(parent.getId())) {
            return true;
        }
        return isParentChild(map,parent,map.get(child.getPid()),superKey);
    }

    /**
     * 获取最大子树列表
     * 合并keys
     * @param nodes
     * @param keys
     * @param superKey
     * @param <T>
     * @param <K>
     * @param <V>
     * @return
     */
    public static <T extends Node<K,V>,K,V> List<T> listMaxSubTrees(List<T> nodes,List<K> keys,K superKey) {
        Map<Object, List<Node>> map = nodes.stream().collect(Collectors.groupingBy(e -> e.getPid()));
        List<TreeNode> roots = buildTreeNode(map, superKey);
        List<TreeNode> treeNodes = levelOrder(roots);
        Iterator<TreeNode> iterator = treeNodes.iterator();
        List<K> newKeys = new ArrayList<>(keys);
        List<K> maxSubTreeKeys = new ArrayList<>();
        while (iterator.hasNext() && !newKeys.isEmpty()) {
            TreeNode next = iterator.next();
            if(newKeys.contains(next.getId())) {
                newKeys.remove(next.getId());
                newKeys.removeAll(recursionGetParentNodes(nodes,(K)next.getId()).stream().map(Node::getId).collect(Collectors.toList()));
                maxSubTreeKeys.add((K) next.getId());
            }
        }
        return nodes.stream().filter(e -> maxSubTreeKeys.contains(e.getId())).collect(Collectors.toList());
    }

    /**
     * 工具类-数据结构操作实体,该class与业务无关(不向外暴露)
     */
    @Data
    @Accessors(chain = true)
    private static class TreeNode implements Node {
        private Object id;
        private String name;
        private Object pid;
        private List<TreeNode> children;
    }

    private static final Function<Node,TreeNode> TREE_NODE_CONVERTER = (node -> new TreeNode().setId(node.getId()).setName(node.getName()).setPid(node.getPid()));

    private static List<TreeNode> buildTreeNode( Map<Object,List<Node>> map,Object key) {
        List<TreeNode> roots = map.get(key).stream().map(TREE_NODE_CONVERTER).collect(Collectors.toList());
        roots.forEach(e -> setChildren(map,e));
        return roots;
    }

    private static  void setChildren(Map<Object,List<Node>> map,TreeNode node) {
        List<Node> children = map.get(node.getId());
        if(children != null && children.size() > 0) {
            node.setChildren(children.stream().map(TREE_NODE_CONVERTER).collect(Collectors.toList()));
            node.getChildren().forEach(e -> setChildren(map,e));
        }
    }

    /**
     * 层次遍历
     * @param roots
     * @return
     */
    private static List<TreeNode> levelOrder(List<TreeNode> roots) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        roots.forEach(e -> queue.offer(e));
        TreeNode node = null;
        while (!queue.isEmpty()) {
            while ((node = queue.poll()) != null) {
                list.add(node);
                if (node.children != null) {
                    node.children.forEach(e -> queue.offer(e));
                }
            }
        }
        return list;
    }
}
