package cn.bdqn.gaobingfa.service.redPacket.impl;

import cn.bdqn.gaobingfa.entity.RedPacket;
import cn.bdqn.gaobingfa.mapper.RedPacketMapper;
import cn.bdqn.gaobingfa.service.redPacket.RedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Service
public class RedPacketServiceImpl implements RedPacketService {

	@Autowired
	private RedPacketMapper  redPacketDao = null;

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public RedPacket getRedPacket(Long id) {
		return redPacketDao.getRedPacket(id);
	}

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public int decreaseRedPacket(Long id) {
		return redPacketDao.decreaseRedPacket(id);
	}

}