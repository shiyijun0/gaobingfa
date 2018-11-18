package cn.bdqn.gaobingfa.service;

import cn.bdqn.gaobingfa.entity.BehaviorRecordSync;

import java.util.List;

public interface BehaviorRecordSyncMapperService {

    int deleteByPrimaryKey(Long id);

    List<BehaviorRecordSync> selectAll();

    int insertSelective(BehaviorRecordSync record);

    BehaviorRecordSync selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BehaviorRecordSync record);


    //获取门禁抓怕次数
    Integer guardCount(String warrant);

    int insert(BehaviorRecordSync behaviorRecordSync);
}
