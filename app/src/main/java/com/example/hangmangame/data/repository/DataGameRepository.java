package com.example.hangmangame.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.hangmangame.data.model.ResponseHangman;
import com.example.hangmangame.data.remote.HangmanApi;
import com.example.hangmangame.data.remote.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataGameRepository {

    private static HangmanApi hangmanApi;

    private final MutableLiveData<ResponseHangman> responseData = new MutableLiveData<>();

    private static DataGameRepository dataGameRepository;

    public static DataGameRepository getInstance(){
        if(dataGameRepository == null) {
            dataGameRepository = new DataGameRepository();
        }
        return dataGameRepository;
    }


    public DataGameRepository(){
        hangmanApi = RetrofitService.getInterface();
    }

    public MutableLiveData<ResponseHangman> getResponse(){
        Call<ResponseHangman> responseHangmanCall = hangmanApi.getWordAndTrick();

        responseHangmanCall.enqueue(new Callback<ResponseHangman>() {
            @Override
            public void onResponse(Call<ResponseHangman> call, Response<ResponseHangman> response) {
                responseData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseHangman> call, Throwable t) {
                responseData.postValue(null);
            }
        });

        return responseData;
    }





}
