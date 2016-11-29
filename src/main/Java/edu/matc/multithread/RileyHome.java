package edu.matc.multithread;

import java.util.List;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

/**
 * Created by netherskub on 11/29/16.
 */
public class RileyHome {

    int numberOfChildren;
    List<Child> listChild;
    private final Logger log = Logger.getLogger(this.getClass());


    public RileyHome() {

        numberOfChildren = 10;
        listChild = new LinkedList<Child>();

    }

    public void giveCandy() {

        Child child;

        synchronized (listChild) {

            while (listChild.size() == 0) {
                log.info("Riley watches TV");
                try {
                    listChild.wait();
                } catch (InterruptedException iex) {
                    iex.printStackTrace();
                }
            }
            log.info("Riley hears doorbell " );
            child = (Child) ((LinkedList<?>) listChild).poll();

        }
        long duration = 0;
        try {
            log.info("Riley opens a door for : " + child.getName());
            duration = (long)(Math.random()*10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException iex) {
            iex.printStackTrace();
        }
        log.info("Riley gives candy : " + child.getName());
    }

    public void add(Child child) {
        log.info(child.getName() + " arrives at the door." + child.getArriveTime());

        synchronized (listChild) {
            if (listChild.size() == numberOfChildren) {
                log.info("Line is too big for  " + child.getName());
                log.info(child.getName() + " leaves.");
                return;
            }

            ((LinkedList<Child>) listChild).offer(child);
            log.info(child.getName() + " gets candy.");

            if (listChild.size() == 1)
                listChild.notify();
        }
    }

}
