package com.example.abhigrith_authority.parent.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.abhigrith_authority.R;
import com.example.abhigrith_authority.orphanage.models.OrphanageDetails;
import com.example.abhigrith_authority.parent.adapters.ParentAuthRequestListAdapter;
import com.example.abhigrith_authority.parent.models.IndividualParentDetails;
import com.example.abhigrith_authority.parent.models.ParentsDetails;

import java.util.ArrayList;

public class ParentPendingAuthRequestsActivity extends AppCompatActivity implements ParentAuthRequestListAdapter.OnParentItemClickListener {

    private RecyclerView pendingParentAuthList;
    private ParentAuthRequestListAdapter adapter;
    private ArrayList<ParentsDetails> data = new ArrayList<ParentsDetails>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);

        pendingParentAuthList = (RecyclerView) findViewById(R.id.rv_activity_parent_pending_requests);

        addDummyData();

        setupRecyclerView();

        Button btn_authority_parent_skip = (Button) findViewById(R.id.btn_authority_parent_skip);
        btn_authority_parent_skip.setOnClickListener(v -> {
            Intent intent = new Intent(this, ParentFullDetailsActivity.class);
            startActivity(intent);
        });
    }

    private void setupRecyclerView() {
        // TODO :: Adapter class can change so always check this
        adapter = new ParentAuthRequestListAdapter(this,this,data);
        pendingParentAuthList.setLayoutManager(new LinearLayoutManager(this));
        pendingParentAuthList.setAdapter(adapter);
    }

    private void addDummyData(){
        IndividualParentDetails individualParent1 = new IndividualParentDetails("Anubhav","Pabby","MALE","20-07-2000",34,45567.46f,"HVRIVHRIVHRUVHG","ONBORBGIORNBTIOB45");
        ParentsDetails parentsDetail1 = new ParentsDetails(true,individualParent1,null,"Mumbai is my home",401503,"BOISAR","PALGHAR","MAHARASHTRA",false);
        data.add(parentsDetail1);
        IndividualParentDetails individualParent2 = new IndividualParentDetails("Avinash","Vijayvargiya","MALE","20-07-2000",34,45567.46f,"HVRIVHRIVHRUVHG","ONBORBGIORNBTIOB45");
        ParentsDetails parentsDetail2 = new ParentsDetails(true,individualParent2,null,"Mumbai is my home",401503,"BOISAR","PALGHAR","MAHARASHTRA",false);
        data.add(parentsDetail2);
        IndividualParentDetails individualParent3 = new IndividualParentDetails("Ayush","Prasad","MALE","20-07-2000",34,45567.46f,"HVRIVHRIVHRUVHG","ONBORBGIORNBTIOB45");
        ParentsDetails parentsDetail3 = new ParentsDetails(true,individualParent3,null,"Mumbai is my home",401503,"BOISAR","PALGHAR","MAHARASHTRA",false);
        data.add(parentsDetail3);
        IndividualParentDetails individualParent4 = new IndividualParentDetails("Aditya","Sood","MALE","20-07-2000",34,45567.46f,"HVRIVHRIVHRUVHG","ONBORBGIORNBTIOB45");
        ParentsDetails parentsDetail4 = new ParentsDetails(true,individualParent4,null,"Mumbai is my home",401503,"BOISAR","PALGHAR","MAHARASHTRA",false);
        data.add(parentsDetail4);
        IndividualParentDetails individualParent5 = new IndividualParentDetails("Aryama","Dubey","FEMALE","20-07-2000",34,45567.46f,"HVRIVHRIVHRUVHG","ONBORBGIORNBTIOB45");
        ParentsDetails parentsDetail5 = new ParentsDetails(true,individualParent5,null,"Mumbai is my home",401503,"BOISAR","PALGHAR","MAHARASHTRA",false);
        data.add(parentsDetail5);
    }

    // TODO :: Need to be changed
    @Override
    public void onItemClick(int position) {
        Toast.makeText(this,"This is " + position + " position",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ParentPendingAuthRequestsActivity.this,ParentFullDetailsActivity.class);
        startActivity(intent);
    }

    // TODO :: Need to be changed
    @Override
    public void onItemsClick(ParentsDetails parentsDetails) {
        Toast.makeText(this,"This is " + parentsDetails.toString() + " position",Toast.LENGTH_SHORT).show();
        // Intent intent = new Intent(ParentPendingAuthRequestsActivity.this,ParentFullDetailsActivity.class);
        // startActivity(intent);
    }
}