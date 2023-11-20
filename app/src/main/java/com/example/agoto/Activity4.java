package com.example.agoto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity4 extends AppCompatActivity {

    static String THIS = "Activity 4";
    public static int CODE=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4);

        Button button1 = findViewById(R.id.BUT1);
        Button button2 = findViewById(R.id.BUT2);
        Button button3 = findViewById(R.id.BUT3);
        Button button4 = findViewById(R.id.BUT4);
        Button back = findViewById(R.id.BACK);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "This is pointless",Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity4.this, Activity2.class);
                startActivityForResult(intent, CODE);
                intent.putExtra("info", THIS);
                setResult(RESULT_OK, intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity4.this, Activity3.class);
                startActivityForResult(intent, CODE);
                intent.putExtra("info", THIS);
                setResult(RESULT_OK, intent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity4.this, Activity1.class);
                startActivityForResult(intent, CODE);
                intent.putExtra("info", THIS);
                setResult(RESULT_OK, intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("info", THIS);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODE && data != null) {
            String str = data.getStringExtra("info");
            Toast.makeText(getApplicationContext(), "You came to " + THIS + " from " + str, Toast.LENGTH_SHORT).show();
        }
    }
}