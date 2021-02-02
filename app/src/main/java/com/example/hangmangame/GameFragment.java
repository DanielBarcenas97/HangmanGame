package com.example.hangmangame;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hangmangame.data.model.ResponseHangman;
import com.example.hangmangame.databinding.FragmentGamePlayBinding;
import com.example.hangmangame.viewModel.DataViewModel;

import java.text.MessageFormat;
import java.util.ArrayList;

public class GameFragment extends Fragment implements View.OnClickListener {


    private DataViewModel dataViewModel;
    private FragmentGamePlayBinding Binding;
    private NavController navController;
    public static final int MAX_ERRORS = 6;
    private final ArrayList<String> secretWord = new ArrayList<>();
    private final ArrayList<String> secretWord2 = new ArrayList<>();
    private Boolean turn = false;
    private int errors = 0;


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
        init();
        configView();
    }

    private void init() {
        Binding.letterA.setOnClickListener(this);
        Binding.letterB.setOnClickListener(this);
        Binding.letterC.setOnClickListener(this);
        Binding.letterD.setOnClickListener(this);
        Binding.letterE.setOnClickListener(this);
        Binding.letterF.setOnClickListener(this);
        Binding.letterG.setOnClickListener(this);
        Binding.letterH.setOnClickListener(this);
        Binding.letterI.setOnClickListener(this);
        Binding.letterJ.setOnClickListener(this);
        Binding.letterK.setOnClickListener(this);
        Binding.letterL.setOnClickListener(this);
        Binding.letterL.setOnClickListener(this);
        Binding.letterM.setOnClickListener(this);
        Binding.letterN.setOnClickListener(this);
        Binding.letterNn.setOnClickListener(this);
        Binding.letterO.setOnClickListener(this);
        Binding.letterP.setOnClickListener(this);
        Binding.letterQ.setOnClickListener(this);
        Binding.letterR.setOnClickListener(this);
        Binding.letterS.setOnClickListener(this);
        Binding.letterT.setOnClickListener(this);
        Binding.letterU.setOnClickListener(this);
        Binding.letterW.setOnClickListener(this);
        Binding.letterX.setOnClickListener(this);
        Binding.letterY.setOnClickListener(this);
        Binding.letterZ.setOnClickListener(this);
    }

    private void configView() {
        dataViewModel = new ViewModelProvider(this).get(DataViewModel.class);
        final Observer<ResponseHangman> observer = new Observer<ResponseHangman>() {
            @Override
            public void onChanged(ResponseHangman responseHangman) {
                String category = responseHangman.getCategory();
                String word = responseHangman.getWord();
                initGame(word,category);
            }
        };

        dataViewModel.getHangmanRepository().observe(getViewLifecycleOwner(),observer);

        Binding.btnRestart.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               dataViewModel.getHangmanRepository();
               errors = 0;
               Binding.img.setImageResource(R.drawable.vacio);
               Binding.keyboard.setVisibility(View.VISIBLE);
               Binding.gameOver.setVisibility(View.GONE);
               Binding.btnRestart.setVisibility(View.GONE);

           }
       });
    }

    private void initGame(String word, String category) {
        secretWord2.clear();
        secretWord.clear();
        //Convert to ArrayList
        for(int i = 0; i<word.length(); i++){
            secretWord.add(String.valueOf(word.charAt(i)));
        }

        for(int i=0; i<secretWord.size(); i++){
            secretWord2.add(i," _ ");
        }

        //Secret Word
        Binding.wordTv.setText(convertToString(secretWord2));

        //Tip
        Binding.trick.setText(MessageFormat.format("{0}{1}",
                getString(R.string.trick), category + word));
    }

    private String convertToString(ArrayList<String> arrayWord){
        StringBuilder sb = new StringBuilder();
        for (String s : arrayWord) {
            sb.append(s);
            sb.append(" ");
        }
        return sb.toString();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        char letter;
        turn = false;

        if(errors < MAX_ERRORS){
            switch (view.getId()) {
                case R.id.letter_a:
                    letter = 'a';
                    break;

                case R.id.letter_b:
                    letter = 'b';
                    break;

                case R.id.letter_c:
                    letter = 'c';
                    break;

                case R.id.letter_d:
                    letter = 'd';
                    break;

                case R.id.letter_e:
                    letter = 'e';
                    break;

                case R.id.letter_f:
                    letter = 'f';
                    break;
                case R.id.letter_g:
                    letter = 'g';
                    break;
                case R.id.letter_h:
                    letter = 'h';
                    break;

                case R.id.letter_i:
                    letter = 'i';
                    break;

                case R.id.letter_j:
                    letter = 'j';
                    break;

                case R.id.letter_k:
                    letter = 'k';
                    break;

                case R.id.letter_l:
                    letter = 'l';
                    break;

                case R.id.letter_m:
                    letter = 'm';
                    break;

                case R.id.letter_n:
                    letter = 'n';
                    break;

                case R.id.letter_nn:
                    letter = 'ñ';
                    break;

                case R.id.letter_o:
                    letter = 'o';
                    break;

                case R.id.letter_p:
                    letter = 'p';
                    break;

                case R.id.letter_q:
                    letter = 'q';
                    break;

                case R.id.letter_r:
                    letter = 'r';
                    break;

                case R.id.letter_s:
                    letter = 's';
                    break;

                case R.id.letter_t:
                    letter = 't';
                    break;

                case R.id.letter_v:
                    letter = 'v';
                    break;

                case R.id.letter_w:
                    letter = 'w';
                    break;

                case R.id.letter_x:
                    letter = 'x';
                    break;

                case R.id.letter_y:
                    letter = 'y';
                    break;

                case R.id.letter_u:
                    letter = 'u';
                    break;

                case R.id.letter_z:
                    letter = 'z';
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + view.getId());
            }
            searchLetterInArray(String.valueOf(letter));
        }
    }

    private void searchLetterInArray(String letter) {

        //Draw in TextView
        for(int i=0; i<secretWord.size(); i++){
            if(letter.equals(secretWord.get(i))){
                turn = true;
                secretWord2.set(i, letter);
            }else{
                if(letter.equals(" _ ")){
                    secretWord2.set(i, " _ ");
                }

            }
        }

        //Validation Game
        validationGame(turn);

        //Text Response
        Binding.wordTv.setText(convertToString(secretWord2));

    }

    private void validationGame(Boolean turn) {
        if(!turn){
            errors +=1;
            switch (errors){
                case 1:
                    Binding.img.setImageResource(R.drawable.strike1);
                    break;
                case 2:
                    Binding.img.setImageResource(R.drawable.strike2);
                    break;
                case 3:
                    Binding.img.setImageResource(R.drawable.strike3);
                    break;
                case 4:
                    Binding.img.setImageResource(R.drawable.strike4);
                    break;
                case 5:
                    Binding.img.setImageResource(R.drawable.strike5);
                    break;
                case 6:
                    Binding.img.setImageResource(R.drawable.loser);
                    Binding.keyboard.setVisibility(View.GONE);
                    Binding.gameOver.setVisibility(View.VISIBLE);
                    Binding.gameOver.setText(R.string.game_over);
                    Binding.btnRestart.setVisibility(View.VISIBLE);
                    Binding.btnRestart.setText(R.string.restart);
                    break;
            }
        }else{
            if(secretWord.equals(secretWord2)){
                Binding.img.setImageResource(R.drawable.hangman1);
                Binding.keyboard.setVisibility(View.GONE);
                Binding.gameOver.setVisibility(View.VISIBLE);
                Binding.gameOver.setText(R.string.win);
                Binding.btnRestart.setVisibility(View.VISIBLE);
                Binding.btnRestart.setText(R.string.play_again);
            }
        }
    }
}