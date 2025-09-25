package com.data.algo.design.structural;

interface MediaPlayer {
    void play(String audioType, String fileName);
}

class AdvancedMediaPlayer {
    void playVlc(String fileName) {
        System.out.println("Playing VLC File: " + fileName);
    }

    void playKmp(String fileName) {
        System.out.println("Playing KMP File: " + fileName);
    }
}

class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;
    MediaAdapter(String audioType) {
        advancedMediaPlayer = new AdvancedMediaPlayer();
    }

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equals("vlc")) {
            advancedMediaPlayer.playVlc(fileName);
        }else if(audioType.equals("kmp")) {
            advancedMediaPlayer.playKmp(fileName);
        }
    }
}

class AudioPlayer implements MediaPlayer {
    private MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file: " + fileName);
        } else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}


public class AdapterPattern {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "sample.mp3");
        audioPlayer.play("vlc", "sample.vlc");
        audioPlayer.play("mp4", "sample.mp4");
    }
}
