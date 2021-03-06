package com.example.subguardapp.ui.details;

import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
//import android.graphics.Color;
import android.graphics.Color;
import android.net.Uri;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.subguardapp.R;
import com.example.subguardapp.dummy.ListItemContent.ListItem;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link ListItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<ListItem> mValues;

    public MyItemRecyclerViewAdapter(List<ListItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
//        holder.mLogo.setImageURI(Uri.parse(mValues.get(position).logo) + ".png");
//        File imgFile = new  File("/res/drawable/" + mValues.get(position).logo + ".png");
//        if(imgFile.exists()) {
//            holder.mLogo.setImageURI(Uri.fromFile(imgFile));
//        }

//        Bitmap bitmap = BitmapFactory.decodeFile("/main/res/drawable/" + mValues.get(position).logo + ".png");
//        holder.mLogo.setImageBitmap(bitmap);
        holder.mLogo.setImageResource(mValues.get(position).logo);

//        holder.mLogo.setImageURI(Uri.fromFile(mValues.get(position).logo));
        holder.mName.setText(mValues.get(position).name);
        holder.mLastLogin.setText(mValues.get(position).lastLogin);
        holder.mLastLoginDuration.setText(mValues.get(position).lastLoginDuration);
        holder.mCost.setText(mValues.get(position).cost);

        Date today = new Date();
        Date myDate = new Date(today.getYear(),today.getMonth()-1,today.getDay());
        if (dotStringToDate(mValues.get(position).lastLogin).compareTo(myDate) <  1){
          holder.mLastLogin.setTextColor(Color.parseColor("#c40e7b"));//new Color(153,0,0)
          holder.mLastLogin.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        }
    }

    public static Date dotStringToDate(String date) {
        String[] splitDate = date.split("\\.");
        int day = Integer.parseInt(splitDate[0]);
        int month = Integer.parseInt(splitDate[1]) - 1;
        int year = Integer.parseInt(splitDate[2]) - 1900;
        return new Date(year, month, day);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mLogo;
        public final TextView mName;
        public final TextView mLastLogin;
        public final TextView mLastLoginDuration;
        public final TextView mCost;
        public ListItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mLogo = (ImageView) view.findViewById(R.id.logo);
            mName = (TextView) view.findViewById(R.id.item_name);
            mLastLogin = (TextView) view.findViewById(R.id.last_login);
            mLastLoginDuration = (TextView) view.findViewById(R.id.last_login_duration);
            mCost = (TextView) view.findViewById(R.id.item_cost);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + mName.getText() + "'";
        }
    }
}