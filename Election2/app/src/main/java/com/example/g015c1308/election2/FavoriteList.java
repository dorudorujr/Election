package com.example.g015c1308.election2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import io.realm.Realm;
import io.realm.RealmResults;

public class FavoriteList extends AppCompatActivity {
    private Realm mRealm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_list);

        mRealm = Realm.getDefaultInstance();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.favoriteRecyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        RealmResults<FavoriteModel> favoriteModels = mRealm.where(FavoriteModel.class).findAll();
        FavoriteAdapter adapter = new FavoriteAdapter(this,favoriteModels,true);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        mRealm.close();
    }
}
