package com.example.childwellfare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
  private Button pView;
  private Button cView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    pView = (Button) findViewById(R.id.parentView);
    cView = (Button) findViewById(R.id.childView);
    pView.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v)
        {
            startActivity(new Intent(MainActivity.this,parentview.class));
        }
    });
    cView.setOnClickListener(new View.OnClickListener(){
        @Override
                public void onClick(View v){
                startActivity(new Intent(MainActivity.this,childview.class));
        }

        });

    }
}
