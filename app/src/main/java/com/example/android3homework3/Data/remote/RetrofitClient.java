package com.example.android3homework3.Data.remote;
import com.example.android3homework3.Data.apiservice.ApiService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private OkHttpClient okHttpClient =
            new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(new HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.BODY)
                    )
                    .build();

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build();

    public ApiService provideApi() {
        return retrofit.create(ApiService.class);
    }
}
