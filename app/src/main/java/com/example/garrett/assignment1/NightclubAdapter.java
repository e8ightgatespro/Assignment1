package com.example.garrett.assignment1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NightclubAdapter extends ArrayAdapter<Nightclub> {

    private ArrayList<Nightclub> items;
    private Context adapterContext;

    public NightclubAdapter(Context context, ArrayList<Nightclub> items) {
        super(context, R.layout.list_item, items);
        adapterContext = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        try {
            Nightclub nightclub = items.get(position);

            if(v == null) {
                LayoutInflater vi = (LayoutInflater) adapterContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.list_item, null);
            }

            TextView textNightclubName = (TextView) v.findViewById(R.id.textNightclubName);
            TextView textNightclubAverageRating = (TextView) v.findViewById(R.id.textNightclubAverageRating);

            Double average = nightclub.getAverage();

            textNightclubName.setText(nightclub.getNightclubName());
            textNightclubAverageRating.setText((average.toString()));
        }
        catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        return v;
    }





}
