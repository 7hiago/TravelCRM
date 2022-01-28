package org.laba2.entities;

public enum Permission {

    READ("read"),
    WRITE("write"),
    EDIT("edit"),
    DELETE("delete");


    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
