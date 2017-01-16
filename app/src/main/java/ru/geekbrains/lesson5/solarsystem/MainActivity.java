package ru.geekbrains.lesson5.solarsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Planet> planets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }

    private void initializeData(){
        planets = new ArrayList<>();
        planets.add(new Planet(getString(R.string.mercury), R.drawable.mercury));
        planets.add(new Planet(getString(R.string.venus), R.drawable.venus));
        planets.add(new Planet(getString(R.string.earth), R.drawable.earth));
        planets.add(new Planet(getString(R.string.mars), R.drawable.mars));
        planets.add(new Planet(getString(R.string.jupiter), R.drawable.jupiter));
        planets.add(new Planet(getString(R.string.saturn), R.drawable.saturn));
        planets.add(new Planet(getString(R.string.uranus), R.drawable.uranus));
        planets.add(new Planet(getString(R.string.neptune), R.drawable.neptune));
    }

}
