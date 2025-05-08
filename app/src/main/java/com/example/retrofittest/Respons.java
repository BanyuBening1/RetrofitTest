package com.example.retrofittest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Respons {
    @SerializedName("teams")
    private List<Team> teams;


    public List<Team> getTeams() {return teams;
    }
}
