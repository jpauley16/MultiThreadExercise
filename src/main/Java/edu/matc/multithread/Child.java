package edu.matc.multithread;

import java.util.Date;

/**
 * Created by netherskub on 11/29/16.
 */
public class Child implements Runnable {

    private String name;
    private Date arriveTime;

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

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public void run()
    {
        getCandy();
    }
    private synchronized void getCandy()
    {
        home.add(this);
    }
}
