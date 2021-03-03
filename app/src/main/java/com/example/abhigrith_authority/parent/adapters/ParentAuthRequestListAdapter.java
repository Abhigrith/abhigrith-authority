package com.example.abhigrith_authority.parent.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abhigrith_authority.R;
import com.example.abhigrith_authority.parent.models.IndividualParentDetails;
import com.example.abhigrith_authority.parent.models.ParentsDetails;

import java.util.ArrayList;

public class ParentAuthRequestListAdapter extends RecyclerView.Adapter<ParentAuthRequestListAdapter.ParentViewHolder> {
    private Context context;
    private OnParentItemClickListener onParentItemClickListener;
    private ArrayList<ParentsDetails> pendingParentAuthLists;

    public ParentAuthRequestListAdapter(Context context, OnParentItemClickListener onParentItemClickListener, ArrayList<ParentsDetails> pendingParentAuthLists){
        this.context = context;
        this.onParentItemClickListener = onParentItemClickListener;
        this.pendingParentAuthLists = pendingParentAuthLists;
    }

    public static class ParentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        public TextView age;
        public TextView address;
        OnParentItemClickListener onParentItemClickListener;

        public ParentViewHolder(@NonNull View itemView,OnParentItemClickListener onParentItemClickListener) {
            super(itemView);
            this.name = itemView.findViewById(R.id.tv_parent_pending_auth_requests_name);
            this.address = itemView.findViewById(R.id.tv_parent_pending_auth_requests_address);
            this.age = itemView.findViewById(R.id.tv_parent_pending_auth_requests_age);
            this.onParentItemClickListener = onParentItemClickListener;

            itemView.setOnClickListener(this);
        }

        // TODO :: Will write logic to bind views here
        void bindData(ParentsDetails parentsDetails){
            IndividualParentDetails parent = parentsDetails.getFirstParent();
            name.setText(parent.getFirstNameOfParent());
            address.setText(parentsDetails.getDetailedHomeAddress());
            age.setText(String.valueOf(parent.getAgeOfParent()));
        }

        @Override
        public void onClick(View v) {
            // TODO :: This will be implemented afterwards
            Log.d("Adapter Position", "onClick: " + getAdapterPosition());
            onParentItemClickListener.onItemClick(getAdapterPosition());
            // onParentItemClickListener.onItemsClick();
        }
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_parents_pending_auth_requests,parent,false);
        return new ParentViewHolder(view,this.onParentItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, int position) {
        holder.bindData(pendingParentAuthLists.get(position));
    }

    @Override
    public int getItemCount() {
        return pendingParentAuthLists.size();
    }

    public interface OnParentItemClickListener {
        // TODO :: Only 1 will be implemnted of either of the two
        void onItemClick(int position);
        void onItemsClick(ParentsDetails parentsDetails);
    }
}
