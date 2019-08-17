package com.example.bts_details;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewBTSAdapter extends RecyclerView.Adapter<CardViewBTSAdapter.CardViewViewHolder>{

    private ArrayList<BTS> listBTS;
    private Context context;

    public CardViewBTSAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<BTS> getListBTS() {
        return listBTS;
    }

    public void setListBTS(ArrayList<BTS> listBTS) {
        this.listBTS = listBTS;
    }



    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_bts, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder holder, final int position) {
        BTS bts = getListBTS().get(position);
        Glide.with(context)
                .load(bts.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.tvName.setText(bts.getName());
        holder.tvRemarks.setText(bts.getRemarks());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Anda Memilih " + getListBTS().get(position).getName(), Toast.LENGTH_SHORT).show();

                switch (getListBTS().get(position).getName()) {
                    case "RM":
                        Intent rm = new Intent(context, RMActivity.class);
                        context.startActivity(rm);
                        break;

                    case "Jin":
                        Intent jin = new Intent(context, JinActivity.class);
                        context.startActivity(jin);
                        break;

                    case "Suga":
                        Intent suga = new Intent(context, SugaActivity.class);
                        context.startActivity(suga);
                        break;

                    case "J-Hope":
                        Intent jhope = new Intent(context, JHopeActivity.class);
                        context.startActivity(jhope);
                        break;

                    case "Jimin":
                        Intent jimin = new Intent(context, JiminActivity.class);
                        context.startActivity(jimin);
                        break;

                    case "V":
                        Intent vi = new Intent(context, VActivity.class);
                        context.startActivity(vi);
                        break;

                    case "Jungkook":
                        Intent jungkook = new Intent(context, JungkookActivity.class);
                        context.startActivity(jungkook);
                        break;

                }
            }
        });

        holder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorite " + getListBTS().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

        holder.btnShare.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Details " + getListBTS().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListBTS().size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnFavorite, btnShare;
        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnShare = itemView.findViewById(R.id.btn_set_share);
        }
    }
}