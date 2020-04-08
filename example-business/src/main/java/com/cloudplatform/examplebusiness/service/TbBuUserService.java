package com.cloudplatform.examplebusiness.service;

import com.cloudplatform.examplebusiness.entity.TbBuUser;
import java.util.List;

/**
 * (TbBuUser)表服务接口
 *
 * @author makejava
 * @since 2020-04-09 01:07:47
 */
public interface TbBuUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbBuUser queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbBuUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbBuUser 实例对象
     * @return 实例对象
     */
    TbBuUser insert(TbBuUser tbBuUser);

    /**
     * 修改数据
     *
     * @param tbBuUser 实例对象
     * @return 实例对象
     */
    TbBuUser update(TbBuUser tbBuUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}