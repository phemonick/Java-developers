package com.example.adekunleoluwafemi.javadevelopers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {

    private static final String GITHUB_IMAGE = "com.example.adekunleoluwafemi.githubImage";
    private static final String GITHUB_USERNAME = "com.example.adekunleoluwafemi.githubUserName";
    private static final String GITHUB_LINK = "com.example.adekunleoluwafemi.githubLink";
    private static final String IS_ADMIN = "com.example.adekunleoluwafemi.isAdmin";
    private static final String USER_ID = "com.example.adekunleoluwafemi.userId";

    private CircleImageView mUserImage;
    TextView userName;
    TextView admin;
    TextView githubLink;
    TextView userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        userName = findViewById(R.id.user_name);
        mUserImage = findViewById(R.id.display_image);
        githubLink = findViewById(R.id.github_link);
        admin = findViewById(R.id.is_admin);
        userId = findViewById(R.id.user_id);
        String name = getIntent().getStringExtra(GITHUB_USERNAME);
        String image = getIntent().getStringExtra(GITHUB_IMAGE);
        String link = getIntent().getStringExtra(GITHUB_LINK);
        String id = getIntent().getStringExtra(USER_ID);
        boolean isAdmin = getIntent().getBooleanExtra(IS_ADMIN, false);

        Picasso.with(this).load(image).fit().centerCrop()
                .placeholder(R.drawable.ic_launcher_background).into(mUserImage);
        userName.setText(name);
        admin.setText(""+isAdmin);
        userId.setText(id);
        githubLink.setText(link);

    }

    public static Intent newIntent(Context packageContext, boolean admin, String id,
                                   String userImage, String userName, String githubLink){
        Intent intent = new Intent(packageContext, DetailActivity.class);
        Bundle extras = new Bundle();
        extras.putString(GITHUB_IMAGE, userImage);
        extras.putString(GITHUB_USERNAME, userName);
        extras.putString(GITHUB_LINK, githubLink);
        extras.putString(USER_ID, id);
        extras.putBoolean(IS_ADMIN, admin);
        intent.putExtras(extras);
        return intent;
    }
}
