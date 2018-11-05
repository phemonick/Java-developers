package com.example.adekunleoluwafemi.javadevelopers.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adekunleoluwafemi.javadevelopers.DetailActivity;
import com.example.adekunleoluwafemi.javadevelopers.R;
import com.example.adekunleoluwafemi.javadevelopers.model.GithubUser;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.GithubListHolder> {

    private List<GithubUser> mGithubUsers;
    Context context;

    public GithubAdapter(List<GithubUser> githubUsers, Context context) {
        mGithubUsers = githubUsers;
        this.context = context;
    }

    @NonNull
    @Override
    public GithubListHolder onCreateViewHolder(ViewGroup parent, int viewTyp) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new GithubListHolder(layoutInflater, parent);

    }

    @Override
    public void onBindViewHolder(GithubListHolder holder, int position) {
        GithubUser users = mGithubUsers.get(position);
        holder.bind(users);
    }
    @Override
    public int getItemCount() {
        return mGithubUsers.size();
    }

    class GithubListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mImageView;
        private TextView mUserName;
        private TextView mUserTextView;
        private GithubUser mGithubUsers;
        private CircleImageView circleImageView;


        public GithubListHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_user, parent, false));
            itemView.setOnClickListener(this);
            mUserName = itemView.findViewById(R.id.user_name);
            mUserTextView = itemView.findViewById(R.id.user_desc);
            circleImageView = itemView.findViewById(R.id.profile_image);

        }

        @Override
        public void onClick(View view) {

            Intent intent = DetailActivity.newIntent(context, mGithubUsers.getIsAdmin(),
                    mGithubUsers.getId(), mGithubUsers.getUserImage(),
                    mGithubUsers.getUsername(), mGithubUsers.getGithubLink());
            context.startActivity(intent);
        }


        public void bind(GithubUser githubUsers) {
            mGithubUsers = githubUsers;

            mUserTextView.setText(githubUsers.getGithubLink());
            String imageUri = githubUsers.getUserImage();
            Picasso.with(context).load(imageUri).fit().centerCrop()
                    .placeholder(R.drawable.ic_launcher_background).into(circleImageView);
            mUserName.setText(githubUsers.getUsername());
        }
    }

}
