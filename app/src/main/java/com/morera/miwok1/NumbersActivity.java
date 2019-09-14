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

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mDone = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            release();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
//        LinearLayout rootView = findViewById(R.id.rootView);
//       GridView rootview = findViewById(R.id.rootView);
        ListView rootview = findViewById(R.id.list);

        final ArrayList<Wordcustomclass> wordsArray = new ArrayList<>();

        wordsArray.add(new Wordcustomclass("one", "lutti",R.drawable.number_one,R.raw.number_one));
        wordsArray.add(new Wordcustomclass("two", "otiiko",R.drawable.number_two,R.raw.number_two));
        wordsArray.add(new Wordcustomclass("three", "tolookosu",R.drawable.number_three,R.raw.number_three));
        wordsArray.add(new Wordcustomclass("four", "oyyisa",R.drawable.number_four,R.raw.number_four));
        wordsArray.add(new Wordcustomclass("five", "massokka",R.drawable.number_five,R.raw.number_five));
        wordsArray.add(new Wordcustomclass("six", "temmokka",R.drawable.number_six,R.raw.number_six));
        wordsArray.add(new Wordcustomclass("seven", "kenekaku",R.drawable.number_seven,R.raw.number_seven));
        wordsArray.add(new Wordcustomclass("eight", "kawinta",R.drawable.number_eight,R.raw.number_eight));
        wordsArray.add(new Wordcustomclass("nine", "wo’e",R.drawable.number_nine,R.raw.number_nine));
        wordsArray.add(new Wordcustomclass("ten", "na’aacha",R.drawable.number_ten,R.raw.number_ten));

        WordAdapter itemAdapter =
                new WordAdapter(this,wordsArray,R.color.category_numbers);
        rootview.setAdapter(itemAdapter);

        rootview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                release();
                Wordcustomclass word = wordsArray.get(position);

                Toast.makeText(NumbersActivity.this,"Position: " + position,Toast.LENGTH_SHORT).show();
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudio());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mDone);
            }
        });

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

    }
    private void release() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}
