package edu.matc.multithread;

import org.apache.log4j.Logger;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 * Created by netherskub on 11/29/16.
 */
public class ChildGenerator implements Runnable {

    private final Logger log = Logger.getLogger(this.getClass());
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
            log.info("Child generated.");
            child.setArriveTime(new Date());
            Thread theChild = new Thread(child);
            child.setName("Child "+ theChild.getId());
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
