package com.dal.user.minesweeper;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ((TextView)findViewById(R.id.textView)).setText("ASDASDASDASD");

        Log.e("MainActivity","onCreate");
        GameDriver.getInstance().createGrid(this);

    }
}
