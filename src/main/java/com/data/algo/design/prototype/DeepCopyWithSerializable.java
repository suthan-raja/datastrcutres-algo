package com.data.algo.design.prototype;

import java.io.Serializable;

class Train implements Serializable {
    String ac;
    String nonAc;
    Train(String ac, String nonAc) {
        this.ac = ac;
        this.nonAc = nonAc;
    }

    @Override
    public String toString() {
        return "Train{" +
                "ac='" + ac + '\'' +
                ", nonAc='" + nonAc + '\'' +
                '}';
    }
}

class Bus implements Serializable {
    String ac;
    String nonAc;
    Bus(String ac, String nonAc) {
        this.ac = ac;
        this.nonAc = nonAc;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "ac='" + ac + '\'' +
                ", nonAc='" + nonAc + '\'' +
                '}';
    }
}

class Travel implements Serializable {
    String name;
    Train train;
    Bus bus;

    Travel(String name, Train train, Bus bus) {
        this.name = name;
        this.train = train;
        this.bus = bus;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "name='" + name + '\'' +
                ", train=" + train +
                ", bus=" + bus +
                '}';
    }
}

public class DeepCopyWithSerializable {
    public static void main(String[] args) {
        Bus bus = new Bus("yes", "no");
        Train train = new Train("yes", "no");
        Travel travel = new Travel("Suthan", train, bus);
        System.out.println(travel);

        Travel travel1 = DeepCopyUtil.deepCopy(travel);
        System.out.println(travel1);

        System.out.println(travel == travel1);
    }
}
