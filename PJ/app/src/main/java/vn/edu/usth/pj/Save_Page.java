package vn.edu.usth.pj;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Saved")
public class Save_Page {
    @PrimaryKey
    private Integer pageid;
    private String title;
    private String desc;
    private String thumbnail;

    public Integer getPageid() {
        return pageid;
    }

    public void setPageid(Integer pageid) {
        this.pageid = pageid;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Save_Page(String title, String desc, Integer pageid, String thumbnail) {
        this.pageid = pageid;
        this.title = title;
        this.desc = desc;
        this.thumbnail = thumbnail;
    }
}
