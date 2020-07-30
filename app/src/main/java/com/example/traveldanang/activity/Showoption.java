package com.example.traveldanang.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.traveldanang.R;
import com.example.traveldanang.adapter.DataShowAdapter;
import com.example.traveldanang.model.DataShow;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Showoption extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showoption);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null);
        String name = bundle.getString("name");
        String title = bundle.getString("title");
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle(title);
        String url = "http://192.168.2.42/api/"+name;
        //192.168.43.244 điện thoại
        Show(url);
    }
        private void Show(String url) {
        // Khởi tạo RecyclerView.
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        // Khởi tạo OkHttpClient để lấy dữ liệu.
        OkHttpClient client = new OkHttpClient();

        // Khởi tạo Moshi adapter để biến đổi json sang model java
        Moshi moshi = new Moshi.Builder().build();
        Type DataType = Types.newParameterizedType(List.class,DataShow.class);
        final JsonAdapter<ArrayList<DataShow>> jsonAdapter = moshi.adapter(DataType);

        // Tạo request lên server.
        Request request = new Request.Builder().url(url).build();
        //172.16.0.201
        // Thực thi request.
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Lỗi", "Kiểm tra lại internet");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                // Lấy thông tin JSON trả về
                String json = response.body().string();
                final ArrayList<DataShow> dataShows = jsonAdapter.fromJson(json);

               // Log.i("abcaa", json);

                // Cho hiển thị lên RecyclerView.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setAdapter(new DataShowAdapter(dataShows,Showoption.this));
                    }
                });
            }
        });
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