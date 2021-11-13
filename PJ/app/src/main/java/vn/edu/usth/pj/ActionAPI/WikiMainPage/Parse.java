package vn.edu.usth.pj.ActionAPI.WikiMainPage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parse {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("pageid")
    @Expose
    private Integer pageid;
    @SerializedName("text")
    @Expose
    private String text;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPageid() {
        return pageid;
    }

    public void setPageid(Integer pageid) {
        this.pageid = pageid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
