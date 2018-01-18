package com.example.g015c1308.election2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import io.realm.Realm;
import io.realm.RealmResults;

public class ListMember extends AppCompatActivity {
    private Realm mRealm;
    String searchSmallRegion;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_member);

        mRealm = Realm.getDefaultInstance();

        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

    }
    @Override
    public void onResume(){
        super.onResume();
        Set();
    }

    public void Set(){
        Intent intent = getIntent();
        int position = intent.getIntExtra("searchSmallRegion",-1) + 1;
        if(position != -1){
            searchSmallRegion = String.valueOf(position);
            RegionModel regionModel = mRealm.where(RegionModel.class).equalTo("small_region",searchSmallRegion).findFirst();
            final int regionIdInt = regionModel.getId();
            final String regionId = String.valueOf(regionIdInt);
            RealmResults<NameModel> nameModels = mRealm.where(NameModel.class).equalTo("regionid",regionId).findAll();
            RegionRealmAdapter adapter = new RegionRealmAdapter(this,nameModels,true);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mRealm.close();
    }
}
