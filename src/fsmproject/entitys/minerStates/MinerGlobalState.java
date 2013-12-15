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
public class MinerGlobalState implements StateInterface<Miner> {

    private static MinerGlobalState _instance;

    private MinerGlobalState() {
    }

    public static MinerGlobalState getInstance() {
        if (_instance == null) {
            return new MinerGlobalState();
        } else {
            return _instance;
        }
    }

    @Override
    public void enter(Miner entity) {
    }

    @Override
    public void execute(Miner entity) {
    }

    @Override
    public void exit(Miner entity) {
    }
}
