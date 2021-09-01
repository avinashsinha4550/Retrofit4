package com.example.retrofittry3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Filemanagment extends AppCompatActivity {
    EditText editText;
    Button button_Save,button_Load;
    public static final String FILE_NAME="Avi.txt";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filemanagment);
        editText= findViewById(R.id.edit_text);
        button_Save= findViewById(R.id.button_save);
        button_Load= findViewById(R.id.button_load);
        button_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=editText.getText().toString();
                FileOutputStream fileOutputStream=null;
                Log.d("Avinash","Avinashsinha");

                try {
                    fileOutputStream=openFileOutput(FILE_NAME,MODE_PRIVATE);
                    fileOutputStream.write(text.getBytes());
                    editText.getText().clear();
                    Toast.makeText(Filemanagment.this, "the directory is"+getFilesDir()+"name", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally {
                    if (fileOutputStream!=null)
                    {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }


            }
        });
        button_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileInputStream fileInputStream=null;
                try {
                    fileInputStream=openFileInput(FILE_NAME);
                    InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                    StringBuilder str=new StringBuilder();
                    String text;
                    while((text=bufferedReader.readLine())!=null)
                    {
                        str.append(text).append("\n");
                        editText.setText(str.toString());
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally {
                    if(fileInputStream!=null)
                    {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });



    }
}
