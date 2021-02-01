package com.example.hangmangame;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hangmangame.data.model.ResponseHangman;
import com.example.hangmangame.databinding.FragmentGameBinding;
import com.example.hangmangame.viewModel.DataViewModel;

public class GameFragment extends Fragment {

    private FragmentGameBinding Binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Binding = FragmentGameBinding.inflate(inflater,container,false);
        View view = Binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}