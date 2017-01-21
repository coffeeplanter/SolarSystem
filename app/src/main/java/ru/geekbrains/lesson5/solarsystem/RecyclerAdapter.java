package ru.geekbrains.lesson5.solarsystem;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

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

    static class DwarfPlanetViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        TextView mPlanetName;
        TextView mPlanetType;
        ImageView mPlanetImage;
        DwarfPlanetViewHolder(View v) {
            super(v);
            mCardView = (CardView) v.findViewById(R.id.cardview);
            mPlanetImage = (ImageView) v.findViewById(R.id.planet_image);
            mPlanetName = (TextView) v.findViewById(R.id.planet_name);
            mPlanetType = (TextView) v.findViewById(R.id.planet_type);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if ((position >= 0) && (position <= 7)) {
            return 0;
        }
        else if ((position >= 8) && (position <= 12)) {
            return 1;
        }
        else if ((position >= 13) && (position <= 18)) {
            return 2;
        }
        else {
            return 0;
        }
    }

    // Конструктор
    RecyclerAdapter(List<Planet> planets) {
        this.planets = planets;
    }

    // Создает новые views (вызывается layout manager-ом)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {

        switch (viewType) {
            case 0:
                // create a new view
                View v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.planet_item_1, parent, false);
                // тут можно программно менять атрибуты лэйаута (size, margins, paddings и др.)
                return new PlanetViewHolder(v);
            case 1:
                View v1 = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.planet_item_2, parent, false);
                return new DwarfPlanetViewHolder(v1);
            case 2:
                View v3 = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.planet_item_2, parent, false);
                return new DwarfPlanetViewHolder(v3);
            default:
                View v4 = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.planet_item_1, parent, false);
                return new PlanetViewHolder(v4);
        }
    }

    // Заменяет контент отдельного view (вызывается layout manager-ом)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case 0:
                ((PlanetViewHolder) holder).mPlanetImage.setImageResource(planets.get(position).getPlanetImageId());
                ((PlanetViewHolder) holder).mPlanetName.setText(planets.get(position).getPlanetName());
                break;
            case 1:
                ((DwarfPlanetViewHolder) holder).mPlanetImage.setImageResource(planets.get(position).getPlanetImageId());
                ((DwarfPlanetViewHolder) holder).mPlanetName.setText(planets.get(position).getPlanetName());
                ((DwarfPlanetViewHolder) holder).mPlanetType.setText(R.string.dwarf_planet);
                break;
            case 2:
                ((DwarfPlanetViewHolder) holder).mPlanetImage.setImageResource(planets.get(position).getPlanetImageId());
                ((DwarfPlanetViewHolder) holder).mPlanetName.setText(planets.get(position).getPlanetName());
                ((DwarfPlanetViewHolder) holder).mPlanetType.setText(R.string.dwarf_planet_candidate);
                break;
        }
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
