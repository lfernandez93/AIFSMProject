/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmproject;

import fsmproject.entitys.MID;
import fsmproject.entitys.Miner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Fernández <@lfernandez93>
 */
public class main {
    public static void main(String[] args) {
        Miner m=new Miner(MID.bobTheMiner);
        for(int i=0;i<50;i++){
        m.update();
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
