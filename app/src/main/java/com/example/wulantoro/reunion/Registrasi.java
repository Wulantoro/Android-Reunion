package com.example.wulantoro.reunion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.wulantoro.reunion.Utils.Server;

import org.json.JSONException;
import org.json.JSONObject;

public class Registrasi extends AppCompatActivity {
    private EditText txtName;
    private EditText txtEmail;
    private EditText txtPassword;
    private Button btn_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btn_reg = findViewById(R.id.btn_reg);

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewUser();
            }
        });
    }

    private void saveNewUser() {
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("name_user", txtName.getText().toString());
            jsonObject.put("email_user", txtEmail.getText().toString());
            jsonObject.put("pass_user", txtPassword.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(Server.BASE_IP+"user/create_user.php")
                .addJSONObjectBody(jsonObject) //posting json
        .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String message = response.getString("message");
                            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "JSONException "+ e, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        //handle error
                        Toast.makeText(getApplicationContext(), "Gagal menambah data", Toast.LENGTH_SHORT).show();

                    }
                });
    }
}
