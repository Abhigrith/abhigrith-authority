package com.example.abhigrith_authority.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.abhigrith_authority.databinding.FragmentOrphanagePendingAuthRequestBinding;
import com.example.abhigrith_authority.util.enums.ParentListingStatus;
import com.example.abhigrith_authority.util.interfaces.OnOrphanageListItemClickListener;
import com.example.abhigrith_authority.ui.adapters.OrphanageAuthRequestsListAdapter;
import com.example.abhigrith_authority.models.OrphanageModel;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import org.jetbrains.annotations.NotNull;

public class OrphanagesPendingAuthRequestFragment extends Fragment implements OnOrphanageListItemClickListener {

    private static final String TAG = "OrphanageAuthList";
    private static final String ORPHANAGE_COLLECTION_PATH = "orphanage_info";
    private static final String ORPHANAGE_STATUS_FIELD = "orphanageListingStatus";

    private FirebaseFirestore firestore;
    private FirestoreRecyclerOptions<OrphanageModel> options;
    private OrphanageAuthRequestsListAdapter adapter;
    private FragmentOrphanagePendingAuthRequestBinding binding;

    public OrphanagesPendingAuthRequestFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentOrphanagePendingAuthRequestBinding.inflate(inflater,container,false);

        firestore = FirebaseFirestore.getInstance();

        Query query = firestore.collection(ORPHANAGE_COLLECTION_PATH).whereEqualTo(ORPHANAGE_STATUS_FIELD, ParentListingStatus.PENDING.getOrphangeListingStatus());
        Log.d(TAG, "This is " + query.toString());

        options = new FirestoreRecyclerOptions.Builder<OrphanageModel>()
                .setQuery(query, OrphanageModel.class)
                .build();

        Log.d(TAG, "These are some events " + options.toString());

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Setting up Adapter and RecyclerView
        setupOrphanageList();
    }

    @Override
    public void onStart() {
        super.onStart();
        if(adapter != null) {
            adapter.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (adapter != null) {
            adapter.stopListening();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        adapter = null;
    }

    private void setupOrphanageList(){
        this.adapter = new OrphanageAuthRequestsListAdapter(this,options);

        binding.rvFragmentOrphanagePendingAuthRequests.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rvFragmentOrphanagePendingAuthRequests.setAdapter(this.adapter);
    }

    @Override
    public void onItemClick(OrphanageModel model) {
        NavDirections action = OrphanagesPendingAuthRequestFragmentDirections.actionOrphanagesPendingAuthRequestFragmentToOrphanageFullDetailFragment(model);
        NavHostFragment.findNavController(this).navigate(action);
    }
}