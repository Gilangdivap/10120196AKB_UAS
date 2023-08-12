package com.example.a10120196akb_UAS;

/*
 *NIM : 10120196
 *Nama : Gilang Diva Prayoga
 *Kelas : IF-5
 *Email : gilang.10120196@mahasiswa.unikom.ac.id
 * */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CatatanAdapter extends RecyclerView.Adapter<CatatanAdapter.CatatanViewHolder> {

    private Context context;
    private ArrayList note_id, note_title, note_category, note_description;
    Activity activity;
    Animation translate_anim;



    public CatatanAdapter(Activity activity,Context context, ArrayList note_id, ArrayList note_title,ArrayList note_category,ArrayList note_description){
        this.activity = activity;
        this.context = context;
        this.note_id = note_id;
        this.note_title = note_title;
        this.note_category = note_category;
        this.note_description = note_description;

    }

    @NonNull
    @Override
    public CatatanAdapter.CatatanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row, parent, false);
        return new CatatanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatatanAdapter.CatatanViewHolder holder, int position) {


        holder.note_title.setText(String.valueOf(note_title.get(position)));
        holder.note_category.setText(String.valueOf(note_category.get(position)));
        holder.note_description.setText(String.valueOf(note_description.get(position)));

        holder.mainlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id",String.valueOf(note_id.get(position)));
                intent.putExtra("title",String.valueOf(note_title.get(position)));
                intent.putExtra("category",String.valueOf(note_category.get(position)));
                intent.putExtra("description",String.valueOf(note_description.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return note_id.size();
    }

    public class CatatanViewHolder extends RecyclerView.ViewHolder {

        private TextView note_title, note_category, note_description;
        LinearLayout mainlayout;
        public CatatanViewHolder(@NonNull View itemView) {
            super(itemView);
            note_title = itemView.findViewById(R.id.title_txt);
            note_category = itemView.findViewById(R.id.category_txt);
            note_description = itemView.findViewById(R.id.note_txt);

            mainlayout = itemView.findViewById(R.id.mainLayout);
            translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainlayout.setAnimation(translate_anim);
        }
    }
}
