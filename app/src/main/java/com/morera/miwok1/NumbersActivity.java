package com.morera.miwok1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
//        LinearLayout rootView = findViewById(R.id.rootView);
//       GridView rootview = findViewById(R.id.rootView);
        ListView rootview = findViewById(R.id.list);

        ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("one", "lutti"));
        words.add(new Word("two", "otiiko"));
        words.add(new Word("three", "tolookosu"));
        words.add(new Word("four", "oyyisa"));
        words.add(new Word("five", "massokka"));
        words.add(new Word("six", "temmokka"));
        words.add(new Word("seven", "kenekaku"));
        words.add(new Word("eight", "kawinta"));
        words.add(new Word("nine", "wo’e"));
        words.add(new Word("ten", "na’aacha"));

        WordAdapter itemAdapter =
                new WordAdapter(this,words);
        rootview.setAdapter(itemAdapter);

//          ArrayAdapter<String> itemsAdapter =
//          new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,words);
//          rootview.setAdapter(itemsAdapter);
//          for (int i = 0;i < words.size();i++) {
//            TextView wordView = new TextView(this);
//            wordView.setText(words.get(i));
//            rootView.addView(wordView);
//        }

//        int i = 0;
//            while (i < words.size()) {
//            CodeHere
//            i++;
//        }

    }
}
