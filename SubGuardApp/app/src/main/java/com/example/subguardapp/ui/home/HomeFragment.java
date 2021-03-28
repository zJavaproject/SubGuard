package com.example.subguardapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ListAdapter;

import com.example.subguardapp.R;
import com.example.subguardapp.dummy.ListviewItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // Get reference of widgets from XML layout
        final ListView ListView = (ListView)rootView.findViewById(R.id.transaction_list);

         // DataBind ListView with items from ArrayAdapter
        ListView.setAdapter(new ListviewAdapter(getActivity(), ListviewItem.TRANSACTION_ITEMS));

        return rootView;
    }
}
