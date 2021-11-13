package vn.edu.usth.pj.ArticleActivity.Container;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Parse {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("pageid")
    @Expose
    private Integer pageid;
    @SerializedName("sections")
    @Expose
    private List<Section> sections = null;

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

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
