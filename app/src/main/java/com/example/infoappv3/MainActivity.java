package com.example.infoappv3;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

  Timer timer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        Intent intent = new Intent(MainActivity.this, NavActivity.class);
        startActivity(intent);
        finish();
      }
    }, 3000);
  }
}