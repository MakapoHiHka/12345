package com.example.a12345;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Integer Chet = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null &&
                savedInstanceState.containsKey("counter")) {
            int counter = savedInstanceState.getInt("counter");
        }
        Log.d("Insteps", "onRestoreInstanceState");
    }
    @Override
    protected void onSaveInstanceState(Bundle autState){
        super.onSaveInstanceState(autState);
        autState.putInt("Работает", Chet); // autState.putInt("Нажалось", count);
        Log.d("Instens","onSave");
        Toast.makeText(this, "onSave",Toast.LENGTH_LONG).show();
    }

    @Override
    protected  void onStart(){
        super.onStart();
        Log.d("Instens", "Запустилось");
        Toast.makeText(this, "Запустилось", Toast.LENGTH_LONG).show();
    }
    @Override
    protected  void onResume(){
        super.onResume();
        Log.d("Instens", "В Работе");
        Toast.makeText(this, "В Работе", Toast.LENGTH_LONG).show();
    }
    @Override
    protected  void onPause(){
        super.onPause();
        Log.d("Instens", "Отдыхает");
        Toast.makeText(this, "Отдыхает", Toast.LENGTH_LONG).show();
    }


    public void one_click_button(View view) {
        Chet++;
        TextView TXT = findViewById(R.id.text_View1);
        TXT.setText("Часов сна: " + Chet.toString());
    }
}