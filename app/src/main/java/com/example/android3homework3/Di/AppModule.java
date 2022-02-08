package com.example.android3homework3.Di;


import com.example.android3homework3.Data.apiservice.ApiService;
import com.example.android3homework3.Data.repositories.WeatherRepositories;
import java.util.concurrent.TimeUnit;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public abstract class AppModule {

    @Provides
    public static WeatherRepositories provideWeatherRepository(ApiService apiService){
        return new WeatherRepositories(apiService );
    }

    @Provides
    public static ApiService provideApi(Retrofit retrofit){
        return retrofit.create(ApiService.class );
    }

    @Provides
    public static Retrofit provideRetrofit(OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    public static OkHttpClient provideOkhttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY)
                )
                .build();
    }
}
