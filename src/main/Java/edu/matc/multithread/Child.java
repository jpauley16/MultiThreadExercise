package edu.matc.multithread;

/**
 * Created by netherskub on 11/29/16.
 */
public class Child implements Runnable {

    String name;

    RileyHome home;

    public Child(RileyHome home)
    {
        this.home = home;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run()
    {
        goForCandy();
    }
    private synchronized void goForCandy()
    {
        home.add(this);
    }
}
