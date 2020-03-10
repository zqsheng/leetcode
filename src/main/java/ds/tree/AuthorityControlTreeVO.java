package ds.tree;

import lombok.Data;

/**
 * 授权控制节点
 * @param <VO>
 * @param <K>
 * @param <V>
 */
@Data
public abstract class AuthorityControlTreeVO<VO extends AuthorityControlTreeVO<VO,K,V>,K,V> extends TreeVO<VO,K,V> implements Authorizable {

    private boolean isAuthorized;

}
