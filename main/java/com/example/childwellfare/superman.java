package com.example.childwellfare;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import android.widget.ImageView;



import java.util.Locale;

public class superman extends AppCompatActivity {
    private TextToSpeech mTTS1;
    //private Button mButtonSpeak;
   private String str11;
    private ImageView mspman;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mspman = findViewById(R.id.spman);

        Bundle bundle = getIntent().getExtras();
        String str1 = bundle.getString("str1");
        getSupportActionBar().hide();
        setContentView(R.layout.activity_superman);

        str11=str1;



        mTTS1 = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTS1.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });


       mspman = findViewById(R.id.spman);
        mspman.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               speak1();
               startActivity(new Intent(superman.this,yesno.class));
           }
       }
       );


    }
    public void speak1(){

           Bundle bundle = getIntent().getExtras();
           String str1 = bundle.getString("str1");
          /* String str2 = bundle.getString("str2");
           String str3 = bundle.getString("str3");
           String str4 = bundle.getString("str4");*/

           mTTS1.speak(str1, TextToSpeech.QUEUE_FLUSH, null);
          /* mTTS.speak(str2, TextToSpeech.QUEUE_ADD, null);
           mTTS.speak(str3, TextToSpeech.QUEUE_ADD, null);
           mTTS.speak(str4, TextToSpeech.QUEUE_ADD, null);*/




    }
   /* @Override
    protected void onPause() {
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }

        super.onPause();


    }*/
}
