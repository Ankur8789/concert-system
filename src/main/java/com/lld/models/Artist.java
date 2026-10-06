package com.lld.models;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;


@Getter 
@Setter 
public class Artist {
    private String id;
    private String name;
    private String desc;

    // generic info about Artist

    public Artist(String name, String desc){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.desc = desc;
    }

}
