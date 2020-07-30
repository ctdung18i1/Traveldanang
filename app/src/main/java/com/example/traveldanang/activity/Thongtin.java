package com.example.traveldanang.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.traveldanang.R;

import java.util.ArrayList;

public class Thongtin extends AppCompatActivity {
    Toolbar toolbar;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtin);

        Tbar();
        Lview();
        CatchOnItem();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null);
        String tk = bundle.getString("name");
    }

    private void CatchOnItem() {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        String number = "12345";
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:" +number));
                        startActivity(intent);
                    case 1:
                        Intent case1 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" +123456));
                        startActivity(case1);
                }
            }
        });
    }

    private void Lview() {
        ArrayList<String> objListCity = new ArrayList<String>();
        objListCity.add("Công An: 113");
        objListCity.add("Cứu hỏa: 114");
        objListCity.add("Cấp cứu: 115");
        objListCity.add("Đường dây nóng: 3174124");
        objListCity.add("Cảnh sát cơ động: 2214141");

        list = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, objListCity);
        list.setAdapter(adapter);

    }

    private void Tbar() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
}