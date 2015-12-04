package com.example.proto.application;

import android.app.Activity;
import android.media.MediaPlayer;
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

public class SaveToSD extends Activity implements View.OnClickListener, View.OnLongClickListener{

    Button savePic, saveSound;
    EditText fileName;
    boolean isSDAvailable = false, isSDWriteable = false;
    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.savetosd);
        savePic = (Button) findViewById(R.id.savePicture);
        saveSound =(Button)findViewById(R.id.saveSound);
        fileName =(EditText)findViewById(R.id.filename);
        savePic.setOnClickListener(this);
        saveSound.setOnClickListener(this);
        saveSound.setOnLongClickListener(this);
        checkSDCard();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.savePicture:
                File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                String name = fileName.getText().toString();
                File file = new File(path, name + ".jpg");
                saveData(path, file, R.drawable.image1);
                music.stop();
                break;
            case R.id.saveSound:
                music = MediaPlayer.create(this, R.raw.music);
                music.start();
                break;
        }
    }

    private void saveData(File path, File file, int info) {
        if(isSDAvailable && isSDWriteable){
            // check validity of the file path
            try {
                path.mkdirs(); // make the directory if it is not available yet
                InputStream inputStream = getResources().openRawResource(info);
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

    @Override
    public boolean onLongClick(View v) {
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
        String name = fileName.getText().toString();
        File file = new File(path, name + ".mp3");
        saveData(path, file, R.raw.music);
        return false;
    }
}
