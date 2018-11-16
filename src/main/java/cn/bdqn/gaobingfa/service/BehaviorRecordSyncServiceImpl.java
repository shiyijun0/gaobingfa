package cn.bdqn.gaobingfa.service;

import cn.bdqn.gaobingfa.dao.BehaviorRecordSyncDao;
import cn.bdqn.gaobingfa.entity.BehaviorRecordSync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
public class BehaviorRecordSyncServiceImpl implements BaseService<BehaviorRecordSync> {

    @Autowired
    private BehaviorRecordSyncDao behaviorRecordSyncDao;
    @Override
    public List<BehaviorRecordSync> find() {
        return behaviorRecordSyncDao.findAll();
    }

    @Override
    public BehaviorRecordSync insert(BehaviorRecordSync behaviorRecordSync) {
        return behaviorRecordSyncDao.save(behaviorRecordSync);
    }

    @Override
    public BehaviorRecordSync findone(long id) throws EntityNotFoundException {
        return behaviorRecordSyncDao.getOne(id);
    }

    @Override
    public void delete(long id) {
             behaviorRecordSyncDao.deleteById(id);
    }

    @Override
    public BehaviorRecordSync update(BehaviorRecordSync behaviorRecordSync) {
        return behaviorRecordSyncDao.saveAndFlush(behaviorRecordSync);
    }

    @Override
    public long count() {
        return behaviorRecordSyncDao.count();
    }
}
