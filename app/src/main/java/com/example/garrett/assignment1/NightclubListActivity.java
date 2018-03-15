package com.example.garrett.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class NightclubListActivity extends AppCompatActivity {

    boolean isDeleting = false;
    NightclubAdapter adapter;
    ArrayList<Nightclub> nightclubs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nightclub_list);
        initAddButton();
        initMapButton();
        initListButton();
        initItemClick();

    }

    @Override
    public void onResume() {
        super.onResume();

        NightclubDataSource ds = new NightclubDataSource(this);


        try {
            ds.open();
            nightclubs = ds.getNightclubs();
            ds.close();
            if(nightclubs.size() > 0){
                adapter = new NightclubAdapter(this, nightclubs);
                ListView listView = (ListView) findViewById(R.id.lvNightclubs);
                listView.setAdapter(adapter);
            }
            else {
                Intent intent = new Intent(NightclubListActivity.this, NightclubActivity.class);
                startActivity(intent);
            }
        }
        catch(Exception e) {
            Toast.makeText(this, "Error retrieving contacts", Toast.LENGTH_LONG).show();
        }
    }



    private void initItemClick() {
        ListView listView = findViewById(R.id.lvNightclubs);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                Nightclub selectedNightclub = nightclubs.get(position);
                if(isDeleting) {

                }
                else {
                    Intent intent = new Intent(NightclubListActivity.this, NightclubRatingActivity.class);
                    intent.putExtra("nightclubid", selectedNightclub.getNightclubID());
                    startActivity(intent);
                }
            }
        });

    }


    private void initAddButton() {
        ImageButton imAdd = findViewById(R.id.imageAddClub);
        imAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NightclubListActivity.this, NightclubActivity.class);
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
                Intent intent = new Intent(NightclubListActivity.this, NightclubMapActivity.class);

                intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initListButton() {
        ImageButton imList = findViewById(R.id.imageListClub);
        imList.setEnabled(false);
        imList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NightclubListActivity.this, NightclubListActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}

