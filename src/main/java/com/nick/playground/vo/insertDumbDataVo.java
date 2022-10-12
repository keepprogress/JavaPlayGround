package com.nick.playground.vo;

import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Value;

public class insertDumbDataVo {

    @NotNull
    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "insertDumbDataVo{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
