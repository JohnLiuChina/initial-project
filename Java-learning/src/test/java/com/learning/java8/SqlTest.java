package com.learning.java8;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learning.java8.entity.Field;
import com.learning.java8.entity.Instance;
import com.learning.java8.mapper.FieldMapper;
import com.learning.java8.mapper.InstanceFieldMapper;
import com.learning.java8.mapper.InstanceMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SqlTest {

    @Resource
    private FieldMapper fieldMapper;

    @Resource
    private InstanceFieldMapper instanceFieldMapper;

    @Resource
    private InstanceMapper instanceMapper;

    @Test
    public void sqlTest(){
        IPage<Instance> page = new Page<>(1, 5);
        IPage<Instance> pageSingle = new Page<>(1, 1);
        System.out.println(JSONObject.toJSONString(fieldMapper.pageList(page, "字段1,字段2,创建时间")));
        System.out.println(JSONObject.toJSONString(fieldMapper.pageList(pageSingle, "字段1,字段2,创建时间")));
    }

    @Test
    public void listTest(){
        List<Field> result = fieldMapper.getFields(2, "字段1,字段2,创建时间");
        System.out.println(JSONObject.toJSONString(result));
    }

    @Test
    public void getIntersection(){
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        List<Integer> cList = new ArrayList<>();
        aList.add(1);
        aList.add(2);
        aList.add(3);
        aList.add(4);
        bList.add(3);
        bList.add(31);
        bList.add(7);
        bList.add(1);
        cList.add(55);
        cList.add(5);
        cList.add(1);
        cList.add(2);
        aList.retainAll(bList);
        aList.retainAll(cList);
        System.out.println(aList);
    }

}
