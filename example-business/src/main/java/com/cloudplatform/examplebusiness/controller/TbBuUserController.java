package com.cloudplatform.examplebusiness.controller;

import com.alibaba.fastjson.JSON;
import com.cloudplatform.common.utils.R;
import com.cloudplatform.examplebusiness.entity.TbBuUser;
import com.cloudplatform.examplebusiness.service.TbBuUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
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
@Api(value = "用户模块", description = "用户模块基础接口",tags = {"用户模块"})
public class TbBuUserController {
    private static Logger log = Logger.getLogger(TbBuUserController.class);
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
    @ApiOperation(value = "查询", notes = "主键查询",response = R.class)
    @GetMapping("selectOne")
    public R selectOne(Integer id) {
        TbBuUser tbBuUser = this.tbBuUserService.queryById(id);
        String result = JSON.toJSONString(tbBuUser);
        log.info(result);
        return R.ok(result);
    }
}