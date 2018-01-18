package com.example.g015c1308.election2;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by G015C1308 on 2018/01/12.
 */

public class FavoriteModel extends RealmObject {
    @PrimaryKey
    private int favoriteNameId;
    private String favoritename;
    private String favoriteetc;
    private boolean favoriteflag;
    private boolean check;

    public int getFavoriteNameId() {
        return favoriteNameId;
    }

    public void setFavoriteNameId(int favoriteNameId) {
        this.favoriteNameId = favoriteNameId;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getFavoritename() {
        return favoritename;
    }

    public void setFavoritename(String favoritename) {
        this.favoritename = favoritename;
    }

    public String getFavoriteetc() {
        return favoriteetc;
    }

    public void setFavoriteetc(String favoriteetc) {
        this.favoriteetc = favoriteetc;
    }

    public boolean isFavoriteflag() {
        return favoriteflag;
    }

    public void setFavoriteflag(boolean favoriteflag) {
        this.favoriteflag = favoriteflag;
    }
}
