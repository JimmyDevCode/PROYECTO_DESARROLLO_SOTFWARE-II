package com.ferrosac.auth.config;

public enum ApplicationRol {


    ADMINISTRADOR("ADMINISTRADOR"),
    JEFE_DE_COMPRAS("JEFE DE COMPRAS"),
    JEFE_DE_ALMACEN("JEFE DE ALMACEN"),
    OPERARIO_DE_ALMACEN("OPERARIO DE ALMACEN");

    private static final String ROLE_PREFIX = "ROLE_";
    private final String name;

    ApplicationRol(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getFullRoleName() {
        return name;
    }
}
