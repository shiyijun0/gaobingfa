package cn.bdqn.gaobingfa.controller;

import java.util.List;

public interface BaseController<T> {

    List<T> find();

    T insert(T t);

    T findone(long id);

    int delete(long id );

    T update(T t);

    long count();
}
