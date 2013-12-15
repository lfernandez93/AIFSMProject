/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmproject.entitys;

/**
 *
 * @author Luis Fernández <@lfernandez93>
 */
abstract class BaseGameEntity {

    //every entity has an ID number.
    private int mID;
    //this ID is changed every time a entity is instantiated
    private static int nextValidID;

    public BaseGameEntity(int mID) {
        setmID(mID);
    }
    abstract public void update();
    //this is called within the constructor and it validates that
    //the id passed is greater or equal to the existing one, begore 
    //setting the ID and incrementing the next validID

    public void setmID(int mID) {
        this.mID = mID;
    }

    public int getmID() {
        return mID;
    }
}
