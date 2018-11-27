package cn.bdqn.gaobingfa.mapper;

import cn.bdqn.gaobingfa.entity.BehaviorRecordSync;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface BehaviorRecordSyncMapper {

    int deleteByPrimaryKey(Long id);

    List<BehaviorRecordSync> selectAll(RowBounds rowBounds,BehaviorRecordSync behaviorRecordSync);

    int insertSelective(BehaviorRecordSync record);

    BehaviorRecordSync selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BehaviorRecordSync record);


    //获取门禁抓怕次数
    @Select("select count(*) from behavior_record_sync where warrant <> #{warrant}")
    Integer guardCount(@Param("warrant") String warrant);

    int insert(BehaviorRecordSync behaviorRecordSync);

    List<BehaviorRecordSync> select(BehaviorRecordSync record);




}
