package com.example.retrofittry3;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class jason1 extends AppCompatActivity {
    TextView enter_name,enter_salary;
    String jasonArray="{\"Employee\":{\"name\":\"Master Avinash\",\"salary\":6000}}";
    String name,salary;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jason1);
        enter_name=findViewById(R.id.name);
        enter_salary=findViewById(R.id.salary);
        try {
            JSONObject jsonObject=new JSONObject(jasonArray);
            JSONObject employee=jsonObject.getJSONObject("Employee");
            Toast.makeText(jason1.this, "welcome", Toast.LENGTH_SHORT).show();
            name= employee.getString("name");
            salary= employee.getString("salary");
            enter_name.setText(name);
            enter_salary.setText(salary);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
