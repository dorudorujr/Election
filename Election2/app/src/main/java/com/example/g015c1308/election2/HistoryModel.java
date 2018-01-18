package com.example.g015c1308.election2;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by G015C1308 on 2018/01/14.
 */

public class HistoryModel extends RealmObject {
    @PrimaryKey
    private int id;
    private String name;
    private int nameIdHistory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNameIdHistory() {
        return nameIdHistory;
    }

    public void setNameIdHistory(int nameIdHistory) {
        this.nameIdHistory = nameIdHistory;
    }
}
