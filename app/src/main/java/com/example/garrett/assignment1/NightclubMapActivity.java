package com.example.garrett.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class NightclubMapActivity extends AppCompatActivity {

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
        ImageButton imAdd = findViewById(R.id.imageAddClub);
        imAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NightclubMapActivity.this, NightclubActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initMapButton() {
        ImageButton imMap = findViewById(R.id.imageShowClub);
        imMap.setEnabled(false);
        imMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NightclubMapActivity.this, NightclubMapActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initListButton() {
        ImageButton imList = findViewById(R.id.imageListClub);
        imList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NightclubMapActivity.this, NightclubListActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
