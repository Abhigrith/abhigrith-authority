package com.example.abhigrith_authority.tabs;

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
import com.example.abhigrith_authority.enums.ParentListingStatus;
import com.example.abhigrith_authority.interfaces.OnOrphanageListItemClickListener;
import com.example.abhigrith_authority.orphanage.adapters.OrphanageAuthRequestsListAdapter;
import com.example.abhigrith_authority.orphanage.models.OrphanageModel;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrphanagesPendingAuthRequestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrphanagesPendingAuthRequestFragment extends Fragment implements OnOrphanageListItemClickListener {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String TAG = "OrphanageAuthList";
    private static final String ORPHANAGE_COLLECTION_PATH = "orphanage_info";
    private static final String ORPHANAGE_STATUS_FIELD = "orphanageListingStatus";

    private String mParam1;
    private String mParam2;

    private FirebaseFirestore firestore;
    private FirestoreRecyclerOptions<OrphanageModel> options;
    private OrphanageAuthRequestsListAdapter adapter;
    private FragmentOrphanagePendingAuthRequestBinding binding;

    public OrphanagesPendingAuthRequestFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrphanagesPendingAuthRequestFragment.
     */
    public static OrphanagesPendingAuthRequestFragment newInstance(String param1, String param2) {
        OrphanagesPendingAuthRequestFragment fragment = new OrphanagesPendingAuthRequestFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
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