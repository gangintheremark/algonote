package com.algorithm.Algonote.model;

import lombok.Getter;

@Getter
public enum MemberRole {
    AdMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    MemberRole(String value){
        this.value = value;
    }

    private String value;
}
