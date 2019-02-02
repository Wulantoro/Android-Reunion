package com.example.wulantoro.reunion;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wulantoro.reunion.Activity.DataListActivity;
import com.example.wulantoro.reunion.Utils.AppPermissions;
import com.example.wulantoro.reunion.Utils.GlobalHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Login extends AppCompatActivity {

    private Button btn_reg;
    private Button btn_login;

    private static final String[] ALL_PERMISSIONS = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    };

    private static final int WRITE_EXTERNAL_STORAGE_CODE = 901;
    private static final int READ_EXTERNAL_STORAGE_CODE = 902;
    private static final int CAMERA_CODE = 904;
    private static final int ACCESS_CALL_PHONE = 903;
    private static final int ALL_REQUEST_CODE = 999;
    private AppPermissions mRuntimePermission;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mRuntimePermission = new AppPermissions(this);

        if (mRuntimePermission.hasPermission(ALL_PERMISSIONS)) {
            GlobalHelper.CreateFolder();
        }else{
            mRuntimePermission.requestPermission(this, ALL_PERMISSIONS, ALL_REQUEST_CODE);
        }

        btn_reg = findViewById(R.id.btn_reg);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Registrasi.class );
                startActivity(intent);
            }
        });

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten2 = new Intent(getApplicationContext(), DataListActivity.class);
                startActivity(inten2);
            }
        });

    }




   /* @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                                     @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case ALL_REQUEST_CODE:
                List<Integer> permissionResults = new ArrayList<>();
                for (int grantResult : grantResults) {
                    permissionResults.add(grantResult);
                }
                if (permissionResults.contains(PackageManager.PERMISSION_DENIED)) {
                    Toast.makeText(this, getString(R.string.all_permission_not_granted), Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(this, getString(R.string.all_permission_granted), Toast.LENGTH_SHORT).show();
                    refreshActivity();
                }
                break;
            case WRITE_EXTERNAL_STORAGE_CODE:
                if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                    Toast.makeText(this, getString(R.string.write_external_permission_not_granted), Toast.LENGTH_SHORT).show();
                } else {
                    //Toast.makeText(this, "Write External Storage Permissions granted", Toast.LENGTH_SHORT).show();
                }
                finish();
                break;
            case READ_EXTERNAL_STORAGE_CODE:
                if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                    Toast.makeText(this, getString(R.string.read_external_permission_not_granted), Toast.LENGTH_SHORT).show();
                } else {
                    //Toast.makeText(this, "Read External Storage Permissions granted", Toast.LENGTH_SHORT).show();
                }
                finish();
                break;
            case CAMERA_CODE:
                if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                    Toast.makeText(this, getString(R.string.camera_permission_not_granted), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Camera Permissions granted", Toast.LENGTH_SHORT).show();
                }
                finish();
                break;


        }
    }

    private void refreshActivity(){
        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
    }
*/


}
