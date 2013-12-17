/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmproject.entitys;

import fsmproject.entitys.elsaStates.DoHouseWork;
import fsmproject.entitys.elsaStates.WifeGlobalState;

/**
 *
 * @author Luis Fernández <@lfernandez93>
 */
public class MinersWife extends BaseGameEntity {

    //wifes location, usually at the house cleaning.
    private Location location;
    //instance the StateMachine
    private StateMachine<MinersWife> stateMachine;
    
    public Location getLocation() {
        return location;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }
    
    public StateMachine<MinersWife> getStateMachine() {
        return stateMachine;
    }
    
    public void setStateMachine(StateMachine<MinersWife> stateMachine) {
        this.stateMachine = stateMachine;
    }
    
    public MinersWife(MID mID) {
        super(mID);
        setLocation(location.SWEETHOME);
        stateMachine = new StateMachine<>(this);
        stateMachine.setCurrentState(DoHouseWork.getInstance());
        stateMachine.setGlobalState(WifeGlobalState.getInstance());
    }
    
    @Override
    public void update() {
        getStateMachine().update();
    }
}
