package ru.geekbrains.lesson5.solarsystem;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PlanetViewHolder> {

    private List<Planet> planets;

    // класс view holder-а с помощью которого мы получаем ссылку на каждый элемент
    // отдельного пункта списка
    static class PlanetViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        TextView mPlanetName;
        ImageView mPlanetImage;
        PlanetViewHolder(View v) {
            super(v);
            mCardView = (CardView) v.findViewById(R.id.cardview);
            mPlanetImage = (ImageView) v.findViewById(R.id.planet_image);
            mPlanetName = (TextView) v.findViewById(R.id.planet_name);
        }
    }

    // Конструктор
    RecyclerAdapter(List<Planet> planets) {
        this.planets = planets;
    }

    // Создает новые views (вызывается layout manager-ом)
    @Override
    public RecyclerAdapter.PlanetViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.planet_item_1, parent, false);
        // тут можно программно менять атрибуты лэйаута (size, margins, paddings и др.)
        return new PlanetViewHolder(v);
    }

    // Заменяет контент отдельного view (вызывается layout manager-ом)
    @Override
    public void onBindViewHolder(PlanetViewHolder holder, int position) {
        holder.mPlanetImage.setImageResource(planets.get(position).getPlanetImageId());
        holder.mPlanetName.setText(planets.get(position).getPlanetName());
    }

    // Возвращает размер данных (вызывается layout manager-ом)
    @Override
    public int getItemCount() {
        return planets.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



}
