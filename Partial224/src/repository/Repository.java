package repository;


import domain.HasID;

import java.util.Collection;


public interface Repository<ID, T extends HasID<ID>>{
     Collection<T> findAll();
}