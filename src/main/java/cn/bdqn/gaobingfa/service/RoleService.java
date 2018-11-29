package cn.bdqn.gaobingfa.service;

import cn.bdqn.gaobingfa.entity.Role;
import cn.bdqn.gaobingfa.entity.User;

import java.util.List;


public interface RoleService {

	void print(User user);
	public Role getRole(Long id);
	
	public int updateRole(Role role);
	
	public int updateRoleArr(List<Role> roleList);
	
}
