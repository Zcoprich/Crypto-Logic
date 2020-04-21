package com.example.crypto_logiclab;

import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import android.widget.*;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> words = new ArrayList<>(Arrays.asList("APPLE", "BANANA", "CHERRY"));
    String word;
    String scrambledWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void scrambleButtonTest(View v){
        TextView t = (TextView) findViewById(R.id.scrambled);
        TextView w = (TextView) findViewById(R.id.word);

        word = selectWord(words);
        scrambledWord = scramble(word);
        t.setText(scrambledWord);
        w.setText(word);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public String selectWord (ArrayList<String> list) {
        Random r = new Random();
        return list.get(r.nextInt(list.size()));
    }

    public String scramble (String word){
        ArrayList<String> wordlist = new ArrayList(Arrays.asList(word.split("")));
        Collections.shuffle(wordlist);
        String shuffledword = String.join("", wordlist);
        return shuffledword;
    }

}
