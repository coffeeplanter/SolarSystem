package ru.geekbrains.lesson5.solarsystem;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Planet> planets;
    String[] urlsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView;
        RecyclerView.Adapter mAdapter;
        RecyclerView.LayoutManager mLayoutManager;

        urlsArray = getResources().getStringArray(R.array.urls);

        initializeData();

        //String[] myDataset = getDataSet();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        // если мы уверены, что изменения в контенте не изменят размер layout-а RecyclerView
        // передаем параметр true - это увеличивает производительность
        //mRecyclerView.setHasFixedSize(true);

        // используем linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // создаем адаптер
        mAdapter = new RecyclerAdapter(planets);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, mRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlsArray[position]));
                //startActivity(intent);
                Intent intent = new Intent(MainActivity.this, WebActivity.class);
                intent.putExtra(WebActivity.WEB_LINK, urlsArray[position]);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MainActivity.this, "Долго жать не нужно.", Toast.LENGTH_SHORT).show();
            }
        }));
    }

    private void initializeData(){
        String[] planetsArray = getResources().getStringArray(R.array.planets);
        planets = new ArrayList<>();
        planets.add(new Planet("Венера", R.drawable.mercury));
        planets.add(new Planet(planetsArray[1], R.drawable.venus));
        planets.add(new Planet(planetsArray[2], R.drawable.earth));
        planets.add(new Planet(planetsArray[3], R.drawable.mars));
        planets.add(new Planet(planetsArray[4], R.drawable.jupiter));
        planets.add(new Planet(planetsArray[5], R.drawable.saturn));
        planets.add(new Planet(planetsArray[6], R.drawable.uranus));
        planets.add(new Planet(planetsArray[7], R.drawable.neptune));
    }

}
