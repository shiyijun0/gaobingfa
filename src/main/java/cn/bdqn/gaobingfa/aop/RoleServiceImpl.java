package cn.bdqn.gaobingfa.aop;

import cn.bdqn.gaobingfa.entity.User;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public void print(User user) {
        System.out.println("********"+user.getName());
    }
}
