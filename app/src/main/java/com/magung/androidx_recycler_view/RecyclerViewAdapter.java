package com.magung.androidx_recycler_view;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CategoryViewHolder> {
    private Context context;
    private List<President> list; // list = variable untuk menumpuk data, yang akan disimpan ke dalam class President

    public RecyclerViewAdapter(Context context, List<President> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //tempat mengenalkan atau menggunakan layout, ini baku ya... kamu cuma ubah nama layoutnya saja
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_president,parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.CategoryViewHolder holder, int position) {
        //tempat memasukkan atau menampilkan data dari class President kedalam layout
        holder.tvName.setText(list.get(position).getName());
        holder.tvRemarks.setText(list.get(position).getRemarks());

        Glide.with(context)
                .load(list.get(position).getPhoto())
                .override(55,55)
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        // ini tempat untuk definisikan widget (objext text view)
        @BindView(R.id.tv_item_name) TextView tvName;
        @BindView(R.id.tv_item_remarks) TextView tvRemarks;
        @BindView(R.id.img_item_photo) ImageView imgPhoto;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
