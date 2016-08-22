package com.example.nava_pc.workshop.Holder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nava_pc.workshop.R;

/**
 * Created by NAVA-PC on 8/19/2016.
 * ALT + ENTER
 */

public class HolderItem extends RecyclerView.ViewHolder {

    public TextView txt_judul, txt_waktu;
    public CardView carditem_planet;
    public ImageView img_icon;

    public HolderItem(View itemView) {
        super(itemView);
        carditem_planet = (CardView) itemView.findViewById(R.id.carditem_planet);
        txt_judul = (TextView) itemView.findViewById(R.id.txt_judul);
        txt_waktu = (TextView) itemView.findViewById(R.id.txt_waktu);
        img_icon = (ImageView) itemView.findViewById(R.id.img_icon);
    }
}
