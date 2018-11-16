package cn.bdqn.gaobingfa.dao;

import cn.bdqn.gaobingfa.entity.BehaviorRecordSync;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BehaviorRecordSyncDao extends JpaRepository<BehaviorRecordSync,Long> {//CrudRepository<BehaviorRecordSync,Long>,

}
