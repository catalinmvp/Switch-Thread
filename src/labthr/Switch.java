/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labthr;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author andrei.nichita0308
 */
public class Switch {

    public static Switch instance = null;
    private static BlockingQueue<Message> switchque = null;

    private Switch() {
    }

    public static Switch getInstance() {
        if (instance == null) {
            instance = new Switch();
        }
        return instance;
    }

    private void compose() {
        if (switchque == null) {
            switchque = new LinkedBlockingQueue<Message>();
            SwitchProcesor switchproc = new SwitchProcesor();
            switchproc.start();
        }
    }

    public void putMsg(Message msg) {
        try {
            compose();
            switchque.put(msg);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    class SwitchProcesor extends Thread {
        @Override
        public void run() {
            for (;;) {
                Message msg = null;
                try {
                    msg = switchque.take();
                    System.out.println(msg.getContent());
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
