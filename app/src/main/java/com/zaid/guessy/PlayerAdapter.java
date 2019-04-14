package com.zaid.guessy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PlayerAdapter extends ArrayAdapter<Player> {

    private Context context;
    private int layout;
    private List<Player> playerList;

    public PlayerAdapter(Context context, int layout, List<Player> playerList) {
        super(context, layout, playerList);
        this.context = context;
        this.layout = layout;
        this.playerList = playerList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        PlayerHolder holder;

        if( v == null) {
            LayoutInflater li = ((Activity) context).getLayoutInflater();
            v = li.inflate(layout, parent, false);

            holder = new PlayerHolder();
            holder.viewNomor= (TextView) v.findViewById(R.id.scoreNomor);
            holder.viewUsername = (TextView) v.findViewById(R.id.scoreUsername);
            holder.viewScore = (TextView) v.findViewById(R.id.scoreScore);

            v.setTag(holder);
        } else {
            holder = (PlayerHolder) v.getTag();
        }

        Player player = playerList.get(position);
        holder.viewNomor.setText(Integer.toString(position + 1));
        holder.viewUsername.setText(player.getUsername().toString());
        holder.viewScore.setText(Integer.toString(player.getScore()));

        return v;
    }

    static class PlayerHolder {
        TextView viewNomor;
        TextView viewUsername;
        TextView viewScore;
    }
}
