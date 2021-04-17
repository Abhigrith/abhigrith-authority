package com.example.abhigrith_authority.parent.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abhigrith_authority.R;
import com.example.abhigrith_authority.databinding.ListParentPendingAuthRequestsBinding;
import com.example.abhigrith_authority.parent.models.ParentsDetailModel;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class ParentAuthRequestListAdapter extends FirestoreRecyclerAdapter<ParentsDetailModel, ParentAuthRequestListAdapter.ParentViewHolder> {

    private static final String TAG = "ParentAdapter";

    private FirestoreRecyclerOptions<ParentsDetailModel> options;

    public ParentAuthRequestListAdapter(@NonNull FirestoreRecyclerOptions<ParentsDetailModel> options) {
        super(options);
        this.options = options;
    }

    public static class ParentViewHolder extends RecyclerView.ViewHolder {
        private ListParentPendingAuthRequestsBinding binding;

        public ParentViewHolder(@NonNull ListParentPendingAuthRequestsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindOrphanageItem(ParentsDetailModel model) {
            Log.d(TAG, model.toString());
            binding.tvParentPendingAuthRequestsName.setText(binding.getRoot().getContext().getString(R.string.name_of_parents,model.getFirstParent().getFullName(),model.getSecondParent().getFullName()));
            binding.tvParentPendingAuthRequestsDob.setText(binding.getRoot().getContext().getString(R.string.dob_of_parents,model.getFirstParent().getDateOfBirth(),model.getSecondParent().getDateOfBirth()));
            binding.tvParentPendingAuthRequestsCity.setText(binding.getRoot().getContext().getString(R.string.city_of_parents,model.getAddress().getCity()));
            binding.tvParentPendingAuthRequestsDistrict.setText(binding.getRoot().getContext().getString(R.string.district_of_parents,model.getAddress().getDistrict()));
            binding.tvParentPendingAuthRequestsPincode.setText(binding.getRoot().getContext().getString(R.string.pincode_of_parents,model.getAddress().getPincode()));
            binding.tvParentPendingAuthRequestsState.setText(binding.getRoot().getContext().getString(R.string.state_of_parents,model.getAddress().getState()));
        }
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListParentPendingAuthRequestsBinding binding = ListParentPendingAuthRequestsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ParentViewHolder(binding);
    }

    @Override
    protected void onBindViewHolder(@NonNull ParentViewHolder holder, int position, @NonNull ParentsDetailModel model) {
        holder.bindOrphanageItem(model);
    }

    @Override
    public int getItemCount() {
        return this.options.getSnapshots().size();
    }
}
