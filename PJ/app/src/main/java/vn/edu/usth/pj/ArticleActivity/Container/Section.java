package vn.edu.usth.pj.ArticleActivity.Container;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Section {
    @SerializedName("toclevel")
    @Expose
    private Integer toclevel;
    @SerializedName("level")
    @Expose
    private String level;
    @SerializedName("line")
    @Expose
    private String line;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("index")
    @Expose
    private String index;
    @SerializedName("fromtitle")
    @Expose
    private String fromtitle;
    @SerializedName("byteoffset")
    @Expose
    private Integer byteoffset;
    @SerializedName("anchor")
    @Expose
    private String anchor;

    public Integer getToclevel() {
        return toclevel;
    }

    public void setToclevel(Integer toclevel) {
        this.toclevel = toclevel;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getFromtitle() {
        return fromtitle;
    }

    public void setFromtitle(String fromtitle) {
        this.fromtitle = fromtitle;
    }

    public Integer getByteoffset() {
        return byteoffset;
    }

    public void setByteoffset(Integer byteoffset) {
        this.byteoffset = byteoffset;
    }

    public String getAnchor() {
        return anchor;
    }

    public void setAnchor(String anchor) {
        this.anchor = anchor;
    }
}
