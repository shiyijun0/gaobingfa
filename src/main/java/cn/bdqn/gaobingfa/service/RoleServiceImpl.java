package cn.bdqn.gaobingfa.service;

import cn.bdqn.gaobingfa.entity.Role;
import cn.bdqn.gaobingfa.entity.User;
import cn.bdqn.gaobingfa.mapper.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao ;
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Role getRole(Long id) {
		return roleDao.getRole(id);
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public int updateRole(Role role) {
		return roleDao.updateRole(role);
	}

	
	@Override
	public int updateRoleArr(List<Role> roleArr) {
		int count = 0;
		for (Role role : roleArr) {
			count += this.updateRole(role);
		}
		return count;
	}
	@Override
	public void print(User user) {
		System.out.println("********"+user.getName());
	}

}
