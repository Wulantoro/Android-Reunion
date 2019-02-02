package com.example.wulantoro.reunion.Activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.wulantoro.reunion.Adapter.UserAdapter;
import com.example.wulantoro.reunion.Model.User;
import com.example.wulantoro.reunion.R;
import com.example.wulantoro.reunion.Utils.Server;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DataListActivity extends AppCompatActivity {
    private RecyclerView rv;
    private UserAdapter adapter;
    private Gson gson;
    private List<User> allList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);

        gson = new Gson();
        allList = new ArrayList<>();
        rv = findViewById(R.id.rvDataList);
        adapter = new UserAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);

        loadData();
    }

    private void loadData() {
        final ProgressDialog progress = new ProgressDialog(this);
        progress.setMessage("sedang proses");
        progress.setTitle("sedang proses");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.show();

        if (adapter != null)
            adapter.clearAll();

        AndroidNetworking.get(Server.BASE_IP + "user/readAll.php")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        List<User> results = new ArrayList<>();
                        try {
                            if (results != null)
                                results.clear();

                            String message = response.getString("message");

                            if (message.equals("success")) {
                                String records = response.getString("records");

                                JSONArray dataArr = new JSONArray(records);

                                if (dataArr.length() > 0) {
                                    for (int i = 0; i < dataArr.length(); i++) {
                                        User user = gson.fromJson(dataArr.getJSONObject(i).toString(), User.class);
                                        results.add(user);
                                    }

                                }
                            }
                            progress.dismiss();
                        } catch (JSONException e) {
                            e.printStackTrace();

                            progress.dismiss();
                        }

                        adapter.addAll(results);
                    }

                    @Override
                    public void onError(ANError anError) {
                        progress.dismiss();

                    }
                });

    }
}
