package com.example.showcase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button oneBtn = (Button) findViewById(R.id.oneBtn);
        Button fiveBtn = (Button) findViewById(R.id.fiveBtn);
        Button tenBtn = (Button) findViewById(R.id.tenBtn);
        Button fiftyBtn = (Button) findViewById(R.id.fiftyBtn);
        Button hundredBtn = (Button) findViewById(R.id.hundredBtn);

        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText oldResult = (EditText) findViewById(R.id.numTextView);
                int num = Integer.parseInt(oldResult.getText().toString());
                num += 1;
                TextView resultTextView = (TextView) findViewById(R.id.numTextView);
                resultTextView.setText(num + "");
            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText oldResult = (EditText) findViewById(R.id.numTextView);
                int num = Integer.parseInt(oldResult.getText().toString());
                num += 5;
                TextView resultTextView = (TextView) findViewById(R.id.numTextView);
                resultTextView.setText(num + "");
            }
        });

        tenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText oldResult = (EditText) findViewById(R.id.numTextView);
                int num = Integer.parseInt(oldResult.getText().toString());
                num += 10;
                TextView resultTextView = (TextView) findViewById(R.id.numTextView);
                resultTextView.setText(num + "");
            }
        });

        fiftyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText oldResult = (EditText) findViewById(R.id.numTextView);
                int num = Integer.parseInt(oldResult.getText().toString());
                num += 50;
                TextView resultTextView = (TextView) findViewById(R.id.numTextView);
                resultTextView.setText(num + "");
            }
        });

        hundredBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText oldResult = (EditText) findViewById(R.id.numTextView);
                int num = Integer.parseInt(oldResult.getText().toString());
                num += 100;
                TextView resultTextView = (TextView) findViewById(R.id.numTextView);
                resultTextView.setText(num + "");
            }
        });
    }
}