package com.example.myapplication1;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    TextView userSelection, compSelection, wonLost, scoreView;

    int userScore = 0, compScore = 0;

    Random random;

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
        random = new Random();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void rspButtonSelected(View view){

        int userSelection = Integer.parseInt(view.getTag().toString());
        Log.i(TAG, msg: "rspButtonSelected: " + userSelection);
        matchGame(userSelection);

    }

    private void matchGame(int userSelection) {
        int low = 1;
        int high = 3;

        int compSelection = random.nextInt(high) + low;
        if(userSelection == compSelection) {
            wonLost.setText("Remis");
        }else if ((userSelection-compSelection) %3 ==1){
            userScore++;
            wonLost.setText("wygrywasz");
        } else {
            compScore++;
            wonLost.setText("przegrywasz");
        }

        /*switch(userSelection) {
            case 1:
                userSelection.se
        }*/
    }

    private void setScore (int userScore, int compScore){
       scoreView.setText(String.valueOf(userScore) + " : " + String.valueOf(compScore));
    }
}