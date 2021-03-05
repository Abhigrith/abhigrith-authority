package com.example.abhigrith_authority.orphanage.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abhigrith_authority.R;
import com.example.abhigrith_authority.orphanage.models.OrphanageDetails;

import java.util.ArrayList;

public class OrphanageAuthRequestListAdapter extends RecyclerView.Adapter<OrphanageAuthRequestListAdapter.OrphanageViewHolder> {
    private final Context context;
    private final OnOrphanageItemClickListener onOrphanageItemClickListener;
    private final ArrayList<OrphanageDetails> pendingOrphanageAuthLists;

    public OrphanageAuthRequestListAdapter(Context context, OnOrphanageItemClickListener onOrphanageItemClickListener, ArrayList<OrphanageDetails> pendingOrphanageAuthLists) {
        this.context = context;
        this.onOrphanageItemClickListener = onOrphanageItemClickListener;
        this.pendingOrphanageAuthLists = pendingOrphanageAuthLists;
    }

    //Complete ViewHolder Class
    public static class OrphanageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tv_name_of_orphanage_owner;
        public ImageView iv_orphanage_profile_picture;
        public TextView tv_state_of_orphanage;
        public TextView tv_location_of_orphanage;

        OnOrphanageItemClickListener onOrphanageItemClickListener;

        public OrphanageViewHolder(@NonNull View itemView, OnOrphanageItemClickListener onOrphanageItemClickListener) {
            super(itemView);
            iv_orphanage_profile_picture = itemView.findViewById(R.id.iv_orphanage_profile_picture);
            tv_name_of_orphanage_owner = itemView.findViewById(R.id.tv_name_of_orphanage_owner);
            tv_location_of_orphanage = itemView.findViewById(R.id.tv_location_of_orphanage);
            tv_state_of_orphanage = itemView.findViewById(R.id.tv_state_of_orphanage);

            this.onOrphanageItemClickListener = onOrphanageItemClickListener;

            itemView.setOnClickListener(this);
        }

        //Will write logic to bind views here
        void bindData(OrphanageDetails orphanageDetails) {
//            fcra.setText(orphanageDetails.getOrphanageFCRANumber());
            tv_name_of_orphanage_owner.setText(orphanageDetails.getNameOfOrphanage());
            tv_location_of_orphanage.setText(orphanageDetails.getDetailedOrphanageAddress());
            tv_state_of_orphanage.setText(String.valueOf(orphanageDetails.getPincode()));
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
