package com.example.retrofittest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TeamAPI {
    @GET("/api/v1/json/3/search_all_teams.php?l=English%20Premier%20League")
    Call<TeamResponse> getPremier (@Query("league") String league);

    @GET("/api/v1/json/3/search_all_teams.php?l=Spanish%20La%20Liga")
    Call<TeamResponse> getLaliga(@Query("league") String league);
}
