package com.example.g015c1308.election2;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class LargeRegion extends Fragment {
    //Fragment
    private OnFragmentInteractionListener mListener;

    public LargeRegion() {}

    public static LargeRegion newInstance() {
        LargeRegion fragment = new LargeRegion();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_large_region,container,false);
        Button KantouButton = (Button)v.findViewById(R.id.kantou);
        Button TouhokuButton = (Button)v.findViewById(R.id.touhoku);
        Button HokaidouButton = (Button)v.findViewById(R.id.hokaidou);
        Button KousinetuHokurikuButton = (Button)v.findViewById(R.id.koushinetuhokuriku);
        Button ToukaiButton = (Button)v.findViewById(R.id.toukai);
        Button TyugokuButton = (Button)v.findViewById(R.id.tyuugoku);
        Button KansaiButton = (Button)v.findViewById(R.id.kansai);
        Button SikokuButton = (Button)v.findViewById(R.id.shikoku);
        Button KyusyuButton = (Button)v.findViewById(R.id.kyusyuu);
        KantouButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onKantou();
            }
        });
        TouhokuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTouhoku();
            }
        });
        KousinetuHokurikuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onKousinetuHokuriku();
            }
        });
        HokaidouButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("注意")
                        .setMessage("Prototypeのためここから先の機能は実装していません。東京エリアを選択してください。")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
        ToukaiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onToukai();
            }
        });
        KansaiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onKansai();
            }
        });
        TyugokuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTyugoku();
            }
        });
        SikokuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSikoku();
            }
        });
        KyusyuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onKyusyu();
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

    public void onKantou(){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content,KantoRegion.newInstance()).addToBackStack(null).commit();
    }

    public void onTouhoku(){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content,TouhokuRegion.newInstance()).addToBackStack(null).commit();
    }

    public void onKousinetuHokuriku(){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content,KoushinetuHokurikuRegion.newInstance()).addToBackStack(null).commit();
    }

    public void onToukai(){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content,ToukaiRegion.newInstance()).addToBackStack(null).commit();
    }

    public void onKansai(){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content,KansaiRegion.newInstance()).addToBackStack(null).commit();
    }

    public void onTyugoku(){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content,TyugokuRegion.newInstance()).addToBackStack(null).commit();
    }

    public void onSikoku(){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content,SikokuRegion.newInstance()).addToBackStack(null).commit();
    }

    public void onKyusyu(){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content,KyusyuuRegion.newInstance()).addToBackStack(null).commit();
    }


    public interface OnFragmentInteractionListener {}
}
