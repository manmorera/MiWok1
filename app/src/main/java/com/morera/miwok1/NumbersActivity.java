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

        ArrayList<Wordcustomclass> words = new ArrayList<>();

        words.add(new Wordcustomclass("one", "lutti",R.drawable.number_one));
        words.add(new Wordcustomclass("two", "otiiko",R.drawable.number_two));
        words.add(new Wordcustomclass("three", "tolookosu",R.drawable.number_three));
        words.add(new Wordcustomclass("four", "oyyisa",R.drawable.number_four));
        words.add(new Wordcustomclass("five", "massokka",R.drawable.number_five));
        words.add(new Wordcustomclass("six", "temmokka",R.drawable.number_six));
        words.add(new Wordcustomclass("seven", "kenekaku",R.drawable.number_seven));
        words.add(new Wordcustomclass("eight", "kawinta",R.drawable.number_eight));
        words.add(new Wordcustomclass("nine", "wo’e",R.drawable.number_nine));
        words.add(new Wordcustomclass("ten", "na’aacha",R.drawable.number_ten));

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
