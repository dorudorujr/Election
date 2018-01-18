
package com.example.g015c1308.election2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results {

    @SerializedName("staus")
    @Expose
    private Integer staus;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("manifesto")
    @Expose
    private List<Manifesto> manifesto = null;
    @SerializedName("name")
    @Expose
    private List<Name> name = null;

    public Integer getStaus() {
        return staus;
    }

    public void setStaus(Integer staus) {
        this.staus = staus;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public List<Manifesto> getManifesto() {
        return manifesto;
    }

    public void setManifesto(List<Manifesto> manifesto) {
        this.manifesto = manifesto;
    }

    public List<Name> getName() {
        return name;
    }

    public void setName(List<Name> name) {
        this.name = name;
    }

}
