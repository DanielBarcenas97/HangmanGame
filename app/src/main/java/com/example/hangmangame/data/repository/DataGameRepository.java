package com.example.hangmangame.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.hangmangame.data.model.ResponseHangman;
import com.example.hangmangame.data.remote.HangmanApi;
import com.example.hangmangame.data.remote.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataGameRepository {

    private static DataGameRepository dataGameRepository;
    private HangmanApi hangmanApi;

    public static DataGameRepository getInstance(){
        if(dataGameRepository == null) {
            dataGameRepository = new DataGameRepository();
        }

        return dataGameRepository;
    }

    public DataGameRepository(){
        hangmanApi = RetrofitService.getApi(HangmanApi.class);
    }

    public MutableLiveData<ResponseHangman> getWordAndTrick(){
        MutableLiveData<ResponseHangman> data = new MutableLiveData<>();

        hangmanApi.getWordAndTrick().enqueue(new Callback<ResponseHangman>() {
            @Override
            public void onResponse(Call<ResponseHangman> call,
                                   Response<ResponseHangman> response) {
                if (response.isSuccessful()){
                    data.setValue(response.body());
                    //data.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ResponseHangman> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }



}
