package com.example.proto.application;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reading extends Activity implements View.OnClickListener{

    Spinner spinner;
    TextView title, entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reading);
        spinner = (Spinner)findViewById(R.id.spinner1);
        title = (TextView)findViewById(R.id.textView1);
        entry = (TextView)findViewById(R.id.textView2);
        getFileNames();
    }

    @Override
    public void onClick(View v) {
        String file = String.valueOf(spinner.getSelectedItem());
        openFile(file);
    }

    private void getFileNames(){
        String[] fileNames = getApplicationContext().fileList();
        List<String> list = new ArrayList<String>();

        for(int i = 0; i < fileNames.length; i++){
            //Log.d("Filename", fileNames[i]);
            list.add(fileNames[i]);
        }

        ArrayAdapter<String> fileNameAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list);
        spinner.setAdapter(fileNameAdapter);
    }

    private void openFile(String selectedFile){
        String value = "";
        FileInputStream fileInputStream;

        try{
            fileInputStream = openFileInput(selectedFile);
            byte[] input = new byte[fileInputStream.available()];
            while(fileInputStream.read(input) != -1){
                value += new String(input);
            }
            fileInputStream.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        entry.setText(String.valueOf(value));
    }
}
