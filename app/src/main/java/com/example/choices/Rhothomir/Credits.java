package com.example.choices.Rhothomir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.choices.R;
import com.example.choices.Story_Select;

public class Credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }









    public void quitToMainMenu(View view){
        Intent quit = new Intent(this, Story_Select.class);
        startActivity(quit);
        finish();
    }
}