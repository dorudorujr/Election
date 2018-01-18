package com.example.g015c1308.election2;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by G015C1308 on 2018/01/10.
 */

public class ManifestoModel extends RealmObject {
    @PrimaryKey
    private int id;
    private String nameid;
    private String manifesto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameid() {
        return nameid;
    }

    public void setNameid(String nameid) {
        this.nameid = nameid;
    }

    public String getManifesto() {
        return manifesto;
    }

    public void setManifesto(String manifesto) {
        this.manifesto = manifesto;
    }
}
