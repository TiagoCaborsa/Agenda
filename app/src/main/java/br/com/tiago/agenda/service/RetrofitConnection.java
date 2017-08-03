package br.com.tiago.agenda.service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by TiagoCabral on 8/1/2017.
 */

public class RetrofitConnection {

    private static final OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
    private static final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    private static final HttpLoggingInterceptor.Level loggingLevel = HttpLoggingInterceptor.Level.BODY;
    private static final String BASE_URL = "https://powerful-mesa-50660.herokuapp.com/";

    public static <T> T connect(Class<T> serviceClass) {
        loggingInterceptor.setLevel(loggingLevel);
        httpClientBuilder.interceptors().add(loggingInterceptor);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());

        OkHttpClient httpClient = httpClientBuilder
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }

}
