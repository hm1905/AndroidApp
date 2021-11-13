package vn.edu.usth.pj.RestAPI.Explore.onthisday;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Onthisday {
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("pages")
    @Expose
    private List<Page> pages = null;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }
}
