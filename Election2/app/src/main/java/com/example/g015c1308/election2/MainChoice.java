package com.example.g015c1308.election2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainChoice extends AppCompatActivity implements LargeRegion.OnFragmentInteractionListener,KantoRegion.OnFragmentInteractionListener,TouhokuRegion.OnFragmentInteractionListener ,
                                                                KoushinetuHokurikuRegion.OnFragmentInteractionListener,ToukaiRegion.OnFragmentInteractionListener,
                                                                KansaiRegion.OnFragmentInteractionListener,TyugokuRegion.OnFragmentInteractionListener,
                                                                SikokuRegion.OnFragmentInteractionListener,KyusyuuRegion.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_choice);
        show();
    }
    //fragment作成表示関数
    private void show(){
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentByTag("LargeRegion");
        if(fragment == null){
            fragment = new LargeRegion();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.content,fragment,"LargeRegion");
            transaction.commit();
        }
    }

}
