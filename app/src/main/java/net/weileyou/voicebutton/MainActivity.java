package net.weileyou.voicebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.weileyou.voicebutton.library.VoiceButton;

public class MainActivity extends AppCompatActivity {
    VoiceButton voicebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        voicebutton= (VoiceButton) findViewById(R.id.voicebutton);
        voicebutton.setPlayPath("http://123.57.219.205/upload/20170225/20170225144500002491.amr");
    }
}
