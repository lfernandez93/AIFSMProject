/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmproject.entitys.elsaStates;

import fsmproject.entitys.MinersWife;
import fsmproject.entitys.minerStates.StateInterface;

/**
 *
 * @author Luis Fernández <@lfernandez93>
 */
public class VisitBathRoom implements StateInterface<MinersWife> {

    private static VisitBathRoom _instance;

    private VisitBathRoom() {
    }

    public static VisitBathRoom getInstance() {
        if (_instance == null) {
            return new VisitBathRoom();
        }
        return _instance;
    }

    @Override
    public void enter(MinersWife entity) {
        System.err.println(entity.getmID() + ": My good i need go to the bathroom or i'm going to die!");
    }

    @Override
    public void execute(MinersWife entity) {
        System.err.println(entity.getmID() + ": Sweet, please do not disturb this moment");
        entity.getStateMachine().revertToPreviousState();
    }

    @Override
    public void exit(MinersWife entity) {
        System.err.println(entity.getmID() + ": Ready to keep doing housework!");
    }
}
