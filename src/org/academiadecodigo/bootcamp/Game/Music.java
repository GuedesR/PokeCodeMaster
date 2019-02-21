package org.academiadecodigo.bootcamp.Game;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Music {

    //Menu song path
    private String menu= "res/themesong.wav";
    //Pokeball throw sound path from ThrowingBar (When spacebar is pressed)
    private String ball="res/pokeball.wav";
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