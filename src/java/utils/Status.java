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
public enum Status {
     ACCEPTED("ACCEPTED", "3"), DENIED("DENIED", "2"), SUBMITTED("SUBMITTED", "1");

    private final String key;
    private final String value;

    Status(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }
    
    public static Status findByValue(String status){
    for(Status s : values()){
        if( s.getValue().equals(status)){
            return s;
        }
    }
    return null;
}
}
