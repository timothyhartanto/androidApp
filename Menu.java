package com.example.proto.application;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends Activity implements View.OnClickListener{

    String activities[] = {"MainCalculator", "SETTINGS", "INTERNALSTORAGE", "READING"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        for(int i = 0; i < activities.length; i++){
            if(id == getResources().getIdentifier("btn" + i, "id", "com.example.proto.application")){
                Intent intent = new Intent("com.example.proto.application." + activities[i]);
                startActivity(intent);
            }
        }

    }
}
