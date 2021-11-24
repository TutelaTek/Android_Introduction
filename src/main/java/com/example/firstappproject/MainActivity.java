package com.example.firstappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onHello(View view) {
        EditText maxText, minText;
        maxText = findViewById(R.id.maxId);
        minText = findViewById(R.id.minId);
        String maxString = String.valueOf(maxText.getText());
        String minString = String.valueOf(minText.getText());

        // avoiding null input
        if(!(maxString.equals("")) && !(minString.equals(""))) {


            //making sure its an int
            try {
                int max = Integer.parseInt(maxString);
                int min = Integer.parseInt(minString);

                // limiting the max number
                if (max <= 10000 && min >= -10000) {

                    // making sure max is truly max
                    if (max > min) {

                        // random number generator
                        TextView txtWelcome = findViewById(R.id.textWelcome);
                        double rand = Math.floor(Math.random() * (max - min + 1) + min);
                        int num = (int) rand;
                        String randString = String.valueOf(num);


                        txtWelcome.setText(randString);
                    } else {
                        Toast.makeText(this, "Max must be larger than min", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Max can not exceed 10,000 and Min can't exceed -10,000", Toast.LENGTH_SHORT).show();
                }
            }
            catch (NumberFormatException e) {
                Toast.makeText(this, "Not a number", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "fields can not be null", Toast.LENGTH_SHORT).show();
        }
    }
}