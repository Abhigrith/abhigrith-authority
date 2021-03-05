package com.example.abhigrith_authority.tabs;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abhigrith_authority.R;
import com.example.abhigrith_authority.orphanage.activities.OrphanageFullDetailsActivity;
import com.example.abhigrith_authority.orphanage.activities.OrphanagePendingAuthRequestsActivity;
import com.example.abhigrith_authority.orphanage.adapters.OrphanageAuthRequestListAdapter;
import com.example.abhigrith_authority.orphanage.models.OrphanageDetails;
import com.example.abhigrith_authority.orphanage.models.WardenDetails;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment implements OrphanageAuthRequestListAdapter.OnOrphanageItemClickListener{

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OrphanageAuthRequestListAdapter adapter;
    private RecyclerView pendingOrphanageAuthList;
    private ArrayList<OrphanageDetails> data = new ArrayList<OrphanageDetails>();

    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pendingOrphanageAuthList = (RecyclerView) view.findViewById(R.id.rv_first_fragment_auth_list);

        addDummyData();

        initRecyclerView();
    }

    void initRecyclerView(){
        // TODO :: Adapter class can change so always check this
        this.adapter = new OrphanageAuthRequestListAdapter(getContext(),this,data);
        pendingOrphanageAuthList.setLayoutManager(new LinearLayoutManager(getContext()));
        pendingOrphanageAuthList.setAdapter(this.adapter);
    }

    // TODO :: This function is for showcase purpose and needs to be removed
    public void addDummyData(){
        WardenDetails wardenDetail1 = new WardenDetails("Anubhav","Pabby","MALE","20-07-2000",34,454545.56f,"CIUDCDINNDC3456","IOVJIORIOR567");
        OrphanageDetails orphanageDetail1 = new OrphanageDetails("Anubhav Anathalaya","Anubhav",wardenDetail1,"7R4974587FVJOFVKFVOJF87845","IHCEIHV7YR47UFU","THIS IS IN MUMBAI",401501,"BOISAR","PALGHAR","MAHARAHTRA",false);
        this.data.add(orphanageDetail1);
        WardenDetails wardenDetail2 = new WardenDetails("Avinash","Vijayvargiya","MALE","20-07-2000",34,454545.56f,"CIUDCDINNDC3456","IOVJIORIOR567");
        OrphanageDetails orphanageDetail2 = new OrphanageDetails("Avinash Anathalaya","Anubhav",wardenDetail2,"7R4974587FVJOFVKFVOJF87845","IHCEIHV7YR47UFU","THIS IS IN MUMBAI",401501,"BOISAR","PALGHAR","MAHARAHTRA",false);
        this.data.add(orphanageDetail2);
        WardenDetails wardenDetail3 = new WardenDetails("Ayush","Prasad","MALE","20-07-2000",34,454545.56f,"CIUDCDINNDC3456","IOVJIORIOR567");
        OrphanageDetails orphanageDetail3 = new OrphanageDetails("Ayush Anathalaya","Anubhav",wardenDetail3,"7R4974587FVJOFVKFVOJF87845","IHCEIHV7YR47UFU","THIS IS IN MUMBAI",401501,"BOISAR","PALGHAR","MAHARAHTRA",false);
        this.data.add(orphanageDetail3);
        WardenDetails wardenDetail4 = new WardenDetails("Aditya","Sood","MALE","20-07-2000",34,454545.56f,"CIUDCDINNDC3456","IOVJIORIOR567");
        OrphanageDetails orphanageDetail4 = new OrphanageDetails("Aditya Anathalaya","Anubhav",wardenDetail4,"7R4974587FVJOFVKFVOJF87845","IHCEIHV7YR47UFU","THIS IS IN MUMBAI",401501,"BOISAR","PALGHAR","MAHARAHTRA",false);
        this.data.add(orphanageDetail4);
        WardenDetails wardenDetail5 = new WardenDetails("Aryama","Dubey","FEMALE","20-07-2000",34,454545.56f,"CIUDCDINNDC3456","IOVJIORIOR567");
        OrphanageDetails orphanageDetail5 = new OrphanageDetails("Aryama Anathalaya","Anubhav",wardenDetail5,"7R4974587FVJOFVKFVOJF87845","IHCEIHV7YR47UFU","THIS IS IN MUMBAI",401501,"BOISAR","PALGHAR","MAHARAHTRA",false);
        this.data.add(orphanageDetail5);
    }

    // TODO :: Need to be changed OR REMOVED
    @Override
    public void onItemClick(int position) {
        Toast.makeText(getContext(),"This is " + (position + 1) + " position",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(), OrphanageFullDetailsActivity.class);
        startActivity(intent);
    }

    // TODO :: Need to be changed OR REMOVED
    @Override
    public void onItemsClick(OrphanageDetails orphanageDetails) {
        Toast.makeText(getContext(),"This is " + orphanageDetails.toString() + " position",Toast.LENGTH_SHORT).show();
        // Intent intent = new Intent(OrphanagePendingAuthRequestsActivity.this,OrphanageFullDetailsActivity.class);
        // startActivity(intent);
    }
}