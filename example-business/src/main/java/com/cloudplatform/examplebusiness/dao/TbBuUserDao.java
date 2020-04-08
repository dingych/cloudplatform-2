package com.cloudplatform.examplebusiness.dao;

import com.cloudplatform.examplebusiness.entity.TbBuUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TbBuUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-09 01:07:47
 */
@Mapper
public interface TbBuUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbBuUser queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbBuUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbBuUser 实例对象
     * @return 对象列表
     */
    List<TbBuUser> queryAll(TbBuUser tbBuUser);

    /**
     * 新增数据
     *
     * @param tbBuUser 实例对象
     * @return 影响行数
     */
    int insert(TbBuUser tbBuUser);

    /**
     * 修改数据
     *
     * @param tbBuUser 实例对象
     * @return 影响行数
     */
    int update(TbBuUser tbBuUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}