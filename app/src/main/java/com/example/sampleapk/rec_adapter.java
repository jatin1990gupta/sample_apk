package com.example.sampleapk;

import android.content.Context;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class rec_adapter extends RecyclerView.Adapter<rec_adapter.ViewHolder> {

    ArrayList<data> mdata;
    Context context;

    public rec_adapter(ArrayList<data> data, Context context) {
        mdata = data;
        this.context = context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameTV, contactTV, emailTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV =(TextView)itemView.findViewById(R.id.nameTV);
            contactTV =(TextView)itemView.findViewById(R.id.contactTV);
            emailTV =(TextView)itemView.findViewById(R.id.emailTV);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_blueprint, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        data dts = mdata.get(position);
        holder.nameTV.setText(dts.name);
        holder.contactTV.setText(dts.contact);
        holder.emailTV.setText(dts.email);
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

}
