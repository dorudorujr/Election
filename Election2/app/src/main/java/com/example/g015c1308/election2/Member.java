package com.example.g015c1308.election2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.sackcentury.shinebuttonlib.ShineButton;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class Member extends AppCompatActivity {
    private static final int ERR_CD = -1;
    private Realm mRealm;
    int nameId;
    String nameMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        mRealm = Realm.getDefaultInstance();
        Intent intent = getIntent();
        nameId = intent.getIntExtra("NameId",-1);
        final NameModel nameModel = mRealm.where(NameModel.class).equalTo("id",nameId).findFirst();
        final String nameIdString = String.valueOf(nameId);
        nameMember = nameModel.getName();
        final String urlMember = nameModel.getUrl();

        TextView name = (TextView)findViewById(R.id.membername);
        TextView url = (TextView)findViewById(R.id.memberurl);
        TextView manifesto1 = (TextView)findViewById(R.id.manifesto1);
        TextView manifesto2 = (TextView)findViewById(R.id.manifesto2);
        TextView manifesto3 = (TextView)findViewById(R.id.manifesto3);
        TextView manifesto4 = (TextView)findViewById(R.id.manifesto4);
        final ShineButton shineButton = (ShineButton) findViewById(R.id.shine_button);
        //表示処理
        if(nameId != -1){
            name.setText(nameMember);
            url.setText(urlMember);
            RealmResults<ManifestoModel> results = mRealm.where(ManifestoModel.class).equalTo("nameid",nameIdString).findAll();
            ArrayList<String> manifestoList = new ArrayList<>();
            for(ManifestoModel manifestoModel : results){
                manifestoList.add(manifestoModel.getManifesto());
            }
            manifesto1.setText(manifestoList.get(0));
            manifesto2.setText(manifestoList.get(1));
            manifesto3.setText(manifestoList.get(2));
            manifesto4.setText(manifestoList.get(3));
        }
        //お気に入り機能
        final FavoriteModel favoriteModelflag = mRealm.where(FavoriteModel.class).equalTo("favoriteNameId",nameId).findFirst();
        if(favoriteModelflag != null){
            shineButton.setChecked(favoriteModelflag.isCheck());
        }
        shineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FavoriteModel favoriteModel = mRealm.where(FavoriteModel.class).equalTo("favoriteNameId",nameId).findFirst();
                if(shineButton.isChecked() == true){
                    mRealm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            FavoriteModel favoriteModel = realm.createObject(FavoriteModel.class,new Integer(nameId));
                            favoriteModel.setFavoritename(nameModel.getName());
                            favoriteModel.setFavoriteetc(nameModel.getEtc());
                            favoriteModel.setFavoriteflag(nameModel.isFlag());
                            favoriteModel.setCheck(true);
                        }
                    });
                }else{
                    mRealm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            if(favoriteModel != null){
                                favoriteModel.deleteFromRealm();
                            }
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        History();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mRealm.close();
    }

    public void onMemoButtonTapped(View view){
        Intent intent = new Intent(this,Memo.class);
        intent.putExtra("id",nameId);
        startActivity(intent);
    }

    //履歴登録処理
    public void History(){
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<HistoryModel> realmResults = realm.where(HistoryModel.class).findAll();
                Number maxId = realm.where(HistoryModel.class).max("id");
                int nextId = 0;
                if(maxId != null){nextId = maxId.intValue() + 1;}
                HistoryModel historyModel = realm.createObject(HistoryModel.class,new Integer(nextId));
                historyModel.setName(nameMember);
                historyModel.setNameIdHistory(nameId);
            }
        });
    }

}
