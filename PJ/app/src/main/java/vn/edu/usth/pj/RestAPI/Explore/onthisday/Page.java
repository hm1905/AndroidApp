package vn.edu.usth.pj.RestAPI.Explore.onthisday;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Page {
    @SerializedName("titles")
    @Expose
    private Titles__2 titles;
    @SerializedName("pageid")
    @Expose
    private Integer pageid;
    @SerializedName("extract")
    @Expose
    private String extract;
    @SerializedName("extract_html")
    @Expose
    private String extractHtml;
    @SerializedName("thumbnail")
    @Expose
    private Thumbnail__4 thumbnail;
    @SerializedName("originalimage")
    @Expose
    private Originalimage__2 originalimage;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("dir")
    @Expose
    private String dir;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("coordinates")
    @Expose
    private Coordinates__2 coordinates;

    public Titles__2 getTitles() {
        return titles;
    }

    public void setTitles(Titles__2 titles) {
        this.titles = titles;
    }

    public Integer getPageid() {
        return pageid;
    }

    public void setPageid(Integer pageid) {
        this.pageid = pageid;
    }

    public String getExtract() {
        return extract;
    }

    public void setExtract(String extract) {
        this.extract = extract;
    }

    public String getExtractHtml() {
        return extractHtml;
    }

    public void setExtractHtml(String extractHtml) {
        this.extractHtml = extractHtml;
    }

    public Thumbnail__4 getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail__4 thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Originalimage__2 getOriginalimage() {
        return originalimage;
    }

    public void setOriginalimage(Originalimage__2 originalimage) {
        this.originalimage = originalimage;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Coordinates__2 getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates__2 coordinates) {
        this.coordinates = coordinates;
    }
}
