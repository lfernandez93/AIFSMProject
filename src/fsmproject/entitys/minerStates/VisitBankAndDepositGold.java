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
public class VisitBankAndDepositGold implements StateInterface<Miner> {

    private static VisitBankAndDepositGold _instance;

    private VisitBankAndDepositGold() {
    }

    public static VisitBankAndDepositGold getInstance() {
        if (_instance == null) {
            return new VisitBankAndDepositGold();
        
        }else{
            return _instance;
        }
    }

    @Override
    public void enter(Miner miner) {
        if (miner.getLocation() != Location.BANK) {
            System.out.println("HEY You! Entering the bank to deposit my gold >"+miner.getGoldCarried());
            miner.setLocation(Location.BANK);
        }
    }

    @Override
    public void execute(Miner miner) {
        //first deposit the gold in the bank
        miner.depositGold(miner.getGoldCarried());
        miner.setGoldCarried(0);
        //if not tired keep working
        if (!miner.isTired()) {
            miner.getStateMachine().changeState(EnterMineAndDigForNugget.getInstance());
        } else {
            miner.getStateMachine().changeState(GoHomeAndSleepTillRested.getInstance());
        }
    }

    @Override
    public void exit(Miner miner) {
        System.out.println("Hey You! leaving the Bank! now i have "+miner.getGoldInBank());
    }
}
