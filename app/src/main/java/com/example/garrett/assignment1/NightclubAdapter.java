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
            Button b = (Button) v.findViewById(R.id.buttonDeleteNightclub);
            textNightclubName.setText(nightclub.getNightclubName());
            textNightclubAverageRating.setText(( nightclub.getAverage()));
            b.setVisibility(View.INVISIBLE);
        }
        catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        return v;
    }

    public void showDelete(final int position, final View convertView, final Context context, final Nightclub nightclub) {
        View v = convertView;
        final Button b = v.findViewById(R.id.buttonDeleteNightclub);
        if (b.getVisibility() ==  View.INVISIBLE) {
            b.setVisibility(View.VISIBLE);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    hideDelete(position, convertView, context);
                    items.remove(nightclub);
                    deleteOption(nightclub.getNightclubID(), context);
                }
            });
        }
        else {
            hideDelete(position, convertView, context);
        }
    }

    private void deleteOption(int nightclubToDelete, Context context) {
        NightclubDataSource db = new NightclubDataSource(context);
        try {
            db.open();
            db.deleteNightclub(nightclubToDelete);
            db.close();
        }
        catch (Exception e) {
            Toast.makeText(adapterContext, "Delete Contact Failed", Toast.LENGTH_LONG).show();
        }
        this.notifyDataSetChanged();
    }

    public void hideDelete(int position, View convertView, Context context) {
        View v = convertView;
        final Button b = v.findViewById(R.id.buttonDeleteNightclub);
        b.setVisibility(View.INVISIBLE);
        b.setOnClickListener(null);
    }

}
