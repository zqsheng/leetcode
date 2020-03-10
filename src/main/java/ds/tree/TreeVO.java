package ds.tree;

import lombok.Data;

import java.util.List;

/**
 *  树型结构VO模版
 * @param <VO>  实体类型
 * @param <K>  主键类型
 * @param <V>  值类型(暂时无意义)
 */
@Data
public abstract class TreeVO<VO extends TreeVO<VO,K,V>,K,V> implements Node<K,V> {

    private K id;
    private String name;
    private K pid;
    private List<VO> children;

}
