/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmproject.entitys;

import java.util.HashMap;

/**
 * this class store all the existing entities in our world 
 * in order to manage the messages they send.
 * @author Luis Fernández <@lfernandez93>
 */
public class EntityManager {

    private HashMap<Integer, BaseGameEntity> entityMap;
    private static EntityManager _instance;

    private EntityManager() {
        this.entityMap = new HashMap<>();
    }

    /**
     *  return the instance of the EntityManager class
     * @return
     */
    public static EntityManager getInstance() {
        if (_instance == null) {
            return new EntityManager();
        }
        return _instance;
    }

    /**
     * register an entity in the database map
     * @param entity
     */
    public void registerEntity(BaseGameEntity entity) {
        entityMap.put(entity.getId(), entity);
    }

    /**
     * search for an entity in the database map
     * @param id
     * @return
     */
    public BaseGameEntity getEntityFromId(int id) {
        BaseGameEntity desiredEntity;
        desiredEntity = entityMap.get(id);
        if (desiredEntity == null) {
            System.err.println("ID not found");
        }
        return desiredEntity;
    }

    /**
     * delete an entity from the database map
     * @param entity
     */
    public void removeEntity(BaseGameEntity entity) {
        entityMap.remove(entityMap.get(entity.getId()));

    }
}
