package cn.bdqn.gaobingfa.mapper;

import cn.bdqn.gaobingfa.entity.RedPacket;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RedPacketMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RedPacket record);

    int insertSelective(RedPacket record);

    RedPacket selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RedPacket record);

    int updateByPrimaryKey(RedPacket record);

    /**
     * 获取红包信息.
     * @param id --红包id
     * @return 红包具体信息
     */
    public RedPacket getRedPacket(Long id);

    /**
     * 扣减抢红包数.
     * @param id -- 红包id
     * @return 更新记录条数
     */
    public int decreaseRedPacket(Long id);

    /***
     * 使用for update语句加锁.
     * @param id ——红包id
     * @return 红包信息
     */
    public RedPacket getRedPacketForUpdate(Long id);


    public int decreaseRedPacketForVersion(@Param("id") Long id, @Param("version") Integer version);

}