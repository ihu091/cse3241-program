package Entities;

import java.util.ArrayList;
import Models.InventoryModel;

public class InventoryEntity implements IEntity<InventoryModel> {
    private ArrayList<InventoryModel> tuples;

    public InventoryEntity() {
        tuples = new ArrayList<>();
    }

    public InventoryEntity(ArrayList<InventoryModel> data) {
        tuples = new ArrayList<>(data);
    }

    public void add(InventoryModel newEntity) {
        tuples.add(newEntity);
    }

    public void delete(InventoryModel entity) {
        if (tuples.contains(entity)) {
            tuples.remove(entity);
        }
    }

    public void update(InventoryModel entity) {
        for (int i = 0; i < tuples.size(); i++) {
            InventoryModel existingEntity = tuples.get(i);
            if (existingEntity.RentalID == entity.RentalID) {
                tuples.set(i, entity);
                return;
            }
        }
    }

    public InventoryModel findById(int id) {
        for (InventoryModel entity : tuples) {
            if (entity.RentalID == id) {
                return entity;
            }
        }
        return null;
    }

    public ArrayList<InventoryModel> getAll() {
        return tuples;
    }
}
