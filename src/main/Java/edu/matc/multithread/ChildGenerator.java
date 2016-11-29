package edu.matc.multithread;

import java.util.concurrent.TimeUnit;
/**
 * Created by netherskub on 11/29/16.
 */
public class ChildGenerator implements Runnable {

    RileyHome home;

    public ChildGenerator(RileyHome home)
    {
        this.home = home;
    }

    public void run()
    {
        while(true)
        {
            Child child = new Child(home);
            Thread theChild = new Thread(child);
            child.setName("edu.matc.multithread.Child "+ theChild.getId());
            theChild.start();

            try
            {
                TimeUnit.SECONDS.sleep((long)(Math.random()*10));
            }
            catch(InterruptedException iex)
            {
                iex.printStackTrace();
            }
        }
    }
}
