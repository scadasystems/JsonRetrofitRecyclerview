package org.lulzm.jsonretrofitrecyclerview;


import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.lulzm.jsonretrofitrecyclerview.SOS.ApiService;
import org.lulzm.jsonretrofitrecyclerview.SOS.Datum;
import org.lulzm.jsonretrofitrecyclerview.SOS.RetroClient;
import org.lulzm.jsonretrofitrecyclerview.SOS.SOSAdapter;
import org.lulzm.jsonretrofitrecyclerview.SOS.SosList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Datum> datumList;
    private ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private SOSAdapter sosAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("데이터 로딩중...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiService api = RetroClient.getApiService();


        Call<SosList> call = api.getMyJSON();

        call.enqueue(new Callback<SosList>() {
            @Override
            public void onResponse(Call<SosList> call, Response<SosList> response) {

                progressDialog.dismiss();

                if (response.isSuccessful()) {
                    datumList = response.body().getData();
                    recyclerView = findViewById(R.id.post_recycler_view);
                    sosAdapter = new SOSAdapter(datumList);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(sosAdapter);
                }
            }

            @Override
            public void onFailure(Call<SosList> call, Throwable t) {
                progressDialog.dismiss();
            }
        });
    }
}
