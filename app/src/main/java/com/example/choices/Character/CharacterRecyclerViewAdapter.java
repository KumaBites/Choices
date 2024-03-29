package com.example.choices.Character;

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


import com.example.choices.Events.Event;
import com.example.choices.R;

import java.util.List;


public class CharacterRecyclerViewAdapter extends RecyclerView.Adapter<CharacterRecyclerViewAdapter.CharacterSelectViewHolder> {
        private List<CharacterSelectModel> character_select_modelList;
        Context context;



        public CharacterRecyclerViewAdapter(List<CharacterSelectModel> character_select_modelList, Context context) {
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

        //The method takes the position of the character and sets the parameters and picture id and starts a new game when clicked
        public void newCharacter(int position, String character, String imageCheck, int id)
        {
            int newStrength,newEndurance,newWillpower;
            String strength,endurance,willpower;
            willpower = character_select_modelList.get(position).getSelect_defense();
            endurance = character_select_modelList.get(position).getSelect_health();
            strength = character_select_modelList.get(position).getSelect_strength();
            newStrength = Integer.parseInt(strength);
            newEndurance =Integer.parseInt(endurance);
            newWillpower = Integer.parseInt(willpower);
            //Set Player Stats
            Player.setName(character);
            Player.setRace(imageCheck);
            Player.setBackground(character_select_modelList.get(position).getSelect_background());
            Player.setStrength(newStrength);
            Player.setWillpower(newWillpower);
            Player.setEndurance(newEndurance);
            Player.setCurrentEventID(1.0);
            Player.setPicturUrl(id);
            //Starts new activity
            Intent newIntent = new Intent(context, Event.class);
            context.startActivity(newIntent);
            CharacterSelect.getInstance().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            //Destroys activity
            CharacterSelect.getInstance().finish();
        }
        @Override
        public void onBindViewHolder(CharacterSelectViewHolder holder, final int position) {
            String id1 = character_select_modelList.get(position).getSelect_drawable_name();
            final int id = context.getResources().getIdentifier(id1, "drawable", context.getPackageName());


            holder.txtcharacter_name.setText("Character name: "+character_select_modelList.get(position).getSelect_name());
            holder.txtrace.setText("Character race: "+character_select_modelList.get(position).getSelect_race());
            holder.txtbackground.setText("Background: "+character_select_modelList.get(position).getSelect_background());
            holder.txthealth.setText("Endurance: "+character_select_modelList.get(position).getSelect_health());
            holder.txtstrength.setText("Strength: "+character_select_modelList.get(position).getSelect_strength());
            holder.txtdefense.setText("Willpower: "+character_select_modelList.get(position).getSelect_defense());
            holder.txtcharacter_image.setImageResource(id);

            holder.txtcharacter_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String imageCheck = character_select_modelList.get(position).getSelect_drawable_name();
                    final String elf = "Nardual Glynwynn";
                    final String dwarf ="Throdgram Redbringer";
                    final String human = "Rave Vossen";
                    if (imageCheck.equals("elf"))
                    {
                    Toast.makeText(context, elf + " is selected", Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage("Do you want to start the adventure with " +elf+"?");
                        builder.setCancelable(true);
                        builder.setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                        newCharacter(position,elf,imageCheck,id);

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
                                newCharacter(position,dwarf,imageCheck,id);
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
                                newCharacter(position,human,imageCheck,id);
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
            TextView txthealth;
            TextView txtstrength;
            TextView txtdefense;
            ImageView txtcharacter_image;


            public CharacterSelectViewHolder(View view) {
                super(view);
                txtcharacter_name = view.findViewById(R.id.character_name);
                txtrace = view.findViewById(R.id.race);
                txtbackground = view.findViewById(R.id.background);
                txtstrength = view.findViewById(R.id.strength);
                txtdefense = view.findViewById(R.id.willpower);
                txthealth = view.findViewById(R.id.endurance);
                txtcharacter_image = view.findViewById(R.id.character_image);
            }
        }
    }

