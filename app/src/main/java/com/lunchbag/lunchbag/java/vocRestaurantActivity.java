package com.lunchbag.lunchbag.java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class vocRestaurantActivity extends AppCompatActivity {

    Button emailSend;
    EditText titleText;
    EditText contentText;
    Button menuButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voc_restaurant);

        emailSend = (Button) findViewById(R.id.emailSend);
        titleText = (EditText) findViewById(R.id.titleText);
        contentText = (EditText) findViewById(R.id.contentText);
        menuButton = (Button) findViewById(R.id.menuButton);

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), vocMenuActivity.class);
                startActivity(intent);
            }
        });

        emailSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = titleText.getText().toString();
                String content = contentText.getText().toString();
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                try{
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"wn950430@gmail.com"});
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, title);
                    emailIntent.putExtra(Intent.EXTRA_TEXT, content);
                    emailIntent.setType("text/html");
                    emailIntent.setPackage("com.google.android.gm");
                    if(emailIntent.resolveActivity(getPackageManager())!=null)
                        startActivity(emailIntent);
                }catch (Exception e){
                    e.printStackTrace();

                    emailIntent.setType("text/html");
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"wn950430@gmail.com"});

                    startActivity(Intent.createChooser(emailIntent, "Send Email"));
                }
            }
        });
    }
}
