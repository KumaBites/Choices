package com.example.choices.Rhothomir.RecyclerView;

import android.content.Context;
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

            holder.txtcharacter_name.setText(character_select_modelList.get(position).getSelect_name());
            holder.txtrace.setText(character_select_modelList.get(position).getSelect_race());
            holder.txtbackground.setText(character_select_modelList.get(position).getSelect_background());
            holder.txtendurance.setText(character_select_modelList.get(position).getSelect_endurance());
            holder.txtstrength.setText(character_select_modelList.get(position).getSelect_strength());
            holder.txtwillpower.setText(character_select_modelList.get(position).getSelect_willpower());
            holder.txtcharacter_image.setImageURI(character_select_modelList.get(position).getSelect_uri());



        }
        @Override
        public int getItemCount() {
            return character_select_modelList.size();
        }

        public class CharacterSelectViewHolder extends RecyclerView.ViewHolder {
            TextView txtcharacter_name;
            TextView txtrace;
            TextView txtbackground;
            TextView txtstrength;
            TextView txtwillpower;
            TextView txtendurance;
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

