package com.example.showcase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tv = (TextView) findViewById(R.id.resultData);

            if (getIntent().hasExtra("com.example.showcase.listview")) {
            String text = getIntent().getExtras().getString("com.example.showcase.listview");
            tv.setText(text);
        }
        Button saveBtn = (Button) findViewById(R.id.dataSaveBtn) ;
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FILE_NAME = "resultData.txt";
                TextView changedText = (TextView) findViewById(R.id.resultData);
                StringBuilder sb = new StringBuilder(changedText.getText().toString());

                //tallennetaan failiin
                FileOutputStream fos = null;
                try {
                    fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                    fos.write(sb.toString().getBytes());
                    Toast.makeText(SecondActivity.this, "Saved to " + getFilesDir() + "/" + FILE_NAME,
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
