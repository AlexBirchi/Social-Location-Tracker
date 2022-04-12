package com.social_location_tracker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.social_location_tracker.R;

import java.util.List;

public class FriendRequestsRecyclerViewAdapter extends RecyclerView.Adapter<FriendRequestsRecyclerViewAdapter.ViewHolder> {
    Context context;
    List<String> usernames;

    public FriendRequestsRecyclerViewAdapter(Context context, List<String> usernames) {
        this.usernames = usernames;
        this.context = context;
    }

    @NonNull
    @Override
    public FriendRequestsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_friend_requests_item, parent, false);
        FriendRequestsRecyclerViewAdapter.ViewHolder holder = new FriendRequestsRecyclerViewAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FriendRequestsRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.friendRequestUsername.setText(usernames.get(position));
    }

    @Override
    public int getItemCount() {
        return usernames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView friendRequestUsername;
        ImageButton buttonAccept;
        ImageButton buttonDecline;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            friendRequestUsername = itemView.findViewById(R.id.friend_request_username_text_view);
            buttonAccept = itemView.findViewById(R.id.imageButtonAccept);
            buttonDecline = itemView.findViewById(R.id.imageButtonDecline);
        }
    }
}
