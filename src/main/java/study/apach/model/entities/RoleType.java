package study.apach.model.entities;

public enum RoleType {

    CUSTOMER("customer"),
    MANAGER("manager"),
    ADMIN("admin");

    RoleType(String roleType) {
        this.roleType = roleType;
    }

    private String roleType;

    public String getRoleType() {
        return roleType;
    }

    public static boolean contains(String type) {
        boolean result = false;
        for (RoleType roleType : RoleType.values()) {
            if (roleType.getRoleType().equals(type)) {
                result = true;
            }
        }
        return result;
    }
}
