/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmproject.entitys.minerStates;

import fsmproject.entitys.Location;
import fsmproject.entitys.Miner;

/**
 *
 * @author Luis Fernández <@lfernandez93>
 */
public class GoHomeAndSleepTillRested implements StateInterface<Miner> {

    private static GoHomeAndSleepTillRested _instance;

    private GoHomeAndSleepTillRested() {
    }

    public static GoHomeAndSleepTillRested getInstance(){
        if(_instance == null){
            return new GoHomeAndSleepTillRested();
        }else{
            return _instance;
        }
    }
    @Override
    public void enter(Miner miner) {
        if (miner.getLocation() != Location.SWEETHOME) {
            System.out.println("I'm going home tired as hell");
            miner.setLocation(Location.SWEETHOME);
        }
    }

    @Override
    public void execute(Miner miner) {
        miner.decreaseFatigue(10);
        System.out.println("ZZZ! rest lvl=>"+miner.getFatigue());
        if (!miner.isTired()) {
            miner.getStateMachine().changeState(EnterMineAndDigForNugget.getInstance());
        }else{
          // execute(miner);
        }
    }

    @Override
    public void exit(Miner miner) {
        System.out.println("rested a lot, back to work!");
    }
}
