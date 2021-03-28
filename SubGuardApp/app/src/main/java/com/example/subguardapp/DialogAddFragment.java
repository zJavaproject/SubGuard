package com.example.subguardapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

import org.jetbrains.annotations.NotNull;

import static android.R.layout.simple_list_item_1;

public class DialogAddFragment extends DialogFragment  {

    public interface DialogAddListener {
        public void onDialogPositiveClick(String name, String cost);
    }

    DialogAddListener listener;


    @Override
    public void onAttach(@NotNull Context context) {
        super.onAttach(context);
        listener = (DialogAddListener) context;
    }



    @NotNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();


        View view =  inflater.inflate(R.layout.dialog_add, null);

        AutoCompleteTextView textView = view.findViewById(R.id.new_subscription);
        String[] propositions = getResources().getStringArray(R.array.subscription_propositions);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), simple_list_item_1, propositions);
        textView.setThreshold(1);
        textView.setAdapter(adapter);

        builder.setView(view)
                .setTitle(R.string.add_new_subscription)
                .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String sub = textView.getText().toString();
                        EditText pr = (EditText) view.findViewById(R.id.price);
                        String price = pr.getText().toString();
                        listener.onDialogPositiveClick(sub,price);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        com.example.subguardapp.DialogAddFragment.this.getDialog().cancel();
                    }
                }

                );

        return builder.create();

    }
}