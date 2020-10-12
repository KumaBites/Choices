package com.example.choices.Rhothomir.CharacterSelectRecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;


import com.example.choices.Fantasy.Fantasy_Event;
import com.example.choices.Fantasy.Fantasy_Player;
import com.example.choices.GettingReady.Alan_Event;
import com.example.choices.GettingReady.Alan_Player;
import com.example.choices.R;
import com.example.choices.Rhothomir.Rhothomir_Player;
import com.example.choices.Story_Select;


import java.util.List;
import java.util.Random;


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
            holder.txtcharacter_image.setImageResource(id);



            holder.txtcharacter_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String imageCheck = character_select_modelList.get(position).getSelect_uri();
                    final String elf = "Nardual Glynwynn";
                    final String dwarf ="Throdgram Redbringer";
                    final String human = "Rave Vossen";

                    final Intent newStory = new Intent(context,Story_Select.class);
                    if (imageCheck.equals("elf"))
                    {
                    Toast.makeText(context, elf + " is selected", Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage("Do you want to start the adventure with " +elf+"?");
                        builder.setCancelable(true);
                        builder.setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int newStrength,newEndurance,newWillpower;
                                String strength,endurance,willpower;
                               willpower = character_select_modelList.get(position).getSelect_willpower();
                               endurance = character_select_modelList.get(position).getSelect_endurance();
                               strength = character_select_modelList.get(position).getSelect_strength();
                               newStrength = Integer.parseInt(strength);
                               newEndurance =Integer.parseInt(endurance);
                               newWillpower = Integer.parseInt(willpower);
                               //Set Player Stats
                                Rhothomir_Player.setName(elf);
                                Rhothomir_Player.setRace(imageCheck);
                                Rhothomir_Player.setBackground(character_select_modelList.get(position).getSelect_background());
                                Rhothomir_Player.setStrength(newStrength);
                                Rhothomir_Player.setWillpower(newWillpower);
                                Rhothomir_Player.setEndurance(newEndurance);


                            }
                        });
                        builder.show();
                    }
                    else if(imageCheck.equals("dwarf"))
                    {
                        Toast.makeText(context, dwarf + " is selected", Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage("Do you want to start the adventure with " +dwarf+"?");
                        builder.setCancelable(true);
                        builder.setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        builder.show();
                    }
                    else if(imageCheck.equals("human"))
                    {
                        Toast.makeText(context, human + " is selected", Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage("Do you want to start the adventure with " +human+"?");
                        builder.setCancelable(true);
                        builder.setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        builder.show();
                    }

                }
            });

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

