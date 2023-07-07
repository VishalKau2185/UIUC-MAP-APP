package edu.illinois.cs.cs124.ay2022.mp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import edu.illinois.cs.cs124.ay2022.mp.R;

public class SplashScreen extends AppCompatActivity {

  private Handler handler;
  @Override
  protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash_screen);

    handler = new Handler();
    handler.postDelayed(new Runnable() {
      @Override
      public void run() {
        Intent intent = new Intent(SplashScreen.this, Menu.class);
        startActivity(intent);
        finish();
      }
    }, 3000);
  }
}
