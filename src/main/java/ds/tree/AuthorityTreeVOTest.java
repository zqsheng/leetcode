package ds.tree;

import lombok.Data;

import java.security.Permission;

public class AuthorityTreeVOTest {

    @Data
    static class Dept implements Node<Integer,String> {
        private Integer id;
        private String name;
        private Integer pid;
    }

    @Data
    static class User {
        private Integer id;
        private String name;
        private Integer deptId;
    }
    @Data
    static class Role {
        private Integer id;
        private String name;
        private String code;
    }
    @Data
    static class Permission implements Node<Integer,String> {
        private Integer id;
        private String name;
        private Integer pid;
    }

    @Data
    static class UserRole {
        private Integer userId;
        private Integer roleId;
        private Integer deptId;
    }

    @Data
    static class RolePermission {
        private Integer roleId;
        private Integer permissionId;
    }
}
