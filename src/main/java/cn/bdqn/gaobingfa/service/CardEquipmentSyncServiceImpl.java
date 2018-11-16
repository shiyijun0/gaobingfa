package cn.bdqn.gaobingfa.service;

import cn.bdqn.gaobingfa.dao.CardEquipmentSyncDao;
import cn.bdqn.gaobingfa.entity.CardEquipmentSync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CardEquipmentSyncServiceImpl implements BaseService<CardEquipmentSync> {

    @Autowired
    private CardEquipmentSyncDao cardEquipmentSyncDao;

    @Override
    public List<CardEquipmentSync> find() {
        return cardEquipmentSyncDao.findAll();
    }

    @Override
    public CardEquipmentSync insert(CardEquipmentSync cardEquipmentSync) {
        return cardEquipmentSyncDao.save(cardEquipmentSync);
    }

    @Override
    public CardEquipmentSync findone(long id) {
        return cardEquipmentSyncDao.getOne(id);
    }

    @Override
    public void delete(long id) {
        cardEquipmentSyncDao.deleteById(id);
    }

    @Override
    public long count() {
        return cardEquipmentSyncDao.count();
    }

    @Override
    public CardEquipmentSync update(CardEquipmentSync cardEquipmentSync) {
        return cardEquipmentSyncDao.saveAndFlush(cardEquipmentSync);
    }
}
