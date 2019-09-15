package com.morera.miwok1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new NumbersFragment())
                .commit();
    }
}

//        LinearLayout rootView = findViewById(R.id.rootView);
//       GridView rootview = findViewById(R.id.rootView);
//          ArrayAdapter<String> itemsAdapter =
//          new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,wordsArray);
//          rootview.setAdapter(itemsAdapter);
//          for (int i = 0;i < wordsArray.size();i++) {
//            TextView wordView = new TextView(this);
//            wordView.setText(wordsArray.get(i));
//            rootView.addView(wordView);
//        }
//        int i = 0;
//            while (i < wordsArray.size()) {
//            CodeHere
//            i++;
//        }
