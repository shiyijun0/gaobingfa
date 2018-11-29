package cn.bdqn.gaobingfa.mapper;


import cn.bdqn.gaobingfa.entity.Role;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface RoleDao {
	
	
	public Role getRole(Long id);
	
	public int updateRole(Role role);
}
