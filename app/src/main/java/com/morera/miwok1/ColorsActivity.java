package com.morera.miwok1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ListView rootview = findViewById(R.id.list);

        ArrayList<Wordcustomclass> words = new ArrayList<>();

        words.add(new Wordcustomclass("red", "weṭeṭṭi",R.drawable.color_red));
        words.add(new Wordcustomclass("green", "chokokki",R.drawable.color_green));
        words.add(new Wordcustomclass("brown", "ṭakaakki",R.drawable.color_brown));
        words.add(new Wordcustomclass("gray", "ṭopoppi",R.drawable.color_gray));
        words.add(new Wordcustomclass("black", "kululli",R.drawable.color_black));
        words.add(new Wordcustomclass("white", "kelelli",R.drawable.color_white));
        words.add(new Wordcustomclass("dusty yellow", "ṭopiisә",R.drawable.color_dusty_yellow));
        words.add(new Wordcustomclass("mustard yellow", "chiwiiṭә",R.drawable.color_mustard_yellow));

        WordAdapter itemAdapter =
                new WordAdapter(this,words);
        rootview.setAdapter(itemAdapter);
    }
}
