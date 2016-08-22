package com.example.nava_pc.workshop.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.nava_pc.workshop.DetailActivity;
import com.example.nava_pc.workshop.Holder.HolderItem;
import com.example.nava_pc.workshop.R;
import com.example.nava_pc.workshop.itemObject;

import java.util.List;

/**
 * Created by NAVA-PC on 8/19/2016.
 */
public class AdapterItem extends RecyclerView.Adapter<HolderItem> {

    //Sebuah fungsi menandaakan bahwa si class ini digunakan pada activity mana
    Context context;
    List<itemObject.Children> itemObjects;

    public AdapterItem(Context context, List<itemObject.Children> itemObjects){
        this.context = context;
        this.itemObjects = itemObjects;

    }

    @Override
    public HolderItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carditem, null);
        HolderItem holderItem = new HolderItem(view);
        return holderItem;
    }

    @Override
    public void onBindViewHolder(HolderItem holder, final int position) {
        holder.txt_judul.setText(itemObjects.get(position).planet_name);
        holder.txt_waktu.setText(itemObjects.get(position).date_created);

        Glide.with(context)
                .load("http://dev.daeng.id/android/icon/" +
                        itemObjects.get(position).planet_icon)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.img_icon);

        holder.carditem_planet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DetailActivity.class);
                i.putExtra("judul", itemObjects.get(position).planet_name);
                i.putExtra("waktu", itemObjects.get(position).date_created);
                i.putExtra("massa", itemObjects.get(position).mass);
                i.putExtra("luas permukaan", itemObjects.get(position).surface_area);
                i.putExtra("volume", itemObjects.get(position).volume);
                i.putExtra("khatulistiwa", itemObjects.get(position).equator);
                i.putExtra("foto sampul", itemObjects.get(position).header_img);
                i.putExtra("ikon planet", itemObjects.get(position).planet_icon);
                i.putExtra("deskripsi", itemObjects.get(position).description);
                i.putExtra("situs wiki", itemObjects.get(position).wiki_site);
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemObjects.size();
    }
}
