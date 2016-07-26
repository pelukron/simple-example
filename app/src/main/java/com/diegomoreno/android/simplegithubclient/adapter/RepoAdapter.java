package com.diegomoreno.android.simplegithubclient.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.diegomoreno.android.simplegithubclient.R;
import com.diegomoreno.android.simplegithubclient.model.Repo;

import java.util.List;

/**
 * Created by dmoreno on 7/25/16.
 */
public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {

    private List<Repo> repos;
    private int rowLayout;
    private Context context;
    private RepoViewHolder repoViewHolder;

    public static class RepoViewHolder extends RecyclerView.ViewHolder {

        LinearLayout repoLayout;
        TextView nameRepo;
        TextView descriptionRepo;

        public RepoViewHolder(View v) {
            super(v);
            repoLayout = (LinearLayout)v.findViewById(R.id.repos_layout);
            nameRepo = (TextView)v.findViewById(R.id.rating);
            descriptionRepo = (TextView)v.findViewById(R.id.description);
        }
    }

    public RepoAdapter(List<Repo> repos, int rowLayout, Context context) {
        this.repos = repos;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public RepoAdapter.RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
        holder.nameRepo.setText(repos.get(position).getName());
        holder.descriptionRepo.setText(repos.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }
}
