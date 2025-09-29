package com.data.algo.design.structural;

class DvdPlayer {
    public void on() { System.out.println("DVD Player ON"); }
    public void play(String movie) { System.out.println("Playing movie: " + movie); }
    public void off() { System.out.println("DVD Player OFF"); }
}

class Projector {
    public void on() { System.out.println("Projector ON"); }
    public void wideScreenMode() { System.out.println("Projector in widescreen mode"); }
    public void off() { System.out.println("Projector OFF"); }
}

class SoundSystem {
    public void on() { System.out.println("Sound System ON"); }
    public void setVolume(int level) { System.out.println("Sound volume set to " + level); }
    public void off() { System.out.println("Sound System OFF"); }
}

// Facade Class
class HomeTheaterFacade {
    private DvdPlayer dvd;
    private Projector projector;
    private SoundSystem sound;
    public HomeTheaterFacade(DvdPlayer player, Projector projector, SoundSystem soundSystem) {
        this.dvd = player;
        this.projector = projector;
        this.sound = soundSystem;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        dvd.on();
        dvd.play(movie);
        projector.on();
        projector.wideScreenMode();
        sound.on();
        sound.setVolume(10);
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        dvd.off();
        projector.off();
        sound.off();
    }
}

// Client
public class FacadePattern {
    public static void main(String[] args) {
        // Create subsystems
        DvdPlayer dvd = new DvdPlayer();
        Projector projector = new Projector();
        SoundSystem sound = new SoundSystem();

        // Create Facade
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvd, projector, sound);

        // Use Facade
        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();
    }
}
