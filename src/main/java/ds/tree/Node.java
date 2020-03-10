package ds.tree;

import java.util.List;

/**
 * Created by zqsheng on 2019/11/?
 *
 * @author zqsheng
 * @decription 多节点树形结构节点
 * T 主键类型
 * V 值类型(暂时无意义)
 */
public interface Node<T,V> {
    /**
     * 节点唯一标识
     * @return
     */
    T getId();

    /**
     * 节点名称
     * @return
     */
    String getName();

    /**
     * 父节点ID
     * @return
     */
    T getPid();

    /**
     *  用于前端的视图控制
     *  节点level(深度)
     * @return
     */
    default Integer getLv() { return null; }

    default void setLv(Integer level) { }
    // 以下属性 在特定数据结构下使用
    /**
     * 节点值
     * @return
     */
    default V getValue() { return null;}

    default void setValue(V val) {}

//    /**
//     * 子节点
//     *
//     * @param children
//     */
//    default <E extends Node<T,V>> void setChildren(List<E> children) {
//    }
//
//    default <E extends Node<T,V>> List<E> getChildren() { return null;}
//
//    /**
//     * 权重
//     * @param val
//     */
//    default void setWeight(double val) {}
//
//    default double getWeight() {return 0;}
//
//    /**
//     * 标志
//     * @param tag
//     */
//    default void setTag(int tag) {}
//
//    default int getTag() {return 0;}

    class Comparator implements java.util.Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.getLv() - o2.getLv();
        }
    }
}
