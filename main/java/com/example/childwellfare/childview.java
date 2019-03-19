package com.example.childwellfare;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class childview extends AppCompatActivity {

    private TextToSpeech mTTS;
    private Button mButtonSpeak;
    private EditText mshName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_childview);
        getSupportActionBar().hide();

       mButtonSpeak  = findViewById(R.id.ButtonSpeak);

        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        mButtonSpeak.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        mshName = findViewById(R.id.shname);
        mButtonSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
                String check = mshName.getText().toString();
                if (check.equals("superman")){

                    startActivity(new Intent(childview.this,superman.class));                }
                else if(check.equals("blackwidow")){
                    startActivity(new Intent(childview.this,blackwidow.class));

                }
            }
        });




    }
    public void speak(){
        String text = mshName.getText().toString();
        mTTS.speak("Your Hero is"+text, TextToSpeech.QUEUE_FLUSH, null);

    }
    @Override
    protected void onDestroy() {
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }

        super.onDestroy();
    }
}
