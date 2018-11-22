package cn.bdqn.gaobingfa.mapper;

import cn.bdqn.gaobingfa.entity.UserRedPacket;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRedPacketMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRedPacket record);

    int insertSelective(UserRedPacket record);

    UserRedPacket selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRedPacket record);

    int updateByPrimaryKey(UserRedPacket record);

    /**
     * 插入抢红包信息.
     * @param userRedPacket ——抢红包信息
     * @return 影响记录数.
     */
    public int grapRedPacket(UserRedPacket  userRedPacket);
}