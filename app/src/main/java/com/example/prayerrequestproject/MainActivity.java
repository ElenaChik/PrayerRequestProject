package com.example.prayerrequestproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private TextView verse_vw;
private Button next_button;
private Button back_button;
private int currentIndex = 0;
private String[] verseArray;
private static final String KEY_INDEX = "index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verse_vw = (TextView) findViewById(R.id.verse_vw);
        next_button = (Button) findViewById(R.id.next_button);
        back_button = (Button) findViewById(R.id.back_button);

        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt(KEY_INDEX);
        }
        verseArray = verseArray();
        verse_vw.setText(verseArray[currentIndex]);

        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex + 1) % verseArray.length;
                verse_vw.setText(verseArray[currentIndex]);
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex - 1) % verseArray.length;
                verse_vw.setText(verseArray[currentIndex]);
            }
        });
    }

    public String[] verseArray() {
        String[] verses = {"God LOVES you", "You are SAVED", "God is LOVE"};

        return verses;
    }
}