package vn.edu.usth.pj.testingAPI.Explore.image;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Description {
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("lang")
    @Expose
    private String lang;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
