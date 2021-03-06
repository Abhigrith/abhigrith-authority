package com.example.abhigrith_authority.orphanage.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abhigrith_authority.R;
import com.example.abhigrith_authority.orphanage.adapters.OrphanageAuthRequestListAdapter;
import com.example.abhigrith_authority.orphanage.models.OrphanageDetails;
import com.example.abhigrith_authority.orphanage.models.WardenDetails;

import java.util.ArrayList;

public class OrphanagePendingAuthRequestsActivity extends AppCompatActivity implements OrphanageAuthRequestListAdapter.OnOrphanageItemClickListener {

    private OrphanageAuthRequestListAdapter adapter;
    private final ArrayList<OrphanageDetails> data = new ArrayList<OrphanageDetails>();
    private RecyclerView rv_activity_orphanage_pending_requests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orphanage);

        rv_activity_orphanage_pending_requests = findViewById(R.id.rv_activity_orphanage_pending_requests);

        addDummyData();

        initRecyclerView();

        Button btn_authority_warden_skip = findViewById(R.id.btn_activity_orphanage_skip);
        btn_authority_warden_skip.setOnClickListener(v -> {
            Intent intent = new Intent(this, OrphanageFullDetailsActivity.class);
            startActivity(intent);
        });
    }

    void initRecyclerView() {
        // TODO :: Adapter class can change so always check this
        this.adapter = new OrphanageAuthRequestListAdapter(this, this, data);
        rv_activity_orphanage_pending_requests.setLayoutManager(new LinearLayoutManager(this));
        rv_activity_orphanage_pending_requests.setAdapter(this.adapter);
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
        OrphanageDetails orphanageDetail5 = new OrphanageDetails("Aditya Anathalaya","Anubhav",wardenDetail5,"7R4974587FVJOFVKFVOJF87845","IHCEIHV7YR47UFU","THIS IS IN MUMBAI",401501,"BOISAR","PALGHAR","MAHARAHTRA",false);
        this.data.add(orphanageDetail4);
    }

    // TODO :: Need to be changed OR REMOVED
    @Override
    public void onItemClick(int position) {
        Toast.makeText(this,"This is " + position + " position",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(OrphanagePendingAuthRequestsActivity.this,OrphanageFullDetailsActivity.class);
        startActivity(intent);
    }

    // TODO :: Need to be changed OR REMOVED
    @Override
    public void onItemsClick(OrphanageDetails orphanageDetails) {
        Toast.makeText(this,"This is " + orphanageDetails.toString() + " position",Toast.LENGTH_SHORT).show();
        // Intent intent = new Intent(OrphanagePendingAuthRequestsActivity.this,OrphanageFullDetailsActivity.class);
        // startActivity(intent);
    }
}