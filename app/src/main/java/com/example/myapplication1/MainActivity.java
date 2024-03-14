package com.example.myapplication1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    TextView userSelection, compSelection, wonLost, scoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        userSelection = findViewById(R.id.userSelection);
        compSelection = findViewById(R.id.compSelection);
        wonLost = findViewById(R.id.wonLost);
        scoreView = findViewById(R.id.scoreView);

        userSelection.setText("");
        compSelection.setText("");
        wonLost.setText("");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void rspButtonSelected(){
        int userSelection =
    }
}