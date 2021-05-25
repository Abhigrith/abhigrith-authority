package com.example.abhigrith_authority.ui.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abhigrith_authority.R;
import com.example.abhigrith_authority.databinding.ListOrphanagePendingAuthRequestsBinding;
import com.example.abhigrith_authority.util.interfaces.OnOrphanageListItemClickListener;
import com.example.abhigrith_authority.models.OrphanageModel;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class OrphanageAuthRequestsListAdapter extends FirestoreRecyclerAdapter<OrphanageModel, OrphanageAuthRequestsListAdapter.OrphanageViewHolder> {

    private static final String TAG = "OrphanageAdapter";

    private FirestoreRecyclerOptions<OrphanageModel> options;
    private OnOrphanageListItemClickListener onOrphanageListItemClickListener;

    public OrphanageAuthRequestsListAdapter(OnOrphanageListItemClickListener onOrphanageListItemClickListener, @NonNull FirestoreRecyclerOptions<OrphanageModel> options) {
        super(options);
        this.onOrphanageListItemClickListener = onOrphanageListItemClickListener;
        this.options = options;
    }

    public class OrphanageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ListOrphanagePendingAuthRequestsBinding binding;

        public OrphanageViewHolder(@NonNull ListOrphanagePendingAuthRequestsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onOrphanageListItemClickListener.onItemClick(getItem(getAbsoluteAdapterPosition()));
        }

        public void bindOrphanageItem(OrphanageModel model) {
            Log.d(TAG, model.toString());
            binding.tvNameOfOrphanage.setText(itemView.getContext().getString(R.string.name_of_orphanage, model.getOrphanageName()));
            binding.tvCityOfOrphanage.setText(itemView.getContext().getString(R.string.city_of_orphanage, model.getOrphanageAddress().getCity()));
            binding.tvPincodeOfOrphanage.setText(itemView.getContext().getString(R.string.pincode_of_orphanage, model.getOrphanageAddress().getPincode()));
            binding.tvStateOfOrphanage.setText(itemView.getContext().getString(R.string.state_of_orphanage, model.getOrphanageAddress().getState()));
        }
    }

    @NonNull
    @Override
    public OrphanageAuthRequestsListAdapter.OrphanageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListOrphanagePendingAuthRequestsBinding binding = ListOrphanagePendingAuthRequestsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
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
