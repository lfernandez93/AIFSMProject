/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmproject.entitys.minerStates;

import fsmproject.entitys.Miner;

/**
 *
 * @author Luis Fernández <@lfernandez93>
 */
public interface StateInterface<T> {
    //executed when the state is entered
    public void enter(T entity);
    //called by the miner update method
    public void execute(T entity);
    //this will be executed when the miner requires to exit from the state
    public void exit(T entity);
}
