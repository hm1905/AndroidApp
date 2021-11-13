package vn.edu.usth.pj.RestAPI.Explore.mostread;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Mostread {
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("articles")
    @Expose
    private List<Article> articles = null;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
