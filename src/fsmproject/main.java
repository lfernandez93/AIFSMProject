/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmproject;

import fsmproject.entitys.EntityManager;
import fsmproject.entitys.MID;
import fsmproject.entitys.Miner;
import fsmproject.entitys.MinersWife;

/**
 *
 * @author Luis Fernández <@lfernandez93>
 */
public class main {
    public static void main(String[] args) {
        EntityManager entityManager = EntityManager.getInstance();
        Miner m=new Miner(MID.bobTheMiner);
        MinersWife mW=new MinersWife(MID.elsaTheWife);
        entityManager.registerEntity(m);
        entityManager.registerEntity(mW);
        String[] asd=new String[]{null,null};
        System.out.println(asd[0]);
        for(int i=0;i<25;i++){
        m.update();
        mW.update();
//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }
}
