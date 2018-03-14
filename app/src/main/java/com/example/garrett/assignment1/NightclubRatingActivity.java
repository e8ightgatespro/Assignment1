package com.example.garrett.assignment1;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NightclubRatingActivity extends AppCompatActivity {
    private Nightclub currentNightclub;

    @Override
    protected void OnCreate(Bundle savedInstanceStates) {
        super.onCreate(savedInstanceStates);
        setContentView(R.layout.activity_nightclub_rating);
        initAdd();
        initList();
        initMap();
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            initNightclub(extras.getInt("nightclubid"));
        }


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



    }

    private void initAdd() {

    }

    private void initList() {

    }

    private void initMap() {

    }
}
