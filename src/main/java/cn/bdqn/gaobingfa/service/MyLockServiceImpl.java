package cn.bdqn.gaobingfa.service;

import cn.bdqn.gaobingfa.entity.LockMapper;
import cn.bdqn.gaobingfa.mapper.LockMapperMapper;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
@Service("myLockServiceImpl")
public class MyLockServiceImpl implements Lock {

    private Log log= LogFactory.getLog(MyLockServiceImpl.class);

    private LockMapper lockMapper=new LockMapper();

    @Autowired
    private LockMapperMapper lockMapperMapper;

    private final int num=100;

    @Override
    public void lock() {
      if(tryLock()) return;
      try {
          Thread.sleep(1000);
      }catch (Exception e){

      }
     lock();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        try {
            lockMapper.setId(num);
            lockMapper.setAge(10);
            lockMapper.setName("北高峰线");
          lockMapperMapper.insert(lockMapper);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
lockMapperMapper.delete(num);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
