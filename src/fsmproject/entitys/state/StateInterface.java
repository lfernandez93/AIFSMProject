/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmproject.entitys.state;

import fsmproject.entitys.Miner;

/**
 *
 * @author Luis Fernández <@lfernandez93>
 */
public interface StateInterface {
    //executed when the state is entered
    public void enter(Miner miner);
    //called by the miner update method
    public void execute(Miner miner);
    //this will be executed when the miner requires to exit from the state
    public void exit(Miner miner);
}
