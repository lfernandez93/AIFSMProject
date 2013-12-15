/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmproject.entitys.state;

import fsmproject.entitys.Location;
import fsmproject.entitys.Miner;

/**
 *
 * @author Luis Fernández <@lfernandez93>
 */
public class QuenchThirst implements StateInterface {

    private static QuenchThirst _instance;

    private QuenchThirst() {
    }
    
    public static QuenchThirst getInstance(){
        if(_instance == null){
            return new QuenchThirst();
        }else{
            return _instance;
        }
    }
    @Override
    public void enter(Miner miner) {
        if (miner.getLocation() != Location.SALOON) {
            System.out.println("Hey You! Entering to the Salon to drink some water");
            miner.setLocation(Location.SALOON);
        }
    }

    @Override
    public void execute(Miner miner) {
        miner.decreaseThirst(1);
        System.out.println("Drinking some water thirst level=>"+miner.getThirst());
        if(!miner.isThirsty()){
            miner.ChangeState(EnterMineAndDigForNugget.getInstance());
        }else{
            execute(miner);
        }
    }

    @Override
    public void exit(Miner miner) {
        System.out.println("Hey You! leaving the saloon i'm ready to work");
    }
}
