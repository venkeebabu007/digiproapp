package com.arkmedis.digipro.utility;

public enum Role {
    EMPLOYEE,
    MANAGER,
    ADMIN,
    CLIENT;

    // Method to handle case-insensitive enum value mapping
    public static Role fromString(String role) {
        if (role != null) {
            try {
                return Role.valueOf(role.toUpperCase()); // Convert to uppercase before mapping
            } catch (IllegalArgumentException ex) {
                throw new RuntimeException("Invalid role: " + role);
            }
        }
        return null; // Return null if role is invalid
    }
}

