package com.example.g015c1308.election2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class HistoryList extends AppCompatActivity {
    private Realm mRealm;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_list);

        list = (ListView)findViewById(R.id.historyList);
        mRealm = Realm.getDefaultInstance();
        final ArrayList<String> arrayList = new ArrayList<>();

        RealmResults<HistoryModel> results = mRealm.where(HistoryModel.class).findAll();
        if(results != null){
            for (HistoryModel historyModel : results){
                arrayList.add(historyModel.getName());
            }
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        list.setAdapter(arrayAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = arrayList.get(position);
                NameModel nameModel = mRealm.where(NameModel.class).equalTo("name",name).findFirst();
                int nameId = nameModel.getId();
                Intent intent = new Intent(HistoryList.this,Member.class);
                intent.putExtra("NameId",nameId);
                startActivity(intent);
            }
        });
    }
}
