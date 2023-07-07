package edu.illinois.cs.cs124.ay2022.mp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import edu.illinois.cs.cs124.ay2022.mp.R;

public class Menu extends AppCompatActivity {

  @Override
  protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    setContentView(R.layout.activity_menu);

    Intent toMain = new Intent(this, MainActivity.class);

    Button mapButton = findViewById(R.id.mapButton);
    mapButton.setOnClickListener(v -> {
      startActivity(toMain);
    });

    Intent toAbout = new Intent(this, About.class);

    Button aboutButton = findViewById(R.id.aboutButton);
    aboutButton.setOnClickListener(v -> {
      startActivity(toAbout);
    });
  }
}
