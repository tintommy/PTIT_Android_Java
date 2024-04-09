package com.example.bt1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bt1.R;
import com.example.bt1.model.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterUser extends ArrayAdapter {

    Context context;
    int resource;
    List<User> data;

    public CustomAdapterUser(@NonNull Context context, int resource, @NonNull List<User> data) {
        super(context, resource, data);
        this.context = context;
        this.data = data;
        this.resource = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource, null);
        ImageView hinh = convertView.findViewById(R.id.ivHinh);
        TextView tvLogin = convertView.findViewById(R.id.tvLogin);
        TextView tvURL = convertView.findViewById(R.id.tvURL);
        User user = data.get(position);
        tvLogin.setText(user.getLogin());
        tvURL.setText(user.getUrl());
        Picasso.get().load(user.getAvatar_url()).into(hinh);
        return convertView;
    }

}
