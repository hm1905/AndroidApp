package vn.edu.usth.pj.ActionAPI.WikiMainPage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainPage {
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
