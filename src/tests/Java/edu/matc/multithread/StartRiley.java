package edu.matc.multithread;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by netherskub on 11/29/16.
 */
public class StartRiley {
    private final Logger log = Logger.getLogger(this.getClass());
    @Test
    public void testThread() throws Exception {
        log.info("Test");
        RileyHome home = new RileyHome();
        Riley riley = new Riley(home);
        ChildGenerator childGen = new ChildGenerator(home);

        Thread rileyThread = new Thread(riley);
        Thread generatorThread = new Thread(childGen);
        rileyThread.start();
        generatorThread.start();
    }
}
