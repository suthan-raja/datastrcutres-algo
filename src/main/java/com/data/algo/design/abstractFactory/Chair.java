package com.data.algo.design.abstractFactory;

interface Chair {
    void sitOn();
}

interface Sofa {
    void lieOn();
}

class ModernChair implements Chair {
    @Override
    public void sitOn() { System.out.println("Sitting on Modern Chair"); }
}

class ModernSofa implements Sofa {
    @Override
    public void lieOn() { System.out.println("Lying on Modern Sofa"); }
}

class VictorianChair implements Chair {
    @Override
    public void sitOn() { System.out.println("Sitting on Victorian Chair"); }
}

class VictorianSofa implements Sofa {
    @Override
    public void lieOn() { System.out.println("Lying on Victorian Sofa"); }
}

interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
}

class ModernFurnitureFactory  implements FurnitureFactory {
    public Chair createChair() { return new ModernChair(); }
    public Sofa createSofa() { return new ModernSofa(); }
}

class VictorianFurnitureFactory  implements FurnitureFactory {
    public Chair createChair() { return new VictorianChair(); }
    public Sofa createSofa() { return new VictorianSofa(); }
}

class Client {
    public static void main(String[] args) {
        FurnitureFactory furnitureFactory = new ModernFurnitureFactory();

        /*Chair chair = furnitureFactory.createChair();
        Sofa sofa = furnitureFactory.createSofa();

        chair.sitOn(); // Sitting on Modern Chair
        sofa.lieOn();  // Lying on Modern Sofa*/

        furnitureFactory.createChair().sitOn();
        furnitureFactory.createSofa().lieOn();

        FurnitureFactory furnitureFactory2 = new VictorianFurnitureFactory();
        furnitureFactory2.createChair().sitOn();
        furnitureFactory2.createSofa().lieOn();
    }
}
