package com.example.zadadadankozinformatora;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LinearLayout main;
    ImageView imageViewZdjeciaKotow;
    Button buttonPrev;
    Button buttonNext;
    EditText editTextNumerObrazu;
    Switch switchTloNiebieskie;
    int wyswietlaneZdjecie = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imageViewZdjeciaKotow = findViewById(R.id.imageViewZdjeciaKotow);
        buttonPrev = findViewById(R.id.buttonPrev);
        buttonNext = findViewById(R.id.buttonNext);
        editTextNumerObrazu = findViewById(R.id.editTextNumerObrazu);
        switchTloNiebieskie = findViewById(R.id.switchTloNiebieskie);
        main = findViewById(R.id.main);

        ArrayList<Integer> zdjeciaKotow = new ArrayList<>();
        zdjeciaKotow.add(R.drawable.kot1);
        zdjeciaKotow.add(R.drawable.kot2);
        zdjeciaKotow.add(R.drawable.kot3);

        imageViewZdjeciaKotow.setImageResource(zdjeciaKotow.get(0));

        switchTloNiebieskie.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (switchTloNiebieskie.isChecked()){
                    main.setBackgroundColor(Color.parseColor("#1565c0"));
                }
                else{
                    main.setBackgroundColor(Color.parseColor("#00796B"));
                }
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (wyswietlaneZdjecie < 2){
                    wyswietlaneZdjecie ++;
                } else if (wyswietlaneZdjecie == 2) {
                    wyswietlaneZdjecie = 0;
                }
                imageViewZdjeciaKotow.setImageResource(zdjeciaKotow.get(wyswietlaneZdjecie));
            }
        });

        buttonPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (wyswietlaneZdjecie > 0){
                    wyswietlaneZdjecie --;
                } else if (wyswietlaneZdjecie == 0) {
                    wyswietlaneZdjecie = 2;
                }
                imageViewZdjeciaKotow.setImageResource(zdjeciaKotow.get(wyswietlaneZdjecie));
            }
        });

        editTextNumerObrazu.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editTextNumerObrazu.getText().toString().equals("")
                        || Integer.parseInt(editTextNumerObrazu.getText().toString()) > 3
                        || Integer.parseInt(editTextNumerObrazu.getText().toString()) < 1){

                }
                else{
                    int indexObrazu = Integer.parseInt(editTextNumerObrazu.getText().toString()) - 1;
                    imageViewZdjeciaKotow.setImageResource(zdjeciaKotow.get(indexObrazu));
                }
            }
        });
    }
}