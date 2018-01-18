package com.example.g015c1308.election2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

/**
 * Created by G015C1308 on 2018/01/10.
 */

public class RegionRealmAdapter extends RealmRecyclerViewAdapter<NameModel,RegionRealmAdapter.RegionViewHolder> {
    Context context;

    public static class RegionViewHolder extends RecyclerView.ViewHolder{
        protected TextView name;
        protected TextView etc;
        protected ImageView flag;

        public RegionViewHolder(View view){
            super(view);
            name = (TextView)view.findViewById(R.id.cardname);
            etc = (TextView)view.findViewById(R.id.etc);
            flag = (ImageView) view.findViewById(R.id.flag);
        }
    }

    public RegionRealmAdapter(@NonNull Context context,@Nullable OrderedRealmCollection<NameModel> data, boolean autoUpdate) {
        super(data, autoUpdate);
        this.context = context;
    }

    @Override
    public RegionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
        final RegionViewHolder holder = new RegionViewHolder(view);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                NameModel nameModel = getData().get(position);
                int nameid = nameModel.getId();

                Intent intent = new Intent(context,Member.class);
                intent.putExtra("NameId",nameid);
                context.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(RegionViewHolder holder, int position) {
        NameModel nameModel = getData().get(position);
        holder.name.setText(nameModel.getName());
        holder.etc.setText(nameModel.getEtc());
        if(nameModel.isFlag() == true){
            holder.flag.setImageResource(R.drawable.ok1105081);
        }
    }

}
