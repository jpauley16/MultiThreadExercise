package edu.matc.multithread;

import org.apache.log4j.Logger;
/**
 * Created by netherskub on 11/29/16.
 */
public class Riley implements Runnable {

    private final Logger log = Logger.getLogger(this.getClass());
    RileyHome home;

    public Riley(RileyHome home)
    {
        this.home = home;
    }
    public void run()
    {
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        log.info("Riley started..");
        while(true)
        {
            home.giveCandy();
        }
    }
}

