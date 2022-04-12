package com.social_location_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.social_location_tracker.adapters.FriendRequestsRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewFriendRequestsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FriendRequestsRecyclerViewAdapter adapter;
    List<String> friendRequests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_friend_requests);

        // Bind views to its controls
        recyclerView = findViewById(R.id.friend_request_list);
        // Manage notifications
        seedFriendRequestsData();
    }

    private void initRecyclerView()
    {
        adapter = new FriendRequestsRecyclerViewAdapter(this, friendRequests);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void seedFriendRequestsData()
    {
        friendRequests = new ArrayList<>();
        friendRequests.add("Alex");
        friendRequests.add("Johnny");
        friendRequests.add("Alex");
        initRecyclerView();
    }
}