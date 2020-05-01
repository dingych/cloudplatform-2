package com.cloudplatform.examplebusiness.service.impl;

import com.cloudplatform.examplebusiness.entity.TbBuUser;
import com.cloudplatform.examplebusiness.dao.TbBuUserDao;
import com.cloudplatform.examplebusiness.service.TbBuUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbBuUser)表服务实现类
 *
 * @author makejava
 * @since 2020-04-09 01:07:47
 */
@Service("tbBuUserService")
@Transactional(rollbackFor = { Exception.class })

public class TbBuUserServiceImpl implements TbBuUserService {
    @Resource
    private TbBuUserDao tbBuUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbBuUser queryById(Integer id) {
        return this.tbBuUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbBuUser> queryAllByLimit(int offset, int limit) {
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return this.tbBuUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbBuUser 实例对象
     * @return 实例对象
     */
    @Override
    public TbBuUser insert(TbBuUser tbBuUser) {
        this.tbBuUserDao.insert(tbBuUser);
        return tbBuUser;
    }

    /**
     * 修改数据
     *
     * @param tbBuUser 实例对象
     * @return 实例对象
     */
    @Override
    public TbBuUser update(TbBuUser tbBuUser) {
        this.tbBuUserDao.update(tbBuUser);
        return this.queryById(tbBuUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tbBuUserDao.deleteById(id) > 0;
    }
}