package vn.edu.usth.pj.testingAPI.Explore.mostread;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Article {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("normalizedtitle")
    @Expose
    private String normalizedtitle;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("thumbnail")
    @Expose
    private Thumbnail__1 thumbnail;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("extract")
    @Expose
    private String extract;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNormalizedtitle() {
        return normalizedtitle;
    }

    public void setNormalizedtitle(String normalizedtitle) {
        this.normalizedtitle = normalizedtitle;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Thumbnail__1 getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail__1 thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExtract() {
        return extract;
    }

    public void setExtract(String extract) {
        this.extract = extract;
    }
}
