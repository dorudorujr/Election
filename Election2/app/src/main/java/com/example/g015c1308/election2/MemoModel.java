package com.example.g015c1308.election2;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by G015C1308 on 2018/01/12.
 */

public class MemoModel extends RealmObject {
    @PrimaryKey
    private int id;
    private String impression;
    private String expectation;
    private String etc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImpression() {
        return impression;
    }

    public void setImpression(String impression) {
        this.impression = impression;
    }

    public String getExpectation() {
        return expectation;
    }

    public void setExpectation(String expectation) {
        this.expectation = expectation;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }
}
