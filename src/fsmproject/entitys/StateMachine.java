/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmproject.entitys;

import fsmproject.entitys.minerStates.StateInterface;

/**
 *
 * @author Luis Fernández <@lfernandez93>
 */
public class StateMachine<T> {

    private T owner;
    private StateInterface<T> currentState;
    private StateInterface<T> previousState;
    private StateInterface<T> globalState;

    public StateMachine(T owner) {
        setOwner(owner);
        setCurrentState(null);
        setGlobalState(null);
        setPreviousState(null);
    }

    public void update() {
        if (getGlobalState() != null) {
            getGlobalState().execute(getOwner());
        }
        if (getCurrentState() != null) {

            getCurrentState().execute(getOwner());
        }

    }

    public void changeState(StateInterface<T> newState) {
        //record the previous state
        setPreviousState(getCurrentState());
        //exit from the current state
        getCurrentState().exit(getOwner());
        //set the new current state
        setCurrentState(newState);
        //enter in the new state
        getCurrentState().enter(getOwner());
    }

    public boolean isInState(StateInterface<T> state) {
        if (getCurrentState() != state) {
            return false;
        }
        return true;
    }

    public void revertToPreviousState() {
        changeState(getPreviousState());
    }

    public T getOwner() {
        return owner;
    }

    public void setOwner(T owner) {
        this.owner = owner;
    }

    public StateInterface<T> getCurrentState() {
        return currentState;
    }

    public void setCurrentState(StateInterface<T> currentState) {
        this.currentState = currentState;
    }

    public StateInterface<T> getPreviousState() {
        return previousState;
    }

    public void setPreviousState(StateInterface<T> previousState) {
        this.previousState = previousState;
    }

    public StateInterface<T> getGlobalState() {
        return globalState;
    }

    public void setGlobalState(StateInterface<T> globalState) {
        this.globalState = globalState;
    }
}
