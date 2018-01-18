package com.example.g015c1308.election2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class KantoRegion extends Fragment {;
    private OnFragmentInteractionListener mListener;

    public KantoRegion() {}


    public static KantoRegion newInstance() {
        KantoRegion fragment = new KantoRegion();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_kanto_region,container,false);
        Button TokyoButton = (Button)v.findViewById(R.id.tokyo);
        Button KanagawaButton = (Button)v.findViewById(R.id.kanagawa);
        Button TibaButton = (Button)v.findViewById(R.id.tiba);
        Button GunmaButton = (Button)v.findViewById(R.id.gunma);
        Button SaitamaButton = (Button)v.findViewById(R.id.saitama);
        Button IbarakiButton = (Button)v.findViewById(R.id.ibaraki);
        Button TotigiButton = (Button)v.findViewById(R.id.totigi);
        TokyoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTokyo();
            }
        });

        KanagawaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onKanagawa();
            }
        });

        TibaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onChiba();
            }
        });

        GunmaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onGunma();
            }
        });

        SaitamaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSaitama();
            }
        });

        IbarakiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onIbaraki();
            }
        });

        TotigiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTochigi();
            }
        });
        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void onTokyo(){
        Intent intent = new Intent(getActivity(),List.class);
        intent.putExtra("name","東京");
        startActivity(intent);
    }

    public void onKanagawa(){
        Alert();
        /*Intent intent = new Intent(getActivity(),List.class);
        intent.putExtra("name","神奈川");
        startActivity(intent);*/
    }

    public void onChiba(){
        Alert();
        /*Intent intent = new Intent(getActivity(),List.class);
        intent.putExtra("name","千葉");
        startActivity(intent);*/
    }

    public void onGunma(){
        Alert();
        /*Intent intent = new Intent(getActivity(),List.class);
        intent.putExtra("name","群馬");
        startActivity(intent);*/
    }

    public void onIbaraki(){
        Alert();
        /*Intent intent = new Intent(getActivity(),List.class);
        intent.putExtra("name","茨城");
        startActivity(intent);*/
    }

    public void onTochigi(){
        Alert();
        /*Intent intent = new Intent(getActivity(),List.class);
        intent.putExtra("name","栃木");
        startActivity(intent);*/
    }

    public void onSaitama(){
        Alert();
        /*Intent intent = new Intent(getActivity(),List.class);
        intent.putExtra("name","埼玉");
        startActivity(intent);*/
    }


    public void Alert(){
        new AlertDialog.Builder(getActivity())
                .setTitle("注意")
                .setMessage("Prototypeのためここから先の機能は実装していません。東京エリアを選択してください。")
                .setPositiveButton("OK", null)
                .show();
    }

    public interface OnFragmentInteractionListener {}
}
