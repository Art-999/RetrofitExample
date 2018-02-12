package com.example.arturmusayelyan.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.arturmusayelyan.retrofitexample.models.Contacts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Contacts> contactsList;
    private ApiInterface apiInterface;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_view);
        progressBar=findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Contacts>> call=apiInterface.getContacts();
        call.enqueue(new Callback<List<Contacts>>() {

            @Override
            public void onResponse(Call<List<Contacts>> call, Response<List<Contacts>> response) {
                contactsList=response.body();
                adapter=new RecyclerAdapter(contactsList);
                recyclerView.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<Contacts>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Check your internet connection",Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}
