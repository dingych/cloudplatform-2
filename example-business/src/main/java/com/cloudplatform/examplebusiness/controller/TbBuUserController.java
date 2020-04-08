package com.cloudplatform.examplebusiness.controller;

import com.cloudplatform.examplebusiness.entity.TbBuUser;
import com.cloudplatform.examplebusiness.service.TbBuUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbBuUser)表控制层
 *
 * @author makejava
 * @since 2020-04-09 01:07:47
 */
@RestController
@RequestMapping("tbBuUser")
public class TbBuUserController {
    /**
     * 服务对象
     */
    @Resource
    private TbBuUserService tbBuUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbBuUser selectOne(Integer id) {
        return this.tbBuUserService.queryById(id);
    }

}