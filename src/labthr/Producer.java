/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labthr;

import java.util.Random;

/**
 *
 * @author andrei.nichita0308
 */
public class Producer {
    
public static void main(String arg[]) { 
   try { 
       Message msg = null; 
       Random r = new Random();
       for (int i = 0; i < 100; i++)
       { 
           msg = new Message(); 
           msg.setContent("MAC " + r.nextInt(10) +":");  
           System.out.println("Message to be delivered has the MAC " + msg.getContent());
           Switch.getInstance().putMsg(msg);
           Thread.sleep(100); 
       } 
   } 
   catch (InterruptedException e) 
   { 
       e.printStackTrace(); 
    } 
}
}