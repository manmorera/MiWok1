package com.morera.miwok1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ListView rootview = findViewById(R.id.list);

        ArrayList<Wordcustomclass> words = new ArrayList<>();

        words.add(new Wordcustomclass("father", "weṭeṭṭi",R.drawable.family_father));
        words.add(new Wordcustomclass("mother", "chokokki",R.drawable.family_mother));
        words.add(new Wordcustomclass("son", "ṭakaakki",R.drawable.family_son));
        words.add(new Wordcustomclass("daughter", "ṭopoppi",R.drawable.family_daughter));
        words.add(new Wordcustomclass("older brother", "kululli",R.drawable.family_older_brother));
        words.add(new Wordcustomclass("younger brother", "kelelli",R.drawable.family_younger_sister));
        words.add(new Wordcustomclass("older sister", "ṭopiisә",R.drawable.family_older_sister));
        words.add(new Wordcustomclass("younger sister", "chiwiiṭә",R.drawable.family_younger_sister));
        words.add(new Wordcustomclass("grandmother", "ṭopiisә",R.drawable.family_grandmother));
        words.add(new Wordcustomclass("grandfather", "chiwiiṭә",R.drawable.family_grandfather));

        WordAdapter itemAdapter =
                new WordAdapter(this,words);
        rootview.setAdapter(itemAdapter);
    }
}
