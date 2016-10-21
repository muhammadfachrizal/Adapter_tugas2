package com.example.mfachrizal.student;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomUsersAdapter extends ArrayAdapter<Student> {
    public CustomUsersAdapter(Context context, ArrayList<Student> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Student user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_main, parent, false);
        }
        // Lookup view for data population
        TextView tvId = (TextView) convertView.findViewById(R.id.id);
        TextView tvNoreg = (TextView) convertView.findViewById(R.id.noreg);
        TextView tvNama = (TextView) convertView.findViewById(R.id.nama);
        TextView tvMail = (TextView) convertView.findViewById(R.id.mail);
        TextView tvPhone = (TextView) convertView.findViewById(R.id.phone);
        // Populate the data into the template view using the data object
        tvId.setText(user.getId()+"");
        tvNoreg.setText(user.getNoreg());
        tvNama.setText(user.getNama());
        tvMail.setText(user.getMail());
        tvPhone.setText(user.getPhone());
        return convertView;
    }

}
