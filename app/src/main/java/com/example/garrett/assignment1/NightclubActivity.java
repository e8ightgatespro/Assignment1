package com.example.garrett.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class NightclubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nightclub);
        initAddButton();
        initMapButton();
        initListButton();
        initSaveButton();

    }

    private void initSaveButton() {
        Button saveButton = (Button) findViewById(R.id.buttonSaveClub);

    }

    private void initAddButton() {


    }

    private void initMapButton() {

    }

    private void initListButton() {

    }
}
