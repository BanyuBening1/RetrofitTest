package com.example.retrofittest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {
    private List<Team> teams;


    public TeamAdapter(List<Team> teams) {
        this.teams = teams;
    }



    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Team team = teams.get(position);
        holder.name.setText(team.getTeamName());
        holder.stadium.setText(team.getStadium());
        holder.shortName.setText(team.getShortName());
        Glide.with(holder.badge.getContext()).load(team.getBadge()).into(holder.badge);
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public static class TeamViewHolder extends RecyclerView.ViewHolder {
        TextView name, stadium, shortName;
        ImageView badge;

        public TeamViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvNamaTeam);
            stadium = itemView.findViewById(R.id.tvNamaStadium);
            shortName = itemView.findViewById(R.id.tvNamaPendek);
            badge = itemView.findViewById(R.id.ivBadge);
        }
    }
}
