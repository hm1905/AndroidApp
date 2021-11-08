package vn.edu.usth.pj.testingAPI;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.edu.usth.pj.RestAPI.API_CER;

public class Service2 {
    private static Retrofit.Builder retrofitbuild2 =
            new Retrofit.Builder()
                    .baseUrl(API_REST.BASE_REST)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit2 = retrofitbuild2.build();


    private static OkHttpClient.Builder httpClient2 = new OkHttpClient.Builder();

    private static HttpLoggingInterceptor logging2 = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);


    public static <S> S createService2(
            Class<S> serviceClass2) {
        if (!httpClient2.interceptors().contains(logging2)) {
            httpClient2.addInterceptor(logging2);
            retrofitbuild2.client(httpClient2.build());
            retrofit2 = retrofitbuild2.build();
        }

        return retrofit2.create(serviceClass2);
    }
}
