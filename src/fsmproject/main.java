/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmproject;

import fsmproject.entitys.Location;
import fsmproject.entitys.Miner;
import fsmproject.entitys.state.EnterMineAndDigForNugget;
import fsmproject.entitys.state.GoHomeAndSleepTillRested;

/**
 *
 * @author Luis Fernández <@lfernandez93>
 */
public class main {
    public static void main(String[] args) {
        Miner m=new Miner(10);
        m.setFatigue(0);
        m.setGoldCarried(0);
        m.setGoldInBank(0);
        m.setLocation(Location.SWEETHOME);
        m.setThirst(0);
        m.setCurrentState(GoHomeAndSleepTillRested.getInstance());
        m.ChangeState(EnterMineAndDigForNugget.getInstance());
        for(int i=0;i<15;i++){
        m.update();
        }
    }
}
