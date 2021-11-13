package vn.edu.usth.pj.RestAPI.Explore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import vn.edu.usth.pj.RestAPI.Explore.image.Image;
import vn.edu.usth.pj.RestAPI.Explore.mostread.Mostread;
import vn.edu.usth.pj.RestAPI.Explore.news.News;
import vn.edu.usth.pj.RestAPI.Explore.onthisday.Onthisday;
import vn.edu.usth.pj.RestAPI.Explore.tfa.Tfa;

public class Example {
    @SerializedName("tfa")
    @Expose
    private Tfa tfa;
    @SerializedName("mostread")
    @Expose
    private Mostread mostread;
    @SerializedName("news")
    @Expose
    private List<News> news = null;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("onthisday")
    @Expose
    private List<Onthisday> onthisday = null;

    public Tfa getTfa() {
        return tfa;
    }

    public void setTfa(Tfa tfa) {
        this.tfa = tfa;
    }

    public Mostread getMostread() {
        return mostread;
    }

    public void setMostread(Mostread mostread) {
        this.mostread = mostread;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<Onthisday> getOnthisday() {
        return onthisday;
    }

    public void setOnthisday(List<Onthisday> onthisday) {
        this.onthisday = onthisday;
    }
}
