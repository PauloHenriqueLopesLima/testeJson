package com.example.testejson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mlsdev.animatedrv.AnimatedRecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private AnimatedRecyclerView recyclerView;
    private Button btnApiResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =  findViewById(R.id.recycler);
        btnApiResult = findViewById(R.id.btn_api);

        setupRecyclerView();


        btnApiResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ApiService service = RetrofitConfig.getRetrofitInstance().create(ApiService.class);
                Call<List<RequestApi>> call = service.requestApi();
                call.enqueue(new Callback<List<RequestApi>>() {
                    @Override
                    public void onResponse(Call<List<RequestApi>> call, Response<List<RequestApi>> response) {

                        Adapter adapter = new Adapter(response.body().get(0).getTopping(), getApplicationContext());
                        recyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        recyclerView.scheduleLayoutAnimation();
                    }

                    @Override
                    public void onFailure(Call<List<RequestApi>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }

    private void setupRecyclerView() {
        recyclerView = new AnimatedRecyclerView.Builder(this)

                .orientation(GridLayout.VERTICAL)
                .layoutManagerType(AnimatedRecyclerView.LayoutManagerType.GRID)
                .animation(R.anim.layout_animation_from_scale)
                .animationDuration(10000)
                .reverse(false)
                .build();

        recyclerView = findViewById(R.id.recycler);
    }
}
