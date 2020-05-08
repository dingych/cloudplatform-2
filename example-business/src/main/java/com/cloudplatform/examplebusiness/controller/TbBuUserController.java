package com.cloudplatform.examplebusiness.controller;

import com.alibaba.fastjson.JSON;
import com.cloudplatform.common.exception.BusinessException;
import com.cloudplatform.common.utils.R;
import com.cloudplatform.examplebusiness.entity.TbBuUser;
import com.cloudplatform.examplebusiness.service.TbBuUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (TbBuTbBuUser)表控制层
 *
 * @author makejava
 * @since 2020-04-09 01:07:47
 */
@RestController
@RequestMapping("tbBuTbBuUser")
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
        if(null == id){
            throw  new BusinessException("-1","用户姓名不能为空！");
        }
        return R.ok(result);
    }
    @PostMapping("/user")
    public boolean insert(@RequestBody TbBuUser user) {
        System.out.println("开始新增...");
        //如果姓名为空就手动抛出一个自定义的异常！
        if(user.getUsername() == null){
            throw  new BusinessException("-1","用户姓名不能为空！");
        }
        return true;
    }

    @PutMapping("/user")
    public boolean update(@RequestBody TbBuUser user) {
        System.out.println("开始更新...");
        //这里故意造成一个空指针的异常，并且不进行处理
        String str=null;
        str.equals("111");
        return true;
    }

    @DeleteMapping("/user")
    public boolean delete(@RequestBody TbBuUser user)  {
        System.out.println("开始删除...");
        //这里故意造成一个异常，并且不进行处理
        Integer.parseInt("abc123");
        return true;
    }

    @GetMapping("/user")
    public List<TbBuUser> findByTbBuUser(TbBuUser user) {
        System.out.println("开始查询...");
        List<TbBuUser> userList =new ArrayList<>();
        TbBuUser user2=new TbBuUser();
        user2.setId(1);
        user2.setUsername("xuwujing");
        user2.setPassword("5555");
        userList.add(user2);
        return userList;
    }
}