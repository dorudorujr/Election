package com.example.g015c1308.election2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class List extends AppCompatActivity {
    private Realm mRealm;
    ListView list;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }


    @Override
    public void onResume(){
        super.onResume();
        Set();
    }



    public void Set(){
        list = (ListView)findViewById(R.id.listView);
        mRealm = Realm.getDefaultInstance();
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        ArrayList<String> arrayList = new ArrayList<>();
        if(name != null){
            RealmResults<RegionModel> results = mRealm.where(RegionModel.class).equalTo("large_region",name).findAll();
            int resultCount = results.size();
            for (int i = 0; i < resultCount; i++){
                arrayList.add(name + (i + 1) + "地区");
            }
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        list.setAdapter(arrayAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 21){
                    Intent intent = new Intent(List.this,ListMember.class);
                    intent.putExtra("searchLargeRegion",name);
                    intent.putExtra("searchSmallRegion",position);
                    startActivity(intent);
                }else {
                    Alert();
                }

            }
        });
    }

    public void Alert(){
        new AlertDialog.Builder(this)
                .setTitle("注意")
                .setMessage("Prototypeのためここから先の機能は実装していません。22地区を選択してください。")
                .setPositiveButton("OK", null)
                .show();
    }
}
