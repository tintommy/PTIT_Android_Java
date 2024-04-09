package com.example.bt1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.bt1.adapter.CustomAdapterUser;
import com.example.bt1.adapter.CustomAdapter_SP;
import com.example.bt1.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity10 extends AppCompatActivity {

    ListView lvDanhSach;
   SearchView svDanhSach;
    List<User> data = new ArrayList<>();
    List<User> dataAll= new ArrayList<>();
    CustomAdapterUser adapterUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        setControl();
        DocDL();
    }

    private void setEvent() {

        Log.e("MyTag", String.valueOf(data.size()));
        adapterUser = new CustomAdapterUser(this, R.layout.item_user_layout, data);
        lvDanhSach.setAdapter(adapterUser);
        svDanhSach.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                data.clear();
                if(s.equals(""))
                {
                    data.addAll(dataAll);
                }
                else {
                    for(User user : dataAll){
                        if(user.getLogin().contains(s))
                            data.add(user);
                    }
                }
               adapterUser.notifyDataSetChanged();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                data.clear();
                if(s.equals(""))
                {
                    data.addAll(dataAll);
                }
                else {
                    for(User user : dataAll){
                        if(user.getLogin().contains(s))
                            data.add(user);
                    }
                }
                adapterUser.notifyDataSetChanged();

                return false;
            }
        });
    }

    private void DocDL() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://api.github.com/users";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject item = response.getJSONObject(i);
                        User user = new User();
                        user.setLogin(item.getString("login"));
                        user.setUrl(item.getString("url"));
                        user.setAvatar_url(item.getString("avatar_url"));
                        data.add(user);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
                dataAll.addAll(data);
                setEvent();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity10.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(request);


    }

    private void setControl() {
        lvDanhSach = findViewById(R.id.lvDanhSach);
        svDanhSach= findViewById(R.id.svDanhSach);
    }

}