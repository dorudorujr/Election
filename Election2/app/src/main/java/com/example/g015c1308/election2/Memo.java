package com.example.g015c1308.election2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import io.realm.Realm;

import static com.example.g015c1308.election2.R.id.etc;

public class Memo extends AppCompatActivity {
    private Realm mRealm;
    EditText mExpectation;
    EditText mEtc;
    EditText mImpression;
    int mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        mRealm = Realm.getDefaultInstance();
        mExpectation = (EditText)findViewById(R.id.expectation);
        mEtc = (EditText)findViewById(etc);
        mImpression = (EditText)findViewById(R.id.impression);
        Intent intent = getIntent();
        mId = intent.getIntExtra("id",-1);

        if(mId != -1){
            MemoModel memoModel = mRealm.where(MemoModel.class).equalTo("id",mId).findFirst();
            if(memoModel != null){
                mExpectation.setText(memoModel.getExpectation());
                mEtc.setText(memoModel.getEtc());
                mImpression.setText(memoModel.getImpression());
            }else {
                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.createObject(MemoModel.class,new Integer(mId));
                    }
                });
            }
        }
    }

    public void onSaveUpdateTapped(View view){
        final String impression = mImpression.getText().toString();
        final String expectation = mExpectation.getText().toString();
        final String etc = mEtc.getText().toString();

        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                MemoModel memoModel = realm.where(MemoModel.class).equalTo("id",mId).findFirst();
                memoModel.setImpression(impression);
                memoModel.setExpectation(expectation);
                memoModel.setEtc(etc);
            }
        });
        finish();
    }
}
