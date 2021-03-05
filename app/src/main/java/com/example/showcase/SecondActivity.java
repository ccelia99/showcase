package com.example.showcase;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (getIntent().hasExtra("com.example.showcase.listview")) {
            TextView tv = (TextView) findViewById(R.id.resultData);
            String text = getIntent().getExtras().getString("com.example.showcase.listview");
            tv.setText(text);
        }
    }
}
