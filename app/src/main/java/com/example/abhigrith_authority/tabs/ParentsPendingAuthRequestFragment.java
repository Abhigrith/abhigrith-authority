package com.example.abhigrith_authority.tabs;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.abhigrith_authority.databinding.FragmentParentPendingAuthRequestBinding;
import com.example.abhigrith_authority.enums.OrphanageListingStatus;
import com.example.abhigrith_authority.enums.ParentAdoptionRequestStatus;
import com.example.abhigrith_authority.parent.adapters.ParentAuthRequestListAdapter;
import com.example.abhigrith_authority.parent.models.ParentsDetailModel;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ParentsPendingAuthRequestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ParentsPendingAuthRequestFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String TAG = "ParentAuthList";
    private static final String PARENT_COLLECTION_PATH = "parents_info";
    private static final String PARENT_STATUS_FIELD = "adoptionRequestStatus";
    // private static final String PARENT_DOCUMENT_NAME = "ORPHANAGE_DOCUMENT_NAME";
    // private static final String ORPHANAGE_NAME_FIELD = "orphanageName";

    private FragmentParentPendingAuthRequestBinding binding;
    private FirebaseFirestore firestore;
    private FirestoreRecyclerOptions<ParentsDetailModel> options;
    private ParentAuthRequestListAdapter adapter;

    private String mParam1;
    private String mParam2;

    public ParentsPendingAuthRequestFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ParentsPendingAuthRequestFragment.
     */
    public static ParentsPendingAuthRequestFragment newInstance(String param1, String param2) {
        ParentsPendingAuthRequestFragment fragment = new ParentsPendingAuthRequestFragment();
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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Setting up Adapter
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
        // TODO :: Adapter class can change so always check this
        this.adapter = new ParentAuthRequestListAdapter(options);

        binding.rvFragmentParentPendingAuthRequests.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rvFragmentParentPendingAuthRequests.setAdapter(this.adapter);
    }
}