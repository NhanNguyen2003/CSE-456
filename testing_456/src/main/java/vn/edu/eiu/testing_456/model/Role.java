package vn.edu.eiu.testing_456.model;

public enum Role {
    ADMIN(1),
    STAFF(2),
    CUSTOMER(3);

    private final int value;

    Role(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // Nếu cần convert từ int -> enum
    public static Role fromValue(int value) {
        for (Role role : Role.values()) {
            if (role.value == value) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid role value: " + value);
    }
}
