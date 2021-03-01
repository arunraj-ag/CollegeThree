package com.example.college.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.college.R;

import java.util.ArrayList;

public class DeptAdapter extends RecyclerView.Adapter<DeptAdapter.deptViewHolder> {

    ArrayList<DeptHelperClass> deptLocations;
    onDeptListener nfonDeptListener;

    public DeptAdapter(ArrayList<DeptHelperClass> deptLocations,onDeptListener onDeptListener) {
        this.deptLocations = deptLocations;
        this.nfonDeptListener = onDeptListener;
    }

    @NonNull
    @Override
    public deptViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dept_card_design,parent,false);
        return new deptViewHolder(view, nfonDeptListener);
    }

    @Override
    public void onBindViewHolder(@NonNull deptViewHolder holder, int position) {
        DeptHelperClass deptHelperClass = deptLocations.get(position);
        holder.image.setImageResource(deptHelperClass.getImage());
        holder.title.setText(deptHelperClass.getTitle());
        holder.desc.setText(deptHelperClass.getDesc());

    }

    @Override
    public int getItemCount() {
        return deptLocations.size();
    }

    public static class deptViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        TextView title,desc;
        onDeptListener onDeptListener;

        public deptViewHolder(@NonNull View itemView,onDeptListener onDeptListener) {
            super(itemView);

            image = itemView.findViewById(R.id.dept_img);
            title = itemView.findViewById(R.id.dept_title);
            desc = itemView.findViewById(R.id.dept_desc);
            this.onDeptListener = onDeptListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onDeptListener.onDeptClick(getAdapterPosition());
        }
    }
    public interface onDeptListener{
            void onDeptClick(int position);

    }
}
