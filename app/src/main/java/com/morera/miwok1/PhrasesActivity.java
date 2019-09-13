package com.morera.miwok1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ListView rootview = findViewById(R.id.list);

        ArrayList<Wordcustomclass> words = new ArrayList<>();

        words.add(new Wordcustomclass("Where are you going?", "weṭeṭṭi"));
        words.add(new Wordcustomclass("What is your name?", "chokokki"));
        words.add(new Wordcustomclass("My name is...", "ṭakaakki"));
        words.add(new Wordcustomclass("How are you feeling?", "ṭopoppi"));
        words.add(new Wordcustomclass("I’m feeling good.", "kululli"));
        words.add(new Wordcustomclass("Are you coming?", "kelelli"));
        words.add(new Wordcustomclass("Yes, I’m coming.", "ṭopiisә"));
        words.add(new Wordcustomclass("I’m coming.", "chiwiiṭә"));
        words.add(new Wordcustomclass("Let’s go.", "chiwiiṭә"));
        words.add(new Wordcustomclass("Come here.", "chiwiiṭә"));

        WordAdapter itemAdapter =
                new WordAdapter(this,words);
        rootview.setAdapter(itemAdapter);
    }
}