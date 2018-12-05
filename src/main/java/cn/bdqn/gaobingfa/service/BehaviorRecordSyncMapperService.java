package cn.bdqn.gaobingfa.service;

import cn.bdqn.gaobingfa.annotation.PrivilegeInfo;
import cn.bdqn.gaobingfa.entity.BehaviorRecordSync;

import java.util.List;

public interface BehaviorRecordSyncMapperService {

    int deleteByPrimaryKey(Long id);

    List<BehaviorRecordSync> selectAll();

    int insertSelective(BehaviorRecordSync record);

    BehaviorRecordSync selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BehaviorRecordSync record);
    // 添加订单
    @PrivilegeInfo("生成订单")
    List<BehaviorRecordSync> select(BehaviorRecordSync record);

    //获取门禁抓怕次数
    Integer guardCount(String warrant);

    int insert(BehaviorRecordSync behaviorRecordSync);
}
