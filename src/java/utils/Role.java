/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author adrie
 */
public enum Role {
    ADMIN("ADMIN", "1"), ACCOUNTANT("ACCOUNTANT", "2"), EMPLOYEE("EMPLOYEE", "3");

    private final String key;
    private final String value;

    Role(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }
}
