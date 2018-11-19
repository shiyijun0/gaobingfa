package cn.bdqn.gaobingfa.service;

import cn.bdqn.gaobingfa.entity.LockMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LockMapperService {

    int insert(LockMapper lockMapper);
    int delete(@Param("id") int id);
    int update(@Param("id") int id,@Param("name") String name);
    List<LockMapper> findAll();
    LockMapper find(@Param("id") int id);
}
