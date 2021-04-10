package com.example.tolate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Filterable {

    ArrayList<Model> mlist;
    public ArrayList<Model> arrayListFiltered;

    public MyAdapter(ArrayList<Model> mlist) {
        this.mlist = mlist;
        this.arrayListFiltered = mlist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Model model = mlist.get(position);
        holder.price.setText(model.getPrice());
        holder.bedNumber.setText(model.getrFValue());
        holder.bathNumber.setText(model.getrSValue());
        holder.phone.setText(model.getPhoneNum());
        holder.location.setText(model.getLocation());

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{



        TextView price,bedNumber,bathNumber,phone,location;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            price = itemView.findViewById(R.id.txtPrice);
            bedNumber = itemView.findViewById(R.id.bedNumber);
            bathNumber = itemView.findViewById(R.id.bathNumber);
            phone = itemView.findViewById(R.id.txtPhone);
            location = itemView.findViewById(R.id.txtLocation);


        }
    }


    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Model> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(arrayListFiltered);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Model item : arrayListFiltered) {
                    if (item.getLocation().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            arrayListFiltered.clear();
            arrayListFiltered.addAll((ArrayList<Model>)results.values);
            notifyDataSetChanged();
        }
    };



}
