package com.example.hangmangame.data.remote;

import com.example.hangmangame.data.model.ResponseHangman;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HangmanApi {

    @GET("hangman.php")
    Call<ResponseHangman> getWordAndTrick();

}
