package ds.tree;

/**
 * 授权检查
 */
@FunctionalInterface
public interface Authorizable {

   boolean checkAuthority(Object context,Object subject);
}
