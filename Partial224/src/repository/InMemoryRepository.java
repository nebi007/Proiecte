package repository;

import domain.HasID;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InMemoryRepository<ID, E extends HasID<ID>> implements Repository<ID,E> {

    private Map<ID, E> entities;

    public InMemoryRepository() {
        this.entities = new HashMap<>();
    }

    protected E save(E entity) {
        if(entity == null)
            throw new IllegalArgumentException();
        return entities.putIfAbsent(entity.getID(),entity);
    }

    @Override
    public Collection<E> findAll() {
        return entities.values();
    }
}
