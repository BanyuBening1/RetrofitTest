package com.example.retrofittest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvTeam;
    TeamAdapter teamAdapter;
    ProgressBar pbLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        pbLoading = findViewById(R.id.pbLoading);
        rvTeam = findViewById(R.id.rvTeam);
        rvTeam.setLayoutManager(new LinearLayoutManager(this));

        String leagueName = getIntent().getStringExtra("LEAGUE");
        TeamAPI api = RetrofitClient.getInstance().create(TeamAPI.class);

        if ("LALIGA".equals(leagueName)) {
            fetchLaligaTeams(api);
        } else if ("EPL".equals(leagueName)) {
            fetchEnglishPremierLeagueTeams(api);
        } else {
            Toast.makeText(this, "Invalid league name", Toast.LENGTH_SHORT).show();
        }
    }

    private void fetchLaligaTeams(TeamAPI api) {
        api.getLaliga("Spanish La Liga").enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, Response<Response> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Team> teams = response.body().getTeams();
                    teamAdapter = new TeamAdapter(teams);
                    rvTeam.setAdapter(teamAdapter);
                    rvTeam.setVisibility(View.VISIBLE);
                    pbLoading.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.e("API_ERROR", t.getMessage());
                Toast.makeText(MainActivity.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fetchEnglishPremierLeagueTeams(TeamAPI api) {
        api.getTeams("English Premier League").enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, Response<Response> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Team> teams = response.body().getTeams();
                    teamAdapter = new TeamAdapter(teams);
                    rvTeam.setAdapter(teamAdapter);
                    rvTeam.setVisibility(View.VISIBLE);
                    pbLoading.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.e("API_ERROR", t.getMessage());
                Toast.makeText(MainActivity.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
