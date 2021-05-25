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

import com.example.abhigrith_authority.databinding.FragmentParentPendingAuthRequestBinding;
import com.example.abhigrith_authority.models.ParentsDetailModel;
import com.example.abhigrith_authority.util.enums.ParentAdoptionRequestStatus;
import com.example.abhigrith_authority.util.interfaces.OnParentListItemClickListener;
import com.example.abhigrith_authority.ui.adapters.ParentAuthRequestListAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import org.jetbrains.annotations.NotNull;

public class ParentsPendingAuthRequestFragment extends Fragment implements OnParentListItemClickListener {

    private static final String TAG = "ParentAuthList";
    private static final String PARENT_COLLECTION_PATH = "parents_info";
    private static final String PARENT_STATUS_FIELD = "adoptionRequestStatus";

    private FragmentParentPendingAuthRequestBinding binding;
    private FirebaseFirestore firestore;
    private FirestoreRecyclerOptions<ParentsDetailModel> options;
    private ParentAuthRequestListAdapter adapter;

    public ParentsPendingAuthRequestFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentParentPendingAuthRequestBinding.inflate(inflater,container,false);

        firestore = FirebaseFirestore.getInstance();

        Query query = firestore.collection(PARENT_COLLECTION_PATH).whereEqualTo(PARENT_STATUS_FIELD, ParentAdoptionRequestStatus.PENDING.getAdoptionStatus());
        Log.d(TAG, "This is " + query.toString());

        options = new FirestoreRecyclerOptions.Builder<ParentsDetailModel>()
                .setQuery(query, ParentsDetailModel.class)
                .build();

        Log.d(TAG, "These are some events " + options.toString());

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Setting up Adapter and RecyclerView
        setupParentList();
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
        if(adapter != null) {
            adapter.startListening();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        adapter = null;
    }

    private void setupParentList(){
        this.adapter = new ParentAuthRequestListAdapter(this, options);

        binding.rvFragmentParentPendingAuthRequests.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext()));
        binding.rvFragmentParentPendingAuthRequests.setAdapter(this.adapter);
    }

    @Override
    public void onItemClick(ParentsDetailModel model) {
        NavDirections action = ParentsPendingAuthRequestFragmentDirections.actionParentsPendingAuthRequestFragmentToParentFullDetailFragment(model);
        NavHostFragment.findNavController(this).navigate(action);
    }
}