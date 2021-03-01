package com.example.showcase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String FILE_NAME = "example.txt";
    EditText mEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.numTextView);

        Button oneBtn = (Button) findViewById(R.id.oneBtn);
        Button fiveBtn = (Button) findViewById(R.id.fiveBtn);
        Button tenBtn = (Button) findViewById(R.id.tenBtn);
        Button fiftyBtn = (Button) findViewById(R.id.fiftyBtn);
        Button hundredBtn = (Button) findViewById(R.id.hundredBtn);
        Button resetBtn = (Button) findViewById(R.id.resetBtn);
        Button saveBtn = (Button) findViewById(R.id.saveBtn) ;

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

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = 0;
                TextView resultTextView = (TextView) findViewById(R.id.numTextView);
                resultTextView.setText(num + "");
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = mEditText.getText().toString();
                FileOutputStream fos = null;
                try {
                    fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                    fos.write(text.getBytes());
                    mEditText.getText().clear();
                    Toast.makeText(MainActivity.this, "Saved to " + getFilesDir() + "/" + FILE_NAME,
                            Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });


    }
}