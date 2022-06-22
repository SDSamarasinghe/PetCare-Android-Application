package com.example.petcare;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList pet_id,pet_name, pet_address, pet_gender;

    CustomAdapter(Context context, ArrayList pet_id,ArrayList pet_name,ArrayList pet_address, ArrayList pet_gender){
        this.context = context;
        this.pet_id = pet_id;
        this.pet_name = pet_name;
        this.pet_address = pet_address;
        this.pet_gender = pet_gender;



    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.pet_id_txt.setText(String.valueOf(pet_id.get(position)));
        holder.pet_name_txt.setText(String.valueOf(pet_name.get(position)));
        holder.pet_address_txt.setText(String.valueOf(pet_address.get(position)));
        holder.pet_gender_txt.setText(String.valueOf(pet_address.get(position)));
       // holder.book_pages_txt.setText(String.valueOf(book_pages.get(position)));

    }

    @Override
    public int getItemCount() {
        return pet_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView pet_id_txt, pet_name_txt, pet_address_txt,pet_gender_txt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pet_id_txt = itemView.findViewById(R.id.pet_id_txt);
            pet_name_txt = itemView.findViewById(R.id.pet_name_txt);
            pet_address_txt = itemView.findViewById(R.id.pet_address_txt);
            pet_gender_txt = itemView.findViewById(R.id.gender);
            //book_pages_txt = itemView.findViewById(R.id.book_pages_txt);
        }
    }
}
