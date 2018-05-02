package study.apach.model.repositories;

import java.util.Collection;

public interface CrudRepository<T, ID> {

    Collection<T> findAll();
    T findOne(ID id);
    void save(T entity);
    void delete(ID id);

}
