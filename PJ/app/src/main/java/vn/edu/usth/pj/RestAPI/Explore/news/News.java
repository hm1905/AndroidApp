package vn.edu.usth.pj.RestAPI.Explore.news;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class News {
    @SerializedName("story")
    @Expose
    private String story;
    @SerializedName("links")
    @Expose
    private List<Link> links = null;

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
