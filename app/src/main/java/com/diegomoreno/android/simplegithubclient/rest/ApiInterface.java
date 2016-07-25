package com.diegomoreno.android.simplegithubclient.rest;

import com.diegomoreno.android.simplegithubclient.model.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by dmoreno on 7/25/16.
 */
public interface ApiInterface {
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);
}
