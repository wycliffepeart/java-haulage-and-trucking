package org.jht.support;

public enum Role {

    ADMIN("ADMIN"),
    STAFF("STAFF");

    private final String name;

     private Role(String name){
         this.name = name;
     }

    @Override
    public String toString() {
        return this.name;
    }
}
