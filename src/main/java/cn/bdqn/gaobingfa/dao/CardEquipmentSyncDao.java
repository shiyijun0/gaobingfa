package cn.bdqn.gaobingfa.dao;

import cn.bdqn.gaobingfa.entity.CardEquipmentSync;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardEquipmentSyncDao extends JpaRepository<CardEquipmentSync,Long> {//,CrudRepository<CardEquipmentSync,Long>
}
