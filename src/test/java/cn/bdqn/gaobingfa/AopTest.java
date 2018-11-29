package cn.bdqn.gaobingfa;


import cn.bdqn.gaobingfa.entity.User;
import cn.bdqn.gaobingfa.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void contextLoads() throws InterruptedException {
        User user=new User();
        user.setName("史蒂夫");
        roleService.print(user);
    }
}
