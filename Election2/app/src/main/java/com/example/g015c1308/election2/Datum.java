
package com.example.g015c1308.election2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("largeregion")
    @Expose
    private String largeregion;
    @SerializedName("smallregion")
    @Expose
    private String smallregion;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLargeregion() {
        return largeregion;
    }

    public void setLargeregion(String largeregion) {
        this.largeregion = largeregion;
    }

    public String getSmallregion() {
        return smallregion;
    }

    public void setSmallregion(String smallregion) {
        this.smallregion = smallregion;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
