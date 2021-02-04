package com.example.pitchandtempo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AudioManager audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);


        Button tempoBtn=findViewById(R.id.tempoBtn);
        Button pitchBtn=findViewById(R.id.pitchBtn);

        pitchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_pitch);
                Spinner spinner=dialog.findViewById(R.id.pitchSpinner);
                ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(MainActivity.this,R.array.pitches, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);

                dialog.show();
            }
        });

        tempoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_tempo);
                SeekBar seekBar=dialog.findViewById(R.id.seekBar);
                Button addBtn=dialog.findViewById(R.id.add);
                Button minusBtn=dialog.findViewById(R.id.minus);
                TextView value=dialog.findViewById(R.id.value);

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        value.setText(i+75+"/600");
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

                addBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int index=seekBar.getProgress();
                        for (int i=0;i<=1;i++){
                            seekBar.setProgress(index+1);
                        }
                    }
                });

                minusBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int index=seekBar.getProgress();
                        seekBar.setProgress(index-1);
                    }
                });

                dialog.show();
            }


        });
        Button upButton = (Button) findViewById(R.id.upButton);
        upButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
            }
        });

        Button downButton = (Button) findViewById(R.id.downButton);
        downButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
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