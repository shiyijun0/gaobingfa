package cn.bdqn.gaobingfa.service;

import cn.bdqn.gaobingfa.entity.LockMapper;
import cn.bdqn.gaobingfa.mapper.LockMapperMapper;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LockMapperServiceImpl implements LockMapperService {

    private Log log= LogFactory.getLog(LockMapperServiceImpl.class);

    @Autowired
    private LockMapperMapper lockMapperMapper;

    /**
     * @CachePut 应用到写数据的方法上，如新增/修改方法，调用方法时会自动把相应的数据放入缓存
     * @param lockMapper
     * @return
     */
    @CachePut(value = "lockMapper", key = "#root.targetClass + #lockMapper.name", unless = "#lockMapper eq null")
   // @CachePut(value = "lockMapper", key = "#lockMapper.id", unless = "#result eq 0")
    @Override
    //@Transactional
    public int insert(LockMapper lockMapper) {
        log.error("******更新前****"+lockMapper);
        int i= lockMapperMapper.insert(lockMapper);
        log.error("******更新后****"+lockMapper);
        return i;
    }

    /**
     * @CacheEvict 应用到删除数据的方法上，调用方法时会从缓存中删除对应key的数据
     * @param id
     * @return
     */
    @CacheEvict(value = "lockMapper", key = "#p0", condition = "#result gt 0")
    @Override
   // @Transactional
    public int delete(int id) {
        return lockMapperMapper.delete(id);
    }


    /**
     * @CachePut 应用到写数据的方法上，如新增/修改方法，调用方法时会自动把相应的数据放入缓存
     * @param name
     * @return
     */
    @CachePut(value = "lockMapper", key = "#root.targetClass + #name", unless = "#result eq 0")
   // @CachePut(value = "lockMapper", key = "#p0", unless = "#result eq 0")
    @Override
    //@Transactional
    public int update(int id, String name) {
        return lockMapperMapper.update(id,name);
    }

    @Override
    public List<LockMapper> findAll() {
        return lockMapperMapper.findAll();
    }

    /**
     * @Cacheable 应用到读取数据的方法上，先从缓存中读取，如果没有再从DB获取数据，然后把数据添加到缓存中
     * unless 表示条件表达式成立的话不放入缓存
     * @param id
     * @return
     */
   // @Cacheable(value = "lockMapper", key = "#root.targetClass + #id+''", unless = "#result eq null")
    @Cacheable(value = "lockMapper", key = "#p0", unless = "#result eq null")
    @Override
    public LockMapper find(int id) {
        return lockMapperMapper.find(id);
    }
}
