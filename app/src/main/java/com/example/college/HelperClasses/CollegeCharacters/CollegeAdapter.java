package com.example.college.HelperClasses.CollegeCharacters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.college.R;

import java.util.ArrayList;

public class CollegeAdapter extends RecyclerView.Adapter<CollegeAdapter.collegeViewHolder>{

    ArrayList<CollegeHelperClass> collegeLocations;

    public CollegeAdapter(ArrayList<CollegeHelperClass> collegeHelperClasses) {
        this.collegeLocations = collegeHelperClasses;
    }

    @NonNull
    @Override
    public collegeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.college_character,parent,false);
        return new collegeViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull collegeViewHolder holder, int position) {
        CollegeHelperClass collegeHelperClass = collegeLocations.get(position);
        holder.image.setImageResource(collegeHelperClass.getImage());
        holder.title.setText(collegeHelperClass.getTitle());
        holder.desc.setText(collegeHelperClass.getDesc());
    }

    @Override
    public int getItemCount() {
        return collegeLocations.size();
    }

    public static  class collegeViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title,desc;
        public collegeViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.college_banner_img);
            title = itemView.findViewById(R.id.college_card_title);
            desc = itemView.findViewById(R.id.college_card_desc);

        }
    }
}



