# Android-VoiceButton
a button to play voice,一个模仿QQ语音播放的控件，播放语音的时候代表音波的图片会动
<img src="https://github.com/yaochangliang159/Android-VoiceButton/raw/master/screenshot/gif.jpg" width=320 height=480 />

###用法
```Java
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
```
####就是这样,瞄
