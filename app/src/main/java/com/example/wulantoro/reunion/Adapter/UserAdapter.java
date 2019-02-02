package com.example.wulantoro.reunion.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.wulantoro.reunion.Model.User;
import com.example.wulantoro.reunion.R;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private Context context;
    private List<User> list;

    public UserAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);
        final UserAdapter.ViewHolder holder = new UserAdapter.ViewHolder(v);
        return holder;
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        final User user = list.get(holder.getAdapterPosition());

        holder.tvName.setText(user.getName_user());
        holder.tvEmail.setText(user.getEmail_user());

       /* Glide.with(context)
                .load(user.getImage_user())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .dontAnimate()
                .into(holder.ivUser);*/
    }

    public int getItemCount() {
        return list.size();
    }

    public void add(User r) {
        list.add(r);
        notifyItemInserted(list.size() - 1);
    }

    public void addAll(List<User> moveResult) {
        for (User result : moveResult) {
            add(result);
        }
    }

    private void remove(User r) {
        int position = list.indexOf(r);
        if (position > -1) {
            list.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public void clearAll() {
        if (!list.isEmpty()) {
            list.clear();
            notifyDataSetChanged();
        }
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }

    private User getItem(int position) {
        if (list != null) {
            return list.get(position);
        }
        return null;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivUser;
        public TextView tvName;
        public TextView tvEmail;

        private ViewHolder(View itemView) {
            super(itemView);

            ivUser = itemView.findViewById(R.id.ivUser);
            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
        }
    }

}
