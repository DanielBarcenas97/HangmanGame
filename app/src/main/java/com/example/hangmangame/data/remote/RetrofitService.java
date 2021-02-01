package com.example.hangmangame.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static final String BASE_URL = "https://www.serverbpw.com/cm/2021-1/";

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static <S> S getApi(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

}

