package com.example.proto.application;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
        checkSDCard();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.savePicture:
                if(isSDAvailable && isSDWriteable){
                    File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                    String name = fileName.getText().toString();
                    File file = new File(path, name + ".jpg");

                    // check validity of the file path
                    try {
                        path.mkdirs();
                        InputStream inputStream = getResources().openRawResource(R.raw.image1);
                        OutputStream outputStream = new FileOutputStream(file);

                        byte[] data = new byte[inputStream.available()];
                        inputStream.read(data);
                        outputStream.write(data);

                        inputStream.close();
                        outputStream.close();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.saveSound:

                break;
        }
    }

    private void checkSDCard() {
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)){
            //write
            isSDAvailable = true;
            isSDWriteable = true;
        }else if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
            //read only
            isSDAvailable = true;
            isSDWriteable = false;
        }else{
            //no SD
            isSDAvailable = false;
            isSDWriteable = false;
        }
    }

}
