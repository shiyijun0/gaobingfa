package cn.bdqn.gaobingfa.mapper;

import cn.bdqn.gaobingfa.entity.LockMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LockMapperMapper {
   // @Insert("insert into lock_mapper(name,age) values(#{name},#({age})")
    int insert(LockMapper lockMapper);
    @Delete("delete from lock_mapper  where id=#{id}")
    int delete(@Param("id") int id);
    @Update("update lock_mapper set name=#{name} where id=#{id}")
    int update(@Param("id") int id,@Param("name") String name);
    @Select("select * from lock_mapper")
    List<LockMapper> findAll();
    @Select("select * from lock_mapper where id=#{id}")
    LockMapper find(@Param("id") int id);

}
