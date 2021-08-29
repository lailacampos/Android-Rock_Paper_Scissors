package com.laila.udemy.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectRock(View view) {
        this.selectOption("Rock");
    }

    public void selectPaper(View view) {
        this.selectOption("Paper");
    }

    public void selectScissors(View view) {
        this.selectOption("Scissors");
    }


    public void selectOption(String userOption) {

        ImageView imageResult = findViewById(R.id.image_choice_app);
        TextView resultText = findViewById(R.id.message_text);

        int number = new Random().nextInt(3);
        String[] choices = {"Rock", "Paper", "Scissors"};
        String appChoice = choices[number];

//        System.out.println("Selected option: " + appChoice);

        switch (appChoice) {
            case "Rock":
                imageResult.setImageResource(R.drawable.rock_hand_128);
                break;

            case "Paper":
                imageResult.setImageResource(R.drawable.paper_hand_128);
                break;

            case "Scissors":
                imageResult.setImageResource(R.drawable.scissors_hand_128);
                break;
        }

        // If app wins
        if (
                (appChoice.equals(choices[0]) && userOption.equals(choices[2])) ||
                        (appChoice.equals(choices[1]) && userOption.equals("Rock")) ||
                        (appChoice.equals(choices[2]) && userOption.equals(choices[1]))
        ) {
            resultText.setText("You lost :(");
        } else if (

                (userOption.equals(choices[0]) && appChoice.equals(choices[2])) ||
                        (userOption.equals(choices[1]) && appChoice.equals(choices[0])) ||
                        (userOption.equals(choices[2]) && appChoice.equals(choices[1]))
        ) {
            resultText.setText("You win! :)");

        // If it's a tie
        } else {
            resultText.setText("It's a tie :/");
        }

    }
}

