package com.example.abhigrith_authority.orphanage.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abhigrith_authority.R;
import com.example.abhigrith_authority.orphanage.models.OrphanageDetails;

import java.util.ArrayList;

public class OrphanageAuthRequestListAdapter extends RecyclerView.Adapter<OrphanageAuthRequestListAdapter.OrphanageViewHolder> {
    private Context context;
    private OnOrphanageItemClickListener onOrphanageItemClickListener;
    private ArrayList<OrphanageDetails> pendingOrphanageAuthLists;

    public OrphanageAuthRequestListAdapter(Context context, OnOrphanageItemClickListener onOrphanageItemClickListener, ArrayList<OrphanageDetails> pendingOrphanageAuthLists){
        this.context = context;
        this.onOrphanageItemClickListener = onOrphanageItemClickListener;
        this.pendingOrphanageAuthLists = pendingOrphanageAuthLists;
    }

    // TODO :: Complete ViewHolder Class
    public static class OrphanageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView name;
        public TextView fcra;
        public TextView pincode;
        public TextView address;

        OnOrphanageItemClickListener onOrphanageItemClickListener;

        public OrphanageViewHolder(@NonNull View itemView, OnOrphanageItemClickListener onOrphanageItemClickListener) {
            super(itemView);
            fcra = itemView.findViewById(R.id.tv_orphanage_pending_auth_requests_id);
            name = itemView.findViewById(R.id.tv_orphanage_pending_auth_requests_name);
            address = itemView.findViewById(R.id.tv_orphanage_pending_auth_requests_address);
            pincode = itemView.findViewById(R.id.tv_orphanage_pending_auth_requests_pincode);

            this.onOrphanageItemClickListener = onOrphanageItemClickListener;

            itemView.setOnClickListener(this);
        }

        // TODO :: Will write logic to bind views here
        void bindData(OrphanageDetails orphanageDetails){
            fcra.setText(orphanageDetails.getOrphanageFCRANumber());
            name.setText(orphanageDetails.getNameOfOrphanage());
            address.setText(orphanageDetails.getDetailedOrphanageAddress());
            pincode.setText(String.valueOf(orphanageDetails.getPincode()));
        }

        @Override
        public void onClick(View v) {
            // TODO :: This will be implemented afterwards and only one method will be used
            onOrphanageItemClickListener.onItemClick(getAdapterPosition());
            // onOrphanageItemClickListener.onItemsClick();
        }
    }

    @NonNull
    @Override
    public OrphanageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_orphanage_pending_auth_requests,parent,false);
        return new OrphanageViewHolder(view,this.onOrphanageItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull OrphanageViewHolder holder, int position) {
        holder.bindData(pendingOrphanageAuthLists.get(position));
    }

    @Override
    public int getItemCount() {
        return pendingOrphanageAuthLists.size();
    }

    public interface OnOrphanageItemClickListener {
        // TODO :: Only 1 will be implemnted of either of the two
        void onItemClick(int position);
        void onItemsClick(OrphanageDetails orphanageDetails);
    }
}
