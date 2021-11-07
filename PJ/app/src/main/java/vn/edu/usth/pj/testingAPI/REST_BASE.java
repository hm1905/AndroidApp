package vn.edu.usth.pj.testingAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface REST_BASE {
    @GET("page/mobile-sections/Main-Page")
    Call<Example> getSample();

}
