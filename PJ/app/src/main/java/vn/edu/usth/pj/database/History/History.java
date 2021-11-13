package vn.edu.usth.pj.Database.History;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "History")
public class History {
    @PrimaryKey
    private Integer pageid;
    private String title;
    private String thumbnail;

    public Integer getPageid() {
        return pageid;
    }

    public void setPageid(Integer pageid) {
        this.pageid = pageid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public History(Integer pageid, String title, String thumbnail) {
        this.pageid = pageid;
        this.title = title;
        this.thumbnail = thumbnail;
    }
}
