package com.data.algo.design.behavioural;

// 1. command interface
interface Command {
    void execute();
}

// 2. Receiver
class Light {
    public void on(){ System.out.println("Light is ON"); }
    public void off(){ System.out.println("Light is OFF");}
}

// 3. Concrete Commands
class LightOnCommand implements Command {
    Light light;
    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

class LightOffCommand implements Command {
    Light light;
    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}

// 4. Invoker
class RemoteControl {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void pressButton() { command.execute(); }
}


public class CommandPattern {
    public static void main(String[] args) {
        Light light = new Light();
        RemoteControl remote = new RemoteControl();
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);

        remote.setCommand(lightOnCommand);
        remote.pressButton();

        remote.setCommand(lightOffCommand);
        remote.pressButton();
    }
}
