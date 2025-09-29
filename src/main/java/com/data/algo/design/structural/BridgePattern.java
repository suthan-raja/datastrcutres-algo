package com.data.algo.design.structural;

interface Tv {
    void on();

    void off();

    void changeChannel(int channel);
}

class SonyTv implements Tv {

    @Override
    public void on() {
        System.out.println("Sony TV is ON");
    }

    @Override
    public void off() {
        System.out.println("Sony TV is OFF");
    }

    @Override
    public void changeChannel(int channel) {
        System.out.println("Sony TV: Channel " + channel);
    }
}

class SamsungTv implements Tv {

    @Override
    public void on() {
        System.out.println("Samsung TV is ON");
    }

    @Override
    public void off() {
        System.out.println("Samsung TV is OFF");
    }

    @Override
    public void changeChannel(int channel) {
        System.out.println("Samsung TV: Channel " + channel);
    }
}

class LgTv implements Tv {

    @Override
    public void on() {
        System.out.println("Lg TV is ON");
    }

    @Override
    public void off() {
        System.out.println("Lg TV is OFF");
    }

    @Override
    public void changeChannel(int channel) {
        System.out.println("Lg TV: Channel " + channel);
    }
}

abstract class BasicRemote {
    protected Tv tv; // bridge
    public BasicRemote(Tv tv) {
        this.tv = tv;
    }
    public void turnOn(){
        tv.on();
    }
    public void turnOff(){
        tv.off();
    }
    public void changeChannel(int channel){
        tv.changeChannel(channel);
    }
}

class BasicRemoteController extends BasicRemote {
    public BasicRemoteController(Tv tv) {
        super(tv);
    }
    public void mute() {
        System.out.println("Remote: Mute button pressed");
    }
}

public class BridgePattern {
    public static void main(String[] args) {
        Tv sonyTv = new SonyTv();
        BasicRemote sonyRemote = new BasicRemoteController(sonyTv);
        sonyRemote.turnOn();
        sonyRemote.changeChannel(5);
        sonyRemote.turnOff();

        System.out.println();


        Tv samsung = new SamsungTv();
        BasicRemote samsungRemote = new BasicRemoteController(samsung);

        samsungRemote.turnOn();
        samsungRemote.changeChannel(10);
        samsungRemote.turnOff();
    }
}
