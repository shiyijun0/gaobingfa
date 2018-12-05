package cn.bdqn.gaobingfa.service;

import cn.bdqn.gaobingfa.Util.PageParams;
import cn.bdqn.gaobingfa.entity.BehaviorRecordSync;
import cn.bdqn.gaobingfa.mapper.BehaviorRecordSyncMapper;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class BehaviorRecordSyncMapperServiceImpl implements  BehaviorRecordSyncMapperService {

   @Autowired
   private BehaviorRecordSyncMapper behaviorRecordSyncMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return behaviorRecordSyncMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<BehaviorRecordSync> selectAll() {
        PageParams pageParams=new PageParams();
        pageParams.setLimit(20);
        pageParams.setStart(10);
       // PageHelper.offsetPage(30,15);
        RowBounds rowBounds=new RowBounds(0,200);//分页处理
        //PageHelper.startPage(2,12);
        BehaviorRecordSync behaviorRecordSync=new BehaviorRecordSync();
       // behaviorRecordSync.setCardStatus("XN0000214");
        behaviorRecordSync.setCardType("1");
        behaviorRecordSync.setCode("in");

        List<BehaviorRecordSync> list=behaviorRecordSyncMapper.selectAll(rowBounds,behaviorRecordSync);
        return list;
    }

    @Override
    public int insertSelective(BehaviorRecordSync record) {
        return behaviorRecordSyncMapper.insertSelective(record);
    }

    @Override
    public BehaviorRecordSync selectByPrimaryKey(Long id) {
        return behaviorRecordSyncMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BehaviorRecordSync record) {
        return behaviorRecordSyncMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Integer guardCount(String warrant) {
        return behaviorRecordSyncMapper.guardCount(warrant);
    }

    @Override
    @Transactional
    public int insert(BehaviorRecordSync behaviorRecordSync) {
        int i= behaviorRecordSyncMapper.insert(behaviorRecordSync);
        System.out.println("**********"+behaviorRecordSync.getId());
        return i+behaviorRecordSync.getId().intValue();
    }

    @Override
    public List<BehaviorRecordSync> select(BehaviorRecordSync record) {
        System.out.println("******执行代理去处理关系****");
        PageHelper.startPage(record.getPageParams().getStart(),record.getPageParams().getLimit());
        return behaviorRecordSyncMapper.select(record);
    }
}
