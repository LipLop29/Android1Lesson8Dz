package com.example.android1lesson8dz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnChrome, btnWhatsApp, btnYouTube, btnCamera;
    EditText etNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChrome = findViewById(R.id.btn_chrome);
        btnWhatsApp = findViewById(R.id.btn_whatsApp);
        btnYouTube = findViewById(R.id.btn_youTube);
        btnCamera = findViewById(R.id.btn_camera);
        etNumber = findViewById(R.id.et_Number);

        click();
    }

    private void click() {
        btnChrome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.google.ru/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btnWhatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = etNumber.getText().toString().trim();
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://wa.me/" + text));
                startActivity(intent);
            }
        });

        btnYouTube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.youtube.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btnCamera.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivity(intent);
            }
        });
    }
}