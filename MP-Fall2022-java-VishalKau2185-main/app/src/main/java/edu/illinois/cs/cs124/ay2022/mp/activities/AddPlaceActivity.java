package edu.illinois.cs.cs124.ay2022.mp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import edu.illinois.cs.cs124.ay2022.mp.R;
import edu.illinois.cs.cs124.ay2022.mp.models.Place;
import edu.illinois.cs.cs124.ay2022.mp.network.Client;

public class AddPlaceActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_addplace);

    Intent returnToMain = new Intent(this, MainActivity.class);
    returnToMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

    Button cancelButton = findViewById(R.id.cancel_button);
    cancelButton.setOnClickListener(v -> {
      startActivity(returnToMain);
    });

    Button saveButton = findViewById(R.id.save_button);
    saveButton.setOnClickListener(v -> {

      String lat = getIntent().getStringExtra("latitude");
      String lon = getIntent().getStringExtra("longitude");

      double dLat = Double.parseDouble(lat);
      double dLon = Double.parseDouble(lon);

      String id = "b8229641-e27b-483b-8054-4285082d00e0";

      EditText text = findViewById(R.id.description);
      String des = text.getText().toString();
      Place p = new Place(id, "Vishal", dLat, dLon, des);

      Client client = Client.start();
      client.postFavoritePlace(p, null);
      startActivity(returnToMain);
    });
  }
}
