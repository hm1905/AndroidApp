package vn.edu.usth.pj.testingAPI.Explore.image;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("thumbnail")
    @Expose
    private Thumbnail__3 thumbnail;
    @SerializedName("image")
    @Expose
    private Image__1 image;
    @SerializedName("description")
    @Expose
    private Description description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Thumbnail__3 getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail__3 thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Image__1 getImage() {
        return image;
    }

    public void setImage(Image__1 image) {
        this.image = image;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }
}
