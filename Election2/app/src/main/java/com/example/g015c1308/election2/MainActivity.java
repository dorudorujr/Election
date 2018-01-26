package com.example.g015c1308.election2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Realm mRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // DrawerToggle
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // NavigationView Listener
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        mRealm = Realm.getDefaultInstance();

        //API関連（始まり）
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://153.126.179.26:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NameService service = retrofit.create(NameService.class);

        Call<Example> call = service.getExample();
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Response<Example> response) {
                Example example = response.body();
                Results results = example.getResults();
                List<Datum> listData = results.getData();
                List<Name> listName = results.getName();
                List<Manifesto> listManifesto = results.getManifesto();
                for(final Datum datum : listData){
                    mRealm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            RegionModel regionModel = realm.where(RegionModel.class).equalTo("id",datum.getId()).findFirst();
                            if(regionModel == null){
                                regionModel = realm.createObject(RegionModel.class, new Integer(datum.getId()));
                                regionModel.setLarge_region(datum.getLargeregion());
                                regionModel.setSmall_region(datum.getSmallregion());
                                regionModel.setCreated_at(datum.getCreatedAt());
                                regionModel.setUpdated_at(datum.getUpdatedAt());
                            }else {
                                regionModel.setLarge_region(datum.getLargeregion());
                                regionModel.setSmall_region(datum.getSmallregion());
                                regionModel.setCreated_at(datum.getCreatedAt());
                                regionModel.setUpdated_at(datum.getUpdatedAt());
                            }
                        }
                    });
                }
                for(final Name name : listName){
                    mRealm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            NameModel nameModel = realm.where(NameModel.class).equalTo("id",name.getId()).findFirst();
                            if(nameModel == null){
                                nameModel = realm.createObject(NameModel.class,new Integer(name.getId()));
                                nameModel.setName(name.getName());
                                nameModel.setRegionid(name.getRegionid());
                                nameModel.setUrl(name.getUrl());
                                nameModel.setFlag(name.getFlag());
                                nameModel.setPass(name.getPass());
                                nameModel.setEtc(name.getEtc());
                            }else{
                                nameModel.setName(name.getName());
                                nameModel.setRegionid(name.getRegionid());
                                nameModel.setUrl(name.getUrl());
                                nameModel.setFlag(name.getFlag());
                                nameModel.setPass(name.getPass());
                                nameModel.setEtc(name.getEtc());
                            }
                        }
                    });
                }
                for(final Manifesto manifesto : listManifesto){
                    mRealm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            ManifestoModel manifestoModel = realm.where(ManifestoModel.class).equalTo("id",manifesto.getId()).findFirst();
                            if(manifestoModel == null){
                                manifestoModel = realm.createObject(ManifestoModel.class,new Integer(manifesto.getId()));
                                manifestoModel.setNameid(manifesto.getNameid());
                                manifestoModel.setManifesto(manifesto.getManifesto());
                            }else{
                                manifestoModel.setNameid(manifesto.getNameid());
                                manifestoModel.setManifesto(manifesto.getManifesto());
                            }
                        }
                    });
                }
            }
            @Override
            public void onFailure(Throwable t) {
                Log.d("AAA","Failed to request");
            }
        });//(終わり)
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mRealm.close();
    }

    //ハンバーガメニュー
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        FavoriteModel favoriteModel = mRealm.where(FavoriteModel.class).findFirst();
        if(favoriteModel != null){
            int nameid = favoriteModel.getFavoriteNameId();
        }
        switch(item.getItemId()){
            case R.id.menu_item1:
                Intent intent = new Intent(this,FavoriteList.class);
                startActivity(intent);
                break;
            case R.id.menu_item2:
                Intent intent2 = new Intent(this,HistoryList.class);
                startActivity(intent2);
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    //「探すボタン」押下
    public void onSearchButtonTapped(View view){
        Intent intent = new Intent(this,MainChoice.class);
        startActivity(intent);
    }
}
