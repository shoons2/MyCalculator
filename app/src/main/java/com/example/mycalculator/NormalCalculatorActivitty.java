package com.example.mycalculator;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class NormalCalculatorActivitty extends AppCompatActivity {
    TextView textView;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;
    Button btnPlue;
    Button btnMinus;
    Button btnMul;
    Button btnDiv;
    Button btnEqual;
    ImageView imageView;
    Boolean isPlay = false;
    AudioTrack mAudioTrack=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_normal_calculator_activitty);
        textView = findViewById(R.id.textView);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnPlue = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnEqual = findViewById(R.id.btnEqual);
        imageView = findViewById(R.id.imageView);
        int mBufferSize = AudioRecord.getMinBufferSize(44100, AudioFormat.CHANNEL_IN_STEREO, AudioFormat.ENCODING_PCM_16BIT);
        mAudioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, 44100, AudioFormat.CHANNEL_IN_STEREO, AudioFormat.ENCODING_PCM_16BIT, mBufferSize, AudioTrack.MODE_STREAM);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlay == true) {
                    isPlay = false;

                }
                else {
                    isPlay = true;


                    Thread mPlayThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            byte[] writeData = new byte[mBufferSize];
                            InputStream inputStream = null;
                            try {

                                inputStream = getResources().openRawResource(R.raw.bbogle);
                            }catch (Exception e) {
                                e.printStackTrace();
                            }

                            DataInputStream dis = new DataInputStream(inputStream);
                            mAudioTrack.play();  // write 하기 전에 play 를 먼저 수행해 주어야 함

                            while(isPlay) {
                                try {
                                    int ret = dis.read(writeData, 0, mBufferSize);
                                    if (ret <= 0) {
                                        (NormalCalculatorActivitty.this).runOnUiThread(new Runnable() { // UI 컨트롤을 위해
                                            @Override
                                            public void run() {
                                                isPlay = false;

                                            }
                                        });
                                        break;
                                    }
                                    mAudioTrack.write(writeData, 0, ret); // AudioTrack 에 write 를 하면 스피커로 송출됨
                                }catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }
                            mAudioTrack.stop();
                            mAudioTrack.release();
                            mAudioTrack = null;

                            try {
                                dis.close();
                                inputStream.close();
                            }catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    if(mAudioTrack == null) {
                        int mBufferSize = AudioRecord.getMinBufferSize(44100, AudioFormat.CHANNEL_IN_STEREO, AudioFormat.ENCODING_PCM_16BIT);
                        mAudioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, 44100, AudioFormat.CHANNEL_IN_STEREO, AudioFormat.ENCODING_PCM_16BIT, mBufferSize, AudioTrack.MODE_STREAM);
                    }
                    mPlayThread.start();
                }

            }
        });
    }
}