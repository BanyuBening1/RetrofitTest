package com.example.retrofittest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainMenu extends AppCompatActivity {

    Button btnPremier;
    Button btnLaliga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_menu);

        btnPremier = findViewById(R.id.btnPremier);
        btnLaliga = findViewById(R.id.btnLaliga);

        btnPremier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent premier = new Intent(MainMenu.this, MainActivity.class);
                premier.putExtra("LEAGUE", "EPL");
                startActivity(premier);
            }
        });
        btnLaliga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent laliga = new Intent(MainMenu.this, MainActivity.class);
                laliga.putExtra("LEAGUE", "LALIGA");
                startActivity(laliga);
            }
        });
        };

    }
