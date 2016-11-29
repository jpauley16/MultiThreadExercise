package edu.matc.multithread;

/**
 * Created by netherskub on 11/29/16.
 */
public class StartRiley {
    public static void main(String a[])
    {
        RileyHome home = new RileyHome();

        Riley riley = new Riley(home);
        ChildGenerator cg = new ChildGenerator(home);

        Thread host = new Thread(riley);
        Thread thcg = new Thread(cg);
        thcg.start();
        host.start();
    }
}
