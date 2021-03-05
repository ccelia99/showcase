package com.example.showcase;

import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText numTextView = findViewById(R.id.numTextView);
        EditText exType = findViewById(R.id.exType);
        EditText editTextTextMultiLine = findViewById(R.id.editTextTextMultiLine);
        EditText editTextDate = findViewById(R.id.editTextDate);

        Button oneBtn = (Button) findViewById(R.id.oneBtn);
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

        Button fiveBtn = (Button) findViewById(R.id.fiveBtn);
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

        Button tenBtn = (Button) findViewById(R.id.tenBtn);
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

        Button fiftyBtn = (Button) findViewById(R.id.fiftyBtn);
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

        Button hundredBtn = (Button) findViewById(R.id.hundredBtn);
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

        Button resetBtn = (Button) findViewById(R.id.resetBtn);
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = 0;
                TextView resultTextView = (TextView) findViewById(R.id.numTextView);
                resultTextView.setText(num + "");
            }
        });

        Button saveBtn = (Button) findViewById(R.id.saveBtn) ;
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                String FILE_NAME = "resultData.txt";
                StringBuilder sb = new StringBuilder();
                String text;
                String secondActData;

                //Timespampin paivamaara
                Date date = Calendar.getInstance().getTime();
                DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String currentDateandTime = sdf.format(date);


                //taman lisaa tuloksen StringBuilderiin
                sb.append(numTextView.getText().toString()).append("\t");
                //tama lisaa harj.tyypin
                sb.append(exType.getText().toString()).append("\t");
                //tama lisaa timestampin
                sb.append(currentDateandTime).append("\n");

                FileInputStream fis = null;
                //tama kay lukemassa fileen
                try {
                    fis = openFileInput(FILE_NAME);
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);

                    while ((text = br.readLine()) != null) {
                        sb.append(text).append("\n");
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                //tallenetaan StringBuilder sb Stringiin secondActData, jotta saadaan se siirtymaan
                //second_activityyn. Sb tyhjennetaan myohemmin
                secondActData = sb.toString();

                        // tama tunkee koko StringBuilderin takaisin kentaan
                editTextTextMultiLine.setText(secondActData);



                //tama tulostaa timestampin
                editTextDate.setText(currentDateandTime.toString());

                FileOutputStream fos = null;
                //tallennetaan failiin
                try {
                    fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                    fos.write(sb.toString().getBytes());

                    //tyhjentaa StringBuilderin
                    sb.setLength(0);
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

                //SecondActivityn kutsu
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                startIntent.putExtra("com.example.showcase.listview", secondActData);
                startActivity(startIntent);
            }
        });


    }
}