package Entities;

import java.util.ArrayList;
import Models.MemberModel;

public class MemberEntity implements IEntity<MemberModel> {
    private ArrayList<MemberModel> tuples;

    public MemberEntity() {
        tuples = new ArrayList<MemberModel>();
    }

    public void add(MemberModel newEntity) {
        tuples.add(newEntity);
    }

    public void delete(MemberModel entity) {
        if (tuples.contains(entity)) {
            tuples.remove(entity);
        }
    }

    public void update(MemberModel entity) {
        for (int i = 0; i < tuples.size(); i++) {
            MemberModel existingEntity = tuples.get(i);
            if (existingEntity.MemberID == entity.MemberID) {
                tuples.set(i, entity);
                return;
            }
        }
    }

    public MemberModel findById(int id) {
        for (MemberModel entity : tuples) {
            if (entity.MemberID == id) {
                return entity;
            }
        }
        return null;
    }

    public ArrayList<MemberModel> getAll() {
        return tuples;
    }
}
