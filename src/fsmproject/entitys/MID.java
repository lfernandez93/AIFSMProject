/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmproject.entitys;

/**
 *
 * @author Luis Fernández <@lfernandez93>
 */
public enum MID {

    bobTheMiner(0), elsaTheWife(1);
    int id;

    MID(int id) {
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        String name = "";
        switch (id) {
            case 0:
                name = "Bob The Miner";
                break;
            case 1:
                name = "Elsa The Wife";
                break;
        }
        return name;
    }
}
