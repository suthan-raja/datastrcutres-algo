package com.data.algo.design.structural;

interface Image {
    void display();
}

class RealImage implements Image {
    private String fileName;

    RealImage(String fileName) {
        this.fileName = fileName;
    }

    private void loadFromDisk() {
        System.out.println("Loading " + fileName + " from disk...");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

class ProxyImage implements Image {
    private String fileName;
    RealImage image;
    ProxyImage(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public void display() {
        if(image == null) {
            image = new RealImage(fileName);
        }
        image.display();
    }
}

class SecureProxy implements Image {
    private String fileName;
    private boolean hasAccess;
    private RealImage image;
    SecureProxy(String fileName, boolean hasAccess) {
        this.fileName = fileName;
        this.hasAccess = hasAccess;
    }

    @Override
    public void display() {
        if(hasAccess){
            if(image == null) {
                image = new RealImage(fileName);
            }
            image.display();
        }else{
            System.out.println("Access Denied: You can’t view this image.");
        }
    }
}

public class ProxyPattern {
    public static void main(String[] args) {
        Image img1 = new ProxyImage("photo1.jpg");
        Image img2 = new ProxyImage("photo2.jpg");

        // Images are not loaded yet

        img1.display(); // Loads + Displays
        img1.display(); // Just Displays (no loading)

        img2.display(); // Loads + Displays
    }
}
