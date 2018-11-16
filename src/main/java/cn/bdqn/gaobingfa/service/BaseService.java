package cn.bdqn.gaobingfa.service;

import java.util.List;

public interface BaseService<T> {

    List<T> find();

    T insert(T t);

    T findone(long id);

   void delete(long id );

     T update(T t);

     long count();
}
