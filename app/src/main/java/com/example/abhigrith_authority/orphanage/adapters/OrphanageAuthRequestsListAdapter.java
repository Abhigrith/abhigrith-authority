package com.example.abhigrith_authority.orphanage.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abhigrith_authority.databinding.ListOrphanagePendingAuthRequestsBinding;
import com.example.abhigrith_authority.orphanage.models.OrphanageModel;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class OrphanageAuthRequestsListAdapter extends FirestoreRecyclerAdapter<OrphanageModel, OrphanageAuthRequestsListAdapter.OrphanageViewHolder> {

    private static final String TAG = "OrphanageAdapter";

    private FirestoreRecyclerOptions<OrphanageModel> options;
    // private OnListItemClickListener onListItemClickListener;
    // private OnDocumentCheckListener onDocumentCheckListener;

    public OrphanageAuthRequestsListAdapter(@NonNull FirestoreRecyclerOptions<OrphanageModel> options) {
        super(options);
        // this.onListItemClickListener = onListItemClickListener;
        // this.onDocumentCheckListener = onDocumentCheckListener;
        this.options = options;
    }

    public static class OrphanageViewHolder extends RecyclerView.ViewHolder {
        private ListOrphanagePendingAuthRequestsBinding binding;

        public OrphanageViewHolder(@NonNull ListOrphanagePendingAuthRequestsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindOrphanageItem(OrphanageModel model) {
            Log.d(TAG, model.toString());
            binding.tvNameOfOrphanage.setText(model.getOrphanageName());
            binding.tvCityOfOrphanage.setText(model.getOrphanageAddress().getCity());
            binding.tvStateOfOrphanage.setText(model.getOrphanageAddress().getState());
        }
    }

    @NonNull
    @Override
    public OrphanageAuthRequestsListAdapter.OrphanageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListOrphanagePendingAuthRequestsBinding binding = ListOrphanagePendingAuthRequestsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new OrphanageViewHolder(binding);
    }

    @Override
    protected void onBindViewHolder(@NonNull OrphanageViewHolder holder, int position, @NonNull OrphanageModel model) {
        holder.bindOrphanageItem(model);
    }

    @Override
    public int getItemCount() {
        return this.options.getSnapshots().size();
    }
}
