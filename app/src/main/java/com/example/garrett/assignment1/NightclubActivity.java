package com.example.garrett.assignment1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class NightclubActivity extends AppCompatActivity {

    Nightclub currentNightclub = new Nightclub();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nightclub);
        initAddButton();
        initMapButton();
        initListButton();
        initSaveButton();
        initTextChangedEvents();
        hideKeyboard();





    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        EditText editName = (EditText) findViewById(R.id.editClubName);
        imm.hideSoftInputFromWindow(editName.getWindowToken(), 0);
        EditText editStreet = (EditText) findViewById(R.id.editClubStreetAddress);
        imm.hideSoftInputFromWindow(editStreet.getWindowToken(), 0);
        EditText editCity = (EditText) findViewById(R.id.editClubCity);
        imm.hideSoftInputFromWindow(editCity.getWindowToken(), 0);
        EditText editState = (EditText) findViewById(R.id.editClubState);
        imm.hideSoftInputFromWindow(editState.getWindowToken(), 0);
        EditText editZipcode = (EditText) findViewById(R.id.editClubZipcode);
        imm.hideSoftInputFromWindow(editZipcode.getWindowToken(), 0);
    }



    private void initSaveButton() {
        Button saveButton = (Button) findViewById(R.id.buttonSaveClub);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean wasSuccesful = false;
                hideKeyboard();
                NightclubDataSource ds = new NightclubDataSource(NightclubActivity.this);
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

                Intent intent = new Intent(NightclubActivity.this, NightclubListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }

        });

    }

    private void initAddButton() {
        ImageButton imAdd = findViewById(R.id.imageAddClub);
        imAdd.setEnabled(false);
        imAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NightclubActivity.this, NightclubActivity.class);
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
                Intent intent = new Intent(NightclubActivity.this, NightclubMapActivity.class);
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
                Intent intent = new Intent(NightclubActivity.this, NightclubListActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initTextChangedEvents() {
        final EditText etNightClubName = findViewById(R.id.editClubName);
        etNightClubName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentNightclub.setNightclubName(etNightClubName.getText().toString());

            }
        });

        final EditText etNightClubAddress = findViewById(R.id.editClubStreetAddress);
        etNightClubAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentNightclub.setStreetaddress(etNightClubAddress.getText().toString());

            }
        });

        final EditText etNightClubCity = findViewById(R.id.editClubCity);
        etNightClubCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentNightclub.setCity(etNightClubCity.getText().toString());

            }
        });

        final EditText etNightClubState = findViewById(R.id.editClubState);
        etNightClubState.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentNightclub.setState(etNightClubCity.getText().toString());

            }
        });

        final EditText etNightClubZipcode = findViewById(R.id.editClubZipcode);
        etNightClubZipcode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentNightclub.setZipcode(etNightClubZipcode.getText().toString());

            }
        });
    }

}
