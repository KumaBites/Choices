package com.example.choices.Rhothomir.RecyclerView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.choices.R;



import java.util.List;


public class CharacterRecyclerViewAdapter extends RecyclerView.Adapter<CharacterRecyclerViewAdapter.CharacterSelectViewHolder> {
        private List<Character_Select_Model> character_select_modelList;
        Context context;



        public CharacterRecyclerViewAdapter(List<Character_Select_Model> character_select_modelList, Context context) {
            this.character_select_modelList = character_select_modelList;
            this.context = context;
        }

        @Override
        public CharacterSelectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //inflate the layout file
            View characterSelectModelview = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_character_select, parent, false);
            CharacterSelectViewHolder gvh = new CharacterSelectViewHolder(characterSelectModelview);
            return gvh;
        }

        @Override
        public void onBindViewHolder(CharacterSelectViewHolder holder, final int position) {
            String id1 = character_select_modelList.get(position).getSelect_uri();
            int id = context.getResources().getIdentifier(id1, "drawable", context.getPackageName());


            holder.txtcharacter_name.setText("Character name: "+character_select_modelList.get(position).getSelect_name());
            holder.txtrace.setText("Character race: "+character_select_modelList.get(position).getSelect_race());
            holder.txtbackground.setText("Background: "+character_select_modelList.get(position).getSelect_background());
            holder.txtendurance.setText("Endurance: "+character_select_modelList.get(position).getSelect_endurance());
            holder.txtstrength.setText("Strength: "+character_select_modelList.get(position).getSelect_strength());
            holder.txtwillpower.setText("Willpower: "+character_select_modelList.get(position).getSelect_willpower());
            holder.txtcharacter_image.setImageResource(id);//



        }
        @Override
        public int getItemCount() {
            return character_select_modelList.size();
        }

        public class CharacterSelectViewHolder extends RecyclerView.ViewHolder {
            TextView txtcharacter_name;
            TextView txtrace;
            TextView txtbackground;
            TextView txtendurance;
            TextView txtstrength;
            TextView txtwillpower;
            ImageView txtcharacter_image;


            public CharacterSelectViewHolder(View view) {
                super(view);
                txtcharacter_name = view.findViewById(R.id.character_name);
                txtrace = view.findViewById(R.id.race);
                txtbackground = view.findViewById(R.id.background);
                txtstrength = view.findViewById(R.id.strength);
                txtwillpower = view.findViewById(R.id.willpower);
                txtendurance = view.findViewById(R.id.endurance);
                txtcharacter_image = view.findViewById(R.id.character_image);
            }
        }
    }

