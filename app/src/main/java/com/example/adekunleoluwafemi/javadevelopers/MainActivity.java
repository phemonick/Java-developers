package com.example.adekunleoluwafemi.javadevelopers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mUserList;
    private Button mDetailsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserList = findViewById(R.id.my_recycler_view);
        mDetailsButton = findViewById(R.id.to_detail);
    }

    public void toNextPage(View view) {
        startActivity(new Intent(this, DetailActivity.class));
    }
}
