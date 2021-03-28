package com.example.subguardapp.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.subguardapp.R;
import com.example.subguardapp.dummy.ListviewItem;

import java.util.List;

public class ListviewAdapter extends BaseAdapter {
    private static List<ListviewItem.ListItem> list;

    private LayoutInflater mInflater;

    public ListviewAdapter(Context photosFragment, List<ListviewItem.ListItem> results){
        list = results;
        mInflater = LayoutInflater.from(photosFragment);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.transaction_list_item, null);
            holder = new ViewHolder();
            TextView txtname = (TextView) convertView.findViewById(R.id.transaction_name);
            ListviewItem.ListItem item = (ListviewItem.ListItem) getItem(position);
            txtname.setText(item.name);
            holder.txtprice = (TextView) convertView.findViewById(R.id.price);
            txtname.setText(item.cost);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

    static class ViewHolder{
        TextView txtname, txtprice;
    }
}