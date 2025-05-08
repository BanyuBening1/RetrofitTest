package com.example.retrofittest;

import com.google.gson.annotations.SerializedName;

public class Team {
    @SerializedName("strTeam")
    private String teamName;

    @SerializedName("strStadium")
    private String stadium;

    @SerializedName("strTeamShort")
    private String shortName;

    @SerializedName("strBadge")
    private String badge;



    public String getTeamName() {
        return teamName;
    }

    public String getStadium() {
        return stadium;
    }

    public String getShortName() {
        return shortName;
    }

    public String getBadge(){
        return badge;
    }

}

