package vn.edu.usth.pj.testingAPI.Explore.tfa;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tfa {
    @SerializedName("type")
    @Expose
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("displaytitle")
    @Expose
    private String displaytitle;


    @SerializedName("titles")
    @Expose
    private Titles titles;
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
    private Thumbnail thumbnail;
    @SerializedName("originalimage")
    @Expose
    private Originalimage originalimage;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("dir")
    @Expose
    private String dir;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDisplaytitle() {
        return displaytitle;
    }

    public void setDisplaytitle(String displaytitle) {
        this.displaytitle = displaytitle;
    }

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("coordinates")
    @Expose
    private Coordinates coordinates;

    public Titles getTitles() {
        return titles;
    }

    public void setTitles(Titles titles) {
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

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Originalimage getOriginalimage() {
        return originalimage;
    }

    public void setOriginalimage(Originalimage originalimage) {
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

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
