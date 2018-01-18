package com.example.g015c1308.election2;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by G015C1308 on 2018/01/07.
 */

public class RegionModel extends RealmObject {
    @PrimaryKey
    private int id;
    private String large_region;
    private String small_region;
    private String created_at;
    private String  updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLarge_region() {
        return large_region;
    }

    public void setLarge_region(String large_region) {
        this.large_region = large_region;
    }

    public String getSmall_region() {
        return small_region;
    }

    public void setSmall_region(String small_region) {
        this.small_region = small_region;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
