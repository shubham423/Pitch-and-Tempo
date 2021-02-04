package com.example.pitchandtempo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AudioManager audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);


        Button upButton = (Button) findViewById(R.id.upButton);
        upButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

//To increase media player volume
                audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
            }
        });

        Button downButton = (Button) findViewById(R.id.downButton);
        downButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

//To decrease media player volume
                audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
            }
        });

    }

    public void playmusic(View view) {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.teental_d);
        mp.start();
    }

    public void tempoclick(View view) {

    }
//        private void startPitchShifting()
//    {
//        double rate = 1.0;
//        RateTransposer rateTransposer;
//        AudioDispatcher dispatcher;
//        WaveformSimilarityBasedOverlapAdd wsola;
//
//        File downloadFolder = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
//        new AndroidFFMPEGLocator(this);
//
//        String mAudiopath = downloadFolder.getAbsolutePath() + "/test.wav";
////        String mAudiopath = "/storage/emulated/0/Download/test.wav";
//        dispatcher = AudioDispatcherFactory.fromPipe(mAudiopath, 44100, 5000, 2500);
////        dispatcher = AudioDispatcherFactory.fromDefaultMicrophone(22050,1024,0);
//        rateTransposer = new RateTransposer(rate);
//        wsola = new WaveformSimilarityBasedOverlapAdd(WaveformSimilarityBasedOverlapAdd.Parameters.musicDefaults(rate, 44100));
//        File f = new File(downloadFolder.getAbsolutePath(), "shifting.wav");
////        File f = new File("/storage/emulated/0/Download/outputshift.wav");
//        RandomAccessFile raf = null;
//        try
//        {
//            raf = new RandomAccessFile(f, "rw");
//        } catch (FileNotFoundException e)
//        {
//            e.printStackTrace();
//        }
//        WriterProcessor writer = new WriterProcessor((TarsosDSPAudioFormat) dispatcher.getFormat(), raf);
//
//        wsola.setDispatcher(dispatcher);
//        dispatcher.addAudioProcessor(wsola);
//        dispatcher.addAudioProcessor(rateTransposer);
//        dispatcher.addAudioProcessor(new AndroidAudioPlayer(dispatcher.getFormat()));
//        dispatcher.setZeroPadFirstBuffer(true);
//        dispatcher.setZeroPadLastBuffer(true);
//        dispatcher.addAudioProcessor(writer);
////        dispatcher.run();
//
//        new Thread(dispatcher,"Shifting Dispatcher").start();
//    }

}