package vn.edu.usth.pj.Article_Activity.Container;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contain {
    @SerializedName("parse")
    @Expose
    private Parse parse;

    public Parse getParse() {
        return parse;
    }

    public void setParse(Parse parse) {
        this.parse = parse;
    }

}
