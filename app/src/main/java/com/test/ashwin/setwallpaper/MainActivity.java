package com.test.ashwin.setwallpaper;

import android.app.WallpaperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button buttonSetWallpaper;
    private ImageView imagePreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSetWallpaper = (Button)findViewById(R.id.set);
        imagePreview = (ImageView)findViewById(R.id.preview);
        imagePreview.setImageResource(R.drawable.batman_480_800);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        final int height = metrics.heightPixels;
        final int width = metrics.widthPixels;

        buttonSetWallpaper.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                WallpaperManager myWallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                try {
                    myWallpaperManager.suggestDesiredDimensions(width, height);
                    myWallpaperManager.setResource(R.raw.batman_480_800);
                    Toast.makeText(MainActivity.this, "Wallpaper set successfully", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Some error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
