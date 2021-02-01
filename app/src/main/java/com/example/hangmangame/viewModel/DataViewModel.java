package com.example.hangmangame.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hangmangame.data.model.ResponseHangman;
import com.example.hangmangame.data.repository.DataGameRepository;

public class DataViewModel extends ViewModel {

    private MutableLiveData<ResponseHangman> mutableLiveData;
    private DataGameRepository dataGameRepository;

    public DataViewModel() {
       mutableLiveData = new MutableLiveData<>();
        dataGameRepository = DataGameRepository.getInstance();
    }

    public MutableLiveData<ResponseHangman>  getHangmanRepository(){
        mutableLiveData = dataGameRepository.getResponse();
        return mutableLiveData;
    }

}
