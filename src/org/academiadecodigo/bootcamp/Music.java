package org.academiadecodigo.bootcamp;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by codecadet on 18/02/2019.
 */
public class Music {

    //Menu song path
    private String menu= "/Users/codecadet/Dev/barraTent/res/themesong.wav";
    //Pokeball throw sound path from ThrowingBar (When spacebar is pressed)
    private String ball="/Users/codecadet/Dev/barraTent/res/pokeball.wav";
    //Variable to switch songs
    String playNow;

    public void musicplay(String song) {

        if(song=="menu") {
            playNow = menu;
        }
        if(song=="ball"){
            playNow = ball;
        }

        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;

        ContinuousAudioDataStream loop = null;

        try
        {
            InputStream test = new FileInputStream(playNow);
            BGM = new AudioStream(test);
            AudioPlayer.player.start(BGM);
            //MD = BGM.getData();
            //loop = new ContinuousAudioDataStream(MD);

        }
        catch(FileNotFoundException e){
            System.out.print(e.toString());
        }
        catch(IOException error)
        {
            System.out.print(error.toString());
        }
        MGP.start(loop);
    }
}