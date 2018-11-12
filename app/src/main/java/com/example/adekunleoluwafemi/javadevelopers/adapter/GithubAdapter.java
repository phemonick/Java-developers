package com.example.adekunleoluwafemi.javadevelopers.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adekunleoluwafemi.javadevelopers.R;
import com.example.adekunleoluwafemi.javadevelopers.model.GithubUsers;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.GithubListHolder> {

    private List<GithubUsers> mGithubUsers;
    Context context;

    public GithubAdapter(List<GithubUsers> githubUsers, Context context) {
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
        GithubUsers users = mGithubUsers.get(position);
        holder.bind(users);
    }
    @Override
    public int getItemCount() {
        return mGithubUsers.size();
    }

    class GithubListHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private TextView mUserName;
        private TextView mUserTextView;
        private GithubUsers mGithubUsers;
        private CircleImageView circleImageView;


        public GithubListHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_user, parent, false));
            mUserName = itemView.findViewById(R.id.user_name);
            mUserTextView = itemView.findViewById(R.id.user_desc);
            circleImageView = itemView.findViewById(R.id.profile_image);

        }

        public void bind(GithubUsers githubUsers) {
            mGithubUsers = githubUsers;
            Log.d("Myusername", githubUsers.getUsername());

            mUserTextView.setText(githubUsers.getGithubLink());
            String imageUri = githubUsers.getUserImage();
            Picasso.with(context).load(imageUri).fit().centerCrop()
                    .placeholder(R.drawable.ic_launcher_background).into(circleImageView);
            mUserName.setText(githubUsers.getUsername());
        }
    }

}
