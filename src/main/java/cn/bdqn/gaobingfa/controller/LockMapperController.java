package cn.bdqn.gaobingfa.controller;

import cn.bdqn.gaobingfa.entity.LockMapper;
import cn.bdqn.gaobingfa.service.LockMapperService;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lock")
public class LockMapperController {

    private Log log= LogFactory.getLog(LockMapperController.class);

    @Autowired
    private LockMapperService lockMapperService;

    @RequestMapping("/insert")
    public int insert(LockMapper lockMapper) {
        log.error("********before******:"+lockMapper.getId());
        int i= lockMapperService.insert(lockMapper);
        log.error("*******after*******:"+lockMapper.getId());
        return i;
    }
    @RequestMapping("/delete")
    public int delete(int id) {
        return lockMapperService.delete(id);
    }

    @RequestMapping("/update")
    public int update(int id, String name) {
        return lockMapperService.update(id,name);
    }

    @RequestMapping("/findAll")
    public List<LockMapper> findAll() {
        return lockMapperService.findAll();
    }

    @RequestMapping("/find")
    public LockMapper find(int id) {
        return lockMapperService.find(id);
    }

}
