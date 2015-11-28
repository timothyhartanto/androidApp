package com.example.proto.calculator;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Settings extends Activity implements View.OnClickListener{

    CheckBox cb;
    EditText et;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        cb = (CheckBox)findViewById(R.id.checkBox1);
        et = (EditText)findViewById(R.id.editText1);
        b = (Button)findViewById(R.id.button1);
        b.setOnClickListener(this);

        loadPrefs();
    }

    @Override
    public void onClick(View v){
        savePrefs("CHECKBOX", cb.isChecked());
        if(cb.isChecked())
            savePrefs("NAME", et.getText().toString());

        finish();
    }

    private void loadPrefs(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        boolean cbValue = sp.getBoolean("CHECKBOX", false); // if name is not found, the result will be passed is false (based on the preference)
        String name = sp.getString("NAME", "Your Name");
        if(cbValue){
            cb.setChecked(true);
        }
        else{
            cb.setChecked(false);
        }
        et.setText(name);
    }

    private void savePrefs(String key, boolean value){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    private void savePrefs(String key, String value){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.commit();
    }
}
