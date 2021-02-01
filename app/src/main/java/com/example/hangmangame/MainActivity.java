package com.example.hangmangame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;

import com.example.hangmangame.data.model.ResponseHangman;
import com.example.hangmangame.databinding.ActivityMainBinding;
import com.example.hangmangame.viewModel.DataViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DataViewModel dataViewModel;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        configView();
    }

    private void configView() {
        dataViewModel = new ViewModelProvider(this).get(DataViewModel.class);

        dataViewModel.getHangmanRepository().observe(this, responseHangman -> {
            String category = responseHangman.getCategory();
            String word = responseHangman.getWord();
            binding.dataGame.setText(word);
        });


        binding.init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.dataGame.setText("");
                dataViewModel.getHangmanRepository();
            }
        });
    }
}

