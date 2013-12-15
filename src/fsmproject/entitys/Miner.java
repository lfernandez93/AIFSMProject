/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmproject.entitys;

import fsmproject.entitys.minerStates.GoHomeAndSleepTillRested;
import fsmproject.entitys.minerStates.MinerGlobalState;
import fsmproject.entitys.minerStates.StateInterface;

/**
 *
 * @author Luis Fernández <@lfernandez93>
 */
public class Miner extends BaseGameEntity {
    //state machine instance

    private StateMachine<Miner> stateMachine;
    //global state
    private StateInterface globalState;
    //previous state
    private StateInterface previousState;
    //current state
    private StateInterface currentState;
    //miner's current location
    private Location location;
    //amount of gold carried by the miner.
    private int goldCarried;
    //gold carried in the bank.
    private int goldInBank;
    //if the value if higher the miner is thirstier.
    private int thirst;
    //if the value is higher the miner is more tired.
    private int fatigue;
    //this value if to set how much money does the 
    //miner can carry.
    private final int GOLDPERMITED = 18;
    private final int MAXTHIRST = 10;
    private final int MAXFATIGUE = 20;
    private final int MINGOLD = 0;
    private final int MINTHIRST = 0;
    private final int MINFATIGUE = 0;

    public Miner(MID mID) {
        super(mID);
        setLocation(location.BANK);
        setGoldCarried(0);
        setGoldInBank(0);
        setThirst(0);
        setFatigue(0);
        stateMachine = new StateMachine<>(this);
        stateMachine.setCurrentState(GoHomeAndSleepTillRested.getInstance());
        stateMachine.setGlobalState(MinerGlobalState.getInstance());
    }
 
    
    public void changeState(StateInterface newState) {
        //assert the states are different
        if (getCurrentState() != newState) {
            //exit from the current state.
            if(getCurrentState()!=null){
            getCurrentState().exit(this);
            }
            //set the new state.
            currentState = newState;
            //enter to the new state.
            getCurrentState().enter(this);
        }
    }

    @Override
    public void update() {
        ++thirst;
        getStateMachine().update();
    }

    public StateMachine<Miner> getStateMachine() {
        return stateMachine;
    }

    public void setStateMachine(StateMachine<Miner> stateMachine) {
        this.stateMachine = stateMachine;
    }

    public StateInterface getGlobalState() {
        return globalState;
    }

    public void setGlobalState(StateInterface globalState) {
        this.globalState = globalState;
    }

    public StateInterface getPreviousState() {
        return previousState;
    }

    public void setPreviousState(StateInterface previousState) {
        this.previousState = previousState;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getGoldCarried() {
        return goldCarried;
    }

    public void setGoldCarried(int goldCarried) {
        this.goldCarried = goldCarried;
    }

    public int getGoldInBank() {
        return goldInBank;
    }

    public void setGoldInBank(int goldInBank) {
        this.goldInBank = goldInBank;
    }

    public int getThirst() {
        return thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public int getFatigue() {
        return fatigue;
    }

    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }

    public void increaseGoldCarried(int unit) {
        goldCarried = goldCarried + unit;
    }

    public void increaseFatigue(int unit) {
        fatigue = fatigue + unit;
    }

    public StateInterface getCurrentState() {
 
        return currentState;
        
    }

    public void setCurrentState(StateInterface state) {
        currentState = state;
    }

    public void depositGold(int amount) {
        
        goldInBank = goldInBank + amount;
    }

    public boolean isPocketFull() {
        if (getGoldCarried() >= GOLDPERMITED) {
            return true;
        }
        return false;
    }

    public boolean isThirsty() {
        if (getThirst() >= MAXTHIRST) {
            return true;
        }
        return false;
    }

    public boolean isTired() {
        if (getFatigue() >= MAXFATIGUE) {
            return true;
        }
        return false;
    }

    public void decreaseThirst(int unit) {
        if(thirst!=0){
        thirst = thirst - unit;
        }
    }

    public void decreaseFatigue(int unit) {
        if(fatigue!=0){
        fatigue = fatigue - unit;
        }
    }

    @Override
    public String toString() {
        return "Miner{" +this.getmID()+ '}';
    }
    
    
}
