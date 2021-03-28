package com.example.subguardapp.ui.grid;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.subguardapp.R;
import com.example.subguardapp.dummy.ListItemContent.ListItem;

import java.util.List;

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.ViewHolder> {

    private final List<ListItem> mValues;

    public GridViewAdapter(java.util.List<ListItem> items) { mValues = items; }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewAdapter.ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
//        holder.mLogo.setImageURI(Uri.parse(mValues.get(position).logo));
        holder.mLogo.setImageResource(mValues.get(position).logo);
    }

    @Override
    public int getItemCount() { return mValues.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mLogo;
        public ListItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mLogo = (ImageView) view.findViewById(R.id.grid_logo);
        }

    }
}
