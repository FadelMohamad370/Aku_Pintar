package com.fadelmohamad.akupintar.View;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.fadelmohamad.akupintar.Adapter.UniversitasAdapter;
import com.fadelmohamad.akupintar.Model.UniversitasModel;
import com.fadelmohamad.akupintar.Database.SQLiteHelper;
import com.fadelmohamad.akupintar.R;

import java.util.ArrayList;
import java.util.List;

public class HalamanUtamaActivity extends AppCompatActivity {


    private RecyclerView rvList;

    private SQLiteHelper db;
    private UniversitasAdapter adapter;
    private List<UniversitasModel> univer = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);

        db = new SQLiteHelper(this);

        rvList = findViewById(R.id.rv_univ);

        adapter = new UniversitasAdapter(this);
        rvList.setLayoutManager(new LinearLayoutManager(this));

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                HalamanUtamaActivity.this, LinearLayoutManager.HORIZONTAL, false);
        rvList.setLayoutManager(layoutManager);
        rvList.setItemAnimator(new DefaultItemAnimator());
        rvList.setAdapter(adapter);


    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    private void getUnivtast(){
        univer = db.getUniv();
        adapter.setUniver(univer);
    }
}
