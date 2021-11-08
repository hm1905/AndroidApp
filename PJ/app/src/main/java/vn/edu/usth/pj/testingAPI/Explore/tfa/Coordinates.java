package vn.edu.usth.pj.testingAPI.Explore.tfa;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coordinates {
    @SerializedName("lat")
    @Expose
    private Integer lat;
    @SerializedName("lon")
    @Expose
    private Integer lon;

    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }

    public Integer getLon() {
        return lon;
    }

    public void setLon(Integer lon) {
        this.lon = lon;
    }
}
