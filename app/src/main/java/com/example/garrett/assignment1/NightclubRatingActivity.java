package com.example.garrett.assignment1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class NightclubRatingActivity extends AppCompatActivity {

    Nightclub currentNightclub;

    @Override
    protected void onCreate(Bundle savedInstanceStates) {
        super.onCreate(savedInstanceStates);
        setContentView(R.layout.activity_nightclub_rating);
        initAddButton();
        initListButton();
        initMapButton();
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            initNightclub(extras.getInt("nightclubid"));
        }
        else {
            currentNightclub = new Nightclub();
        }
        initSaveButton();
        initNightclub(currentNightclub.getNightclubID());
    }

    private void initSaveButton() {
        Button saveButton = (Button) findViewById(R.id.buttonSave);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean wasSuccesful = false;
                NightclubDataSource ds = new NightclubDataSource(NightclubRatingActivity.this);
                try {
                    ds.open();
                    if(currentNightclub.getNightclubID() == -1) {
                        wasSuccesful = ds.insertNightclub(currentNightclub);
                        if(wasSuccesful) {
                            int newID = ds.getLastNightclubId();
                            currentNightclub.setNightclubID(newID);
                        }
                    }
                    else {
                        wasSuccesful = ds.updateNightClub(currentNightclub);
                    }
                    ds.close();
                }
                catch(Exception e) {
                    wasSuccesful = false;
                }

            }
        });

    }

    private void initNightclub(int id) {
        NightclubDataSource ds = new NightclubDataSource(NightclubRatingActivity.this);
        try {
            ds.open();
            currentNightclub = ds.getSpecificNightclub(id);
            ds.close();
        }
        catch(Exception e) {
            Toast.makeText(this, "Load Nightclub Failed", Toast.LENGTH_LONG).show();
        }

        RadioButton rbBeer1 = findViewById(R.id.radioBeer1);
        RadioButton rbBeer2 = findViewById(R.id.radioBeer2);
        RadioButton rbBeer3 = findViewById(R.id.radioBeer3);
        RadioButton rbBeer4 = findViewById(R.id.radioBeer4);
        RadioButton rbBeer5 = findViewById(R.id.radioBeer5);
        RadioButton rbWine1 = findViewById(R.id.radioWine1);
        RadioButton rbWine2 = findViewById(R.id.radioWine2);
        RadioButton rbWine3 = findViewById(R.id.radioWine3);
        RadioButton rbWine4 = findViewById(R.id.radioWine4);
        RadioButton rbWine5 = findViewById(R.id.radioWine5);
        RadioButton rbMusic1 = findViewById(R.id.radioMusic1);
        RadioButton rbMusic2 = findViewById(R.id.radioMusic2);
        RadioButton rbMusic3 = findViewById(R.id.radioMusic3);
        RadioButton rbMusic4 = findViewById(R.id.radioMusic4);
        RadioButton rbMusic5 = findViewById(R.id.radioMusic5);

        switch(currentNightclub.getBeer()){
            case(1):
                rbBeer1.setChecked(true);
                break;
            case(2):
                rbBeer2.setChecked(true);
                break;
            case(3):
                rbBeer3.setChecked(true);
                break;
            case(4):
                rbBeer4.setChecked(true);
                break;
            case(5):
                rbBeer5.setChecked(true);
                break;
        }

        switch(currentNightclub.getWine()) {
            case(1):
                rbWine1.setChecked(true);
                break;
            case(2):
                rbWine2.setChecked(true);
                break;
            case(3):
                rbWine3.setChecked(true);
                break;
            case(4):
                rbWine4.setChecked(true);
                break;
            case(5):
                rbWine5.setChecked(true);
                break;
        }

        switch (currentNightclub.getMusic()) {
            case(1):
                rbMusic1.setChecked(true);
                break;
            case(2):
                rbMusic2.setChecked(true);
                break;
            case(3):
                rbMusic3.setChecked(true);
                break;
            case(4):
                rbMusic4.setChecked(true);
                break;
            case(5):
                rbMusic5.setChecked(true);
                break;
        }





    }

    private void initAddButton() {
        ImageButton imAdd = findViewById(R.id.imageAddClub);
        imAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NightclubRatingActivity.this, NightclubActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initMapButton() {
        ImageButton imMap = findViewById(R.id.imageShowClub);
        imMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NightclubRatingActivity.this, NightclubMapActivity.class);
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
                Intent intent = new Intent(NightclubRatingActivity.this, NightclubListActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
