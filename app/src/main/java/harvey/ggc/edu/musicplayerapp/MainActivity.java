package harvey.ggc.edu.musicplayerapp;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SeekBar volumeControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.adele);
        final TextView volumeTextView;

        //media player has to be final

        Button Play = (Button) findViewById(R.id.button_Play);
        Button Pause = (Button) findViewById(R.id.button_Pause);
        Button Stop = (Button) findViewById(R.id.button_Stop);
        volumeControl = (SeekBar) findViewById(R.id.volume_seekbar); //extra feature
        volumeTextView = (TextView) findViewById(R.id.volume_textview); //states volume levels

         //create an object of the class

        //the pc had to implement its own onClick method
        Play.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                //it could go here...the oncompletion method
                /*mediaplayer.setOnCompletion(MediaPlayer mediaPlayer){
                @Override
                public void onCompletion(MediaPlayer mediaPlayer){
                Toast.makeText(MainActivity.this)
                }
                });
                 */
            }
        });

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                volumeTextView.setText(String.valueOf("Volume " + volumeControl.getProgress() + "%"));
                mp.setVolume(progress / 100f, progress / 100f);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar){

            }
        });

           // public void OnClick(View v){
              //  mp.start();
           // }
     //   });

        Pause.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
            }
        });


           // public void OnClick(View v){
              // mp.pause();
        //    }
      //  });

        Stop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.stop();
                MainActivity.this.finish();
            }
        });


           // public void OnClick(View v){
              //  mp.stop();
               // MainActivity.this.finish();
          //  }
     //   });
            //example of async callback
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            public void onCompletion(MediaPlayer mediaPlayer){
                Toast.makeText(MainActivity.this, "I'm Done!", Toast.LENGTH_SHORT).show();
            }
        });


    }


}
