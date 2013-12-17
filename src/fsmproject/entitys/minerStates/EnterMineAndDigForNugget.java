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
public class EnterMineAndDigForNugget implements StateInterface<Miner> {
    
    private static EnterMineAndDigForNugget _instance;
    
    private EnterMineAndDigForNugget() {
    }
    
    public static EnterMineAndDigForNugget getInstance() {
        if (_instance == null) {
            return new EnterMineAndDigForNugget();
        } else {
            return _instance;
        }
    }
    
    @Override
    public void enter(Miner miner) {
        if (miner.getLocation() != Location.GOLDMINE) {
            System.out.println("Hey YAA! Miner " + miner.getmID() + " Walking to the gold mine");
            miner.setLocation(Location.GOLDMINE);
        }
    }
    
    @Override
    public void execute(Miner miner) {
        //the miner starts digging for gold what will result in 
        //increasing the amount of gold he has.
        miner.increaseGoldCarried(1);
        //this will result in getting tired.
        miner.increaseFatigue(1);
        System.out.println(miner.getmID()+": Mining at the mine making myself rich");
        //if pocket full go and save your gold at bank.
        if(miner.isPocketFull()){
            miner.getStateMachine().changeState(VisitBankAndDepositGold.getInstance());
        }
        //if thirsty go to the salon for some water.
        if(miner.isThirsty()){
            miner.getStateMachine().changeState(QuenchThirst.getInstance());
        }
        /*if(!miner.isPocketFull() && !miner.isThirsty()){

            execute(miner);
        }*/
    }
    
    @Override
    public void exit(Miner miner) {
        System.out.println("HEY Yaah! Miner "+miner.getmID()+" leaving the mine full of gold =>"+miner.getGoldCarried());
    }
}
