package vn.edu.usth.pj.ActionAPI;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {
    private static Retrofit.Builder retrofitbuild =
            new Retrofit.Builder()
            .baseUrl(API_CER.Base_Url)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitbuild.build();


    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static HttpLoggingInterceptor logging = new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);


    public static <S> S createService(
            Class<S> serviceClass) {
        if (!httpClient.interceptors().contains(logging)) {
            httpClient.addInterceptor(logging);
            retrofitbuild.client(httpClient.build());
            retrofit = retrofitbuild.build();
        }

        return retrofit.create(serviceClass);
    }
}
