package vn.edu.usth.pj.RestAPI;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import vn.edu.usth.pj.Article_Activity.Article_FM;
import vn.edu.usth.pj.Article_Activity.Container.Contain;
import vn.edu.usth.pj.MainPage.Articles;
import vn.edu.usth.pj.SearchActivity.Example;

public interface RetrofitAPI {
    @GET(API_CER.API + "action=parse&prop=text&mobileformat=1&page=Main_Page")
    Call<Articles> getArticles();

    @GET (API_CER.API + "action=query&converttitles=&prop=description|pageimages|pageprops|info&ppprop=mainpage|disambiguation&generator=search&gsrnamespace=0&gsrwhat=text&inprop=varianttitles&gsrinfo=&gsrprop=redirecttitle&piprop=thumbnail&pilicense=any&pithumbsize=320")
    Call<Example> getQuery(@retrofit2.http.Query("gsrsearch") String gsrsearch);

    @GET(API_CER.API +"action=parse&prop=text&mobileformat=1")
    Call<Article_FM> getArticle_Page(@Query("pageid") Integer pageid);

    @GET(API_CER.API +"action=parse&prop=sections&mobileformat=1")
    Call<Contain> getContain(@Query("pageid") Integer pageid);

}
