package com.example.abhigrith_authority.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.abhigrith_authority.databinding.FragmentOrphanageFullDetailBinding;
import com.example.abhigrith_authority.util.enums.ParentListingStatus;
import com.example.abhigrith_authority.models.OrphanageModel;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ListenerRegistration;

import org.jetbrains.annotations.NotNull;

public class OrphanageFullDetailFragment extends Fragment {

    private static final String TAG = "OrphanageFullDetail";

    private static final String ORPHANAGE_COLLECTION_PATH = "orphanage_info";
    private static final String ORPHANAGE_LISTING_STATUS = "orphanageListingStatus";

    private FragmentOrphanageFullDetailBinding binding;
    private FirebaseFirestore firestore;
    private DocumentReference orphanageDocRef;
    private ListenerRegistration orphanageListener;


    public OrphanageFullDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentOrphanageFullDetailBinding.inflate(inflater,container,false);
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        OrphanageFullDetailFragmentArgs arguments = OrphanageFullDetailFragmentArgs.fromBundle(getArguments());
        OrphanageModel orphanageModel = arguments.getOrphanage();

        setOrphanageData(orphanageModel);

        firestore = FirebaseFirestore.getInstance();
        orphanageDocRef = firestore.collection(ORPHANAGE_COLLECTION_PATH).document(orphanageModel.getOrphanageId());

        binding.ibOrphanageAccepted.setOnClickListener(v -> updateOrphanageListingStatus(orphanageModel, ParentListingStatus.ACCEPTED));

        binding.ibOrphanagePending.setOnClickListener(v -> updateOrphanageListingStatus(orphanageModel, ParentListingStatus.PENDING));

        binding.ibOrphanageRejected.setOnClickListener(v -> updateOrphanageListingStatus(orphanageModel, ParentListingStatus.REJECTED));
    }

    @Override
    public void onStart() {
        super.onStart();

         orphanageListener = orphanageDocRef.addSnapshotListener((value, error) -> {
             if (error != null) {
                 Snackbar.make(binding.getRoot(),"There is some error to load the latest updated data", Snackbar.LENGTH_LONG).show();
                 Log.d(TAG, error.toString());
                 return;
             }

             if (value != null && value.exists()) {
                 OrphanageModel orphanage = value.toObject(OrphanageModel.class);

                 if(orphanage != null) {
                     setOrphanageData(orphanage);
                 }
             }
         });
    }

    @Override
    public void onStop() {
        super.onStop();
        orphanageListener.remove();
    }

    private void updateOrphanageListingStatus(OrphanageModel orphanage, ParentListingStatus status){
        String orphanageListingStatus = status.getOrphangeListingStatus();

        // Update the "orphanageListingStatus" field of the orphanage_info document to either "Accepted" or "Rejected"
        orphanageDocRef
                .update(ORPHANAGE_LISTING_STATUS, orphanageListingStatus)
                .addOnSuccessListener(aVoid -> {
                    Log.d(TAG, "Orphanage DocumentSnapshot is updated successfully to the status : " + orphanageListingStatus);
                    Snackbar.make(binding.getRoot(),"The orphanage " +  orphanage.getOrphanageName() + " is updated to the " + orphanageListingStatus + " status", Snackbar.LENGTH_LONG).show();
                })
                .addOnFailureListener(e -> {
                    Log.w(TAG, "Error updating document to the status : " + orphanageListingStatus, e);
                    Snackbar.make(binding.getRoot(),"There was some error to update the orphanage " + orphanage.getOrphanageName() + " to the " + orphanageListingStatus + " status.Please contact the database department regarding the problem", Snackbar.LENGTH_LONG).show();
                });
    }

    private void setOrphanageData(OrphanageModel orphanage) {
        binding.tvOrphanageName.setText(orphanage.getOrphanageName());
        binding.tvOrphanageListingStatus.setText(orphanage.getOrphanageListingStatus());
        binding.tvOrphanageEmail.setText(orphanage.getOrphanageEmail());
        binding.tvOrphanagePrimaryPhone.setText(orphanage.getOrphanagePrimaryPhoneNumber());
        binding.tvOrphanageSecondaryPhone.setText(orphanage.getOrphanageSecondaryPhoneNumber());
        binding.tvOrphanagePrimaryAddress.setText(orphanage.getOrphanageAddress().getAddressOne());
        binding.tvOrphanageSecondaryAddress.setText(orphanage.getOrphanageAddress().getAddressTwo());
        binding.tvOrphanageCity.setText(orphanage.getOrphanageAddress().getCity());
        binding.tvOrphanageDistrict.setText(orphanage.getOrphanageAddress().getDistrict());
        binding.tvOrphanagePincode.setText(orphanage.getOrphanageAddress().getPincode());
        binding.tvOrphanageState.setText(orphanage.getOrphanageAddress().getState());
    }
}