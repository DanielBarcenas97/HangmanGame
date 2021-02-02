package com.example.hangmangame;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hangmangame.data.model.ResponseHangman;
import com.example.hangmangame.databinding.FragmentGamePlayBinding;
import com.example.hangmangame.viewModel.DataViewModel;

import java.util.ArrayList;

public class GameFragment extends Fragment {


    private DataViewModel dataViewModel;

    public static final int MAX_ERRORS = 6;
    private String wordToFind;
    private char[] wordFound;
    private int nbErrors;
    private ArrayList<String> letters = new ArrayList<>();

    private FragmentGamePlayBinding Binding;
    private NavController navController;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Binding = FragmentGamePlayBinding.inflate(inflater,container,false);
        View view = Binding.getRoot();
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        configView();

    }

    private void configView() {
        dataViewModel = new ViewModelProvider(this).get(DataViewModel.class);
        final Observer<ResponseHangman> observer = new Observer<ResponseHangman>() {
            @Override
            public void onChanged(ResponseHangman responseHangman) {
                String category = responseHangman.getCategory();
                String word = responseHangman.getWord();
                Binding.trick.setText(category);
            }
        };

        dataViewModel.getHangmanRepository().observe(getViewLifecycleOwner(),observer);

       Binding.btnRestart.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               dataViewModel.getHangmanRepository();
           }
       });


    }



}