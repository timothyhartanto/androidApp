package com.example.proto.application;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SaveToSD extends Activity implements View.OnClickListener{

    Button savePic, saveSound;
    EditText fileName;
    boolean isSDAvailable = false, isSDWriteable = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.savetosd);
        savePic = (Button) findViewById(R.id.savePicture);
        saveSound =(Button)findViewById(R.id.saveSound);
        fileName =(EditText)findViewById(R.id.filename);
        savePic.setOnClickListener(this);
        saveSound.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.savePicture:
                
                break;
            case R.id.saveSound:
                
                break;
        }
    }

    private void checkSDStuff() {
        // TODO Auto-generated method stub
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)){
            //write
            isSDAvailable = true;
            isSDWriteable =true;
        }else if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
            //read only
            isSDAvailable = true;
            isSDWriteable =false;
        }else{
            //uh-oh
            isSDAvailable = false;
            isSDWriteable =false;
        }
    }

}
