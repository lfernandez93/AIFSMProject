/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmproject.entitys.elsaStates;

import fsmproject.entitys.MinersWife;
import fsmproject.entitys.minerStates.StateInterface;
import java.util.Random;

/**
 *
 * @author Luis Fernández <@lfernandez93>
 */
public class WifeGlobalState implements StateInterface<MinersWife> {

    private static WifeGlobalState _instance;

    private WifeGlobalState() {
    }

    public static WifeGlobalState getInstance() {
        if (_instance == null) {
            return new WifeGlobalState();
        }
        return _instance;
    }

    @Override
    public void enter(MinersWife entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void execute(MinersWife entity) {
        Random r = new Random();

        if (r.nextFloat() < 0.1) {
            entity.getStateMachine().changeState(VisitBathRoom.getInstance());
        }
    }

    @Override
    public void exit(MinersWife entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
