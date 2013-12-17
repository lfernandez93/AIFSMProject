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
public class DoHouseWork implements StateInterface<MinersWife> {

    private static DoHouseWork _instance;

    private DoHouseWork() {
    }

    public static DoHouseWork getInstance() {
        if (_instance == null) {
            return new DoHouseWork();
        }
        return _instance;
    }

    @Override
    public void enter(MinersWife entity) {
    }

    @Override
    public void execute(MinersWife entity) {
        Random r = new Random();
        int n = r.nextInt(2);
        switch (n) {
            case 0:
                System.err.println(entity.getmID() + ": Mopping the floor!");
                break;
            case 1:
                System.err.println(entity.getmID() + ": Washing the dishes");
                break;
            case 2:
                System.err.println(entity.getmID() + ": Making the bed");
                break;
        }
    }

    @Override
    public void exit(MinersWife entity) {
    }
}
