package org.example.entity;

import java.util.Date;

public abstract class BaseEntity {
    private String id;

    public void getName() {
        System.out.println(this.getClass().getName());
    }
}
