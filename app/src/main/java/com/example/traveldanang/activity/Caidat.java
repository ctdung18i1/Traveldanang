package com.example.traveldanang.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.traveldanang.R;

public class Caidat extends AppCompatActivity {
    Toolbar toolbar;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caidat);
        Tbar();
        textView = (TextView)findViewById(R.id.textView);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null);
        String tk = bundle.getString("name");
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