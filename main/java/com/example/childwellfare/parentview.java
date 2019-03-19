package com.example.childwellfare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class parentview extends AppCompatActivity {
    /*private static final String TAG = "MainActivity";
    DatabaseHelper mDatabaseHelper;*/

    private Button mNext;
    private EditText mq1;
    private EditText mq2;
    private EditText mq3;
    private EditText mq4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parentview);
        getSupportActionBar().setTitle("Parent View");


        mNext =findViewById(R.id.nxtbtn);
        mNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(parentview.this, superman.class);
                mq1 = findViewById(R.id.t1);
                String str1 = mq1.getText().toString();
                mq2 = findViewById(R.id.t2);
                String str2 = mq2.getText().toString();
                mq3 = findViewById(R.id.t3);
                String str3 = mq3.getText().toString();
                mq4 = findViewById(R.id.t4);
                String str4 = mq4.getText().toString();
                intent.putExtra("str1",str1);
                intent.putExtra("str2",str2);
                intent.putExtra("str3",str3);
                intent.putExtra("str4",str4);
                startActivity(intent);
                startActivity(new Intent(parentview.this,childview.class));
            }

        });


        /*mDatabaseHelper = new DatabaseHelper(this);

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String newEntry1= mq1.getText().toString();
                String newEntry2= mq2.getText().toString();
                String newEntry3= mq3.getText().toString();
                String newEntry4= mq4.getText().toString();
                AddData(newEntry1);
                mq4.setText("");
                AddData(newEntry2);
                mq2.setText("");
                AddData(newEntry3);
                mq3.setText("");
                AddData(newEntry4);
                mq1.setText("");

            }
        });
    }
    public void AddData(String newEntry){
  boolean insertData= mDatabaseHelper.addData(newEntry);
   if(insertData){
       toastMessage("Data Successfully Inserted");
   }
   else{
        toastMessage("Something went wrong");
        }
    }
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }*/
    }
}