package com.example.mydrakor;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Drakor> drakorItems;

    public CustomListAdapter(Activity activity, List<Drakor> drakorItems) {
        this.activity = activity;
        this.drakorItems = drakorItems;
    }
    @Override
    public int getCount() {
        return drakorItems.size();
    }

    @Override
    public Object getItem(int location) {
        return  drakorItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView judul = (TextView) convertView.findViewById(R.id.text_judul);
        TextView genre = (TextView) convertView.findViewById(R.id.text_genre);
        TextView episode = (TextView) convertView.findViewById(R.id.text_episode);
        Drakor drakor = drakorItems.get(position);
        judul.setText(drakor.getmJudul());
        genre.setText(drakor.getmGenre());
        episode.setText(drakor.getmEpisode());
        return convertView;
    }
}
