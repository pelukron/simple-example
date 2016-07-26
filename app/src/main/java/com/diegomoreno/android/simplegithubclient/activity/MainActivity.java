package com.diegomoreno.android.simplegithubclient.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.diegomoreno.android.simplegithubclient.R;
import com.diegomoreno.android.simplegithubclient.adapter.RepoAdapter;
import com.diegomoreno.android.simplegithubclient.model.Repo;
import com.diegomoreno.android.simplegithubclient.rest.ApiClient;
import com.diegomoreno.android.simplegithubclient.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private String user;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        user = "rubixware";
        showData(user);
    }

    private void showData (String name){

        ApiInterface apiInterface =
                ApiClient.getRetrofit().create(ApiInterface.class);
        Call<List<Repo>> call = apiInterface.listRepos(name);
        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                List<Repo> repos = response.body();
                recyclerView.setAdapter(new RepoAdapter(
                        repos, R.layout.list_item_repo, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }
}
