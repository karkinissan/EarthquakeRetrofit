package com.example.android.forexretrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.forexretrofit.data.model.Feature;

import java.util.List;

/**
 * Created by Nissan on 7/2/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Feature> {


    public EarthquakeAdapter(@NonNull Context context, @NonNull List<Feature> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Feature feature = getItem(position);

        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnnitude);
        magnitudeTextView.setText(feature.getProperties().getMag().toString());

        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location);
        locationTextView.setText(feature.getProperties().getTitle());
        return listItemView;
    }
}
