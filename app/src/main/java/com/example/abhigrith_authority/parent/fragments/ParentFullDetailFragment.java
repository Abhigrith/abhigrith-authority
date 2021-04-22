package com.example.abhigrith_authority.parent.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.abhigrith_authority.R;
import com.example.abhigrith_authority.databinding.FragmentParentFullDetailBinding;
import com.example.abhigrith_authority.enums.ParentListingStatus;
import com.example.abhigrith_authority.parent.models.ParentsDetailModel;
import com.example.abhigrith_authority.tabs.ParentsPendingAuthRequestFragmentArgs;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ListenerRegistration;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ParentFullDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ParentFullDetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String TAG = "ParentFullDetail";

    private static final String PARENT_COLLECTION_PATH = "parents_info";
    private static final String PARENT_FIRST_INCOME = "firstParent.income";
    private static final String PARENT_FIRST_GENDER = "firstParent.gender";
    private static final String PARENT_SECOND_INCOME = "secondParent.income";
    private static final String PARENT_SECOND_GENDER = "secondParent.gender";
    private static final String PARENT_PRIMARY_PHONE = "primaryContactNumber";
    private static final String PARENT_SECONDARY_PHONE = "secondaryContactNumber";
    private static final String PARENT_PRIMARY_ADDRESS = "address.primaryAddress";
    private static final String PARENT_SECONDARY_ADDRESS = "address.secondaryAddress";
    private static final String PARENT_CITY = "address.city";
    private static final String PARENT_DISTRICT = "address.district";
    private static final String PARENT_PINCODE = "address.pincode";
    private static final String PARENT_STATE = "address.state";
    private static final String PARENT_LISTING_STATUS = "adoptionRequestStatus";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentParentFullDetailBinding binding;
    private FirebaseFirestore firestore;
    private DocumentReference parentDocRef;
    private ListenerRegistration parentListener;

    public ParentFullDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ParentFullDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ParentFullDetailFragment newInstance(String param1, String param2) {
        ParentFullDetailFragment fragment = new ParentFullDetailFragment();
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
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        binding = FragmentParentFullDetailBinding.inflate(inflater,container,false);
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ParentsPendingAuthRequestFragmentArgs args = ParentsPendingAuthRequestFragmentArgs.fromBundle(getArguments());
        ParentsDetailModel parentModel = args.getParent();

        setParentData(parentModel);

        firestore = FirebaseFirestore.getInstance();
        parentDocRef = firestore.collection(PARENT_COLLECTION_PATH).document(parentModel.getEmailAddress());

        firestore = FirebaseFirestore.getInstance();
        parentDocRef = firestore.collection(PARENT_COLLECTION_PATH).document(parentModel.getEmailAddress());

        binding.ibParentAccepted.setOnClickListener(v -> updateParentAdoptionStatus(parentModel, ParentListingStatus.ACCEPTED));

        binding.ibParentPending.setOnClickListener(v -> updateParentAdoptionStatus(parentModel, ParentListingStatus.PENDING));

        binding.ibParentRejected.setOnClickListener(v -> updateParentAdoptionStatus(parentModel, ParentListingStatus.REJECTED));
    }

    @Override
    public void onStart() {
        super.onStart();

        parentListener = parentDocRef.addSnapshotListener((value, error) -> {
            if (error != null) {
                Snackbar.make(binding.getRoot(),"There is some error to load the latest updated data", Snackbar.LENGTH_LONG).show();
                Log.d(TAG, error.toString());
                return;
            }

            if (value != null && value.exists()) {
                ParentsDetailModel parent = value.toObject(ParentsDetailModel.class);

                if(parent != null){
                    setParentData(parent);
                }
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        parentListener.remove();
    }

    private void updateParentAdoptionStatus(ParentsDetailModel parent, ParentListingStatus status){
        String adoptionRequestStatus = status.getOrphangeListingStatus();

        // Update the "adoptionRequestStatus" field of the parents_info document to either "Accepted" or "Rejected"
        parentDocRef
                .update(PARENT_LISTING_STATUS, adoptionRequestStatus)
                .addOnSuccessListener(aVoid -> {
                    Log.d(TAG, "Parent DocumentSnapshot field adoptionRequestStatus is successfully updated to the status : " + adoptionRequestStatus);
                    Snackbar.make(binding.getRoot(),"The parents " +  parent.getFirstParent().getFullName() + " and " + parent.getSecondParent().getFullName() + " status has been updated to the " + adoptionRequestStatus, Snackbar.LENGTH_LONG).show();
                })
                .addOnFailureListener(e -> {
                    Log.w(TAG, "Error updating document field adoptionRequestStatus to the status : " + adoptionRequestStatus, e);
                    Snackbar.make(binding.getRoot(),"There was some error to update the parents " +  parent.getFirstParent().getFullName() + " and " + parent.getSecondParent().getFullName() + " to the " + adoptionRequestStatus + " status.Please contact the database department regarding the problem", Snackbar.LENGTH_LONG).show();
                });
    }

    private void setParentData(ParentsDetailModel parentModel) {
        binding.tvParentsAdoptionStatus.setText(parentModel.getAdoptionRequestStatus());
        binding.tvParentsEmail.setText(parentModel.getEmailAddress());

        binding.tvParentsName.setText(getString(R.string.name_of_parents,parentModel.getFirstParent().getFullName(),parentModel.getSecondParent().getFullName()));

        binding.tvParentFirstGender.setText(String.valueOf(parentModel.getFirstParent().getGender()));
        binding.tvParentSecondGender.setText(String.valueOf(parentModel.getSecondParent().getGender()));

        binding.tvParentFirstIncome.setText(String.valueOf(parentModel.getFirstParent().getIncome()));
        binding.tvParentSecondIncome.setText(String.valueOf(parentModel.getSecondParent().getIncome()));

        binding.tvParentFirstAadhaar.setText(String.valueOf(parentModel.getFirstParent().getAadhaarCardNumber()));
        binding.tvParentSecondAadhaar.setText(String.valueOf(parentModel.getSecondParent().getAadhaarCardNumber()));

        binding.tvParentFirstPan.setText(String.valueOf(parentModel.getFirstParent().getPanCardNumber()));
        binding.tvParentSecondPan.setText(String.valueOf(parentModel.getSecondParent().getPanCardNumber()));

        binding.tvParentsPrimaryPhone.setText(parentModel.getPrimaryContactNumber());
        binding.tvParentsSecondaryPhone.setText(parentModel.getSecondaryContactNumber());

        binding.tvParentsPrimaryAddress.setText(parentModel.getAddress().getPrimaryAddress());
        binding.tvParentsSecondaryAddress.setText(parentModel.getAddress().getSecondaryAddress());

        binding.tvParentsCity.setText(parentModel.getAddress().getCity());
        binding.tvParentsDistrict.setText(parentModel.getAddress().getDistrict());
        binding.tvParentsPincode.setText(parentModel.getAddress().getPincode());
        binding.tvParentsState.setText(parentModel.getAddress().getState());
    }
}