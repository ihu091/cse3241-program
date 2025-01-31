package Entities;

import java.util.Collection;

public interface IEntity<T> {
    void add(T newEntity);

    void delete(T entity);

    void update(T entity);

    T findById(int id);

    Collection<T> getAll();
}
