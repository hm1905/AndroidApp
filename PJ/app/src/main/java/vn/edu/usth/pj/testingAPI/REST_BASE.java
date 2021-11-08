package vn.edu.usth.pj.testingAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import vn.edu.usth.pj.testingAPI.Explore.Example;

public interface REST_BASE {
    @GET("feed/featured/{yyyy}/{mm}/{dd}")
    Call<Example> getExplore(@Path("yyyy") String yyyy, @Path("mm") String mm, @Path("dd") String dd);

}
