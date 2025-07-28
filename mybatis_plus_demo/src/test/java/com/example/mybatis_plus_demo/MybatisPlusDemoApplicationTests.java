package com.example.mybatis_plus_demo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis_plus_demo.entity.User;
import com.example.mybatis_plus_demo.mapper.UserMapper;
import com.example.mybatis_plus_demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlusDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    //0.功能测试-查询所有记录
    @Test
    public void testSelectList() {
        System.out.println(("----- selectAll method test ------"));
        //UserMapper 中的 selectList() 方法的参数为 MP 内置的条件封装器 Wrapper
        //所以不填写就是无任何条件
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    //1.插入操作
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("mary");
        user.setAge(18);
        user.setEmail("atguigu@qq.com");
        int result = userMapper.insert(user);
        System.out.println(result); //影响的行数
        System.out.println(user); //id自动回填
    }

    //2.更改操作
    @Test
    public void testUpdateById(){
        //1 根据id查询记录
        User user = userMapper.selectById(1L);
        //2 设置修改的值
        user.setAge(50);
        //3 调用方法修改
        int result = userMapper.updateById(user);
        System.out.println(result);
    }

    //分页查询
    @Test
    public void testSelectPage() {
        //创建page对象，参数：1.当前页，2.总页数
        Page<User> page = new Page<>(1,5);
        //调用mybatisPlus方法实现分页
        userMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }

    //根据id删除记录
    @Test
    public void testDeleteById(){
        int result = userMapper.deleteById(8L);
        System.out.println(result);
    }

    //批量删除
    @Test
    public void testDeleteBatchIds() {
        int result = userMapper.deleteBatchIds(Arrays.asList(8, 9, 10));
        System.out.println(result);
    }

    /**
     * 测试 逻辑删除
     */
    @Test
    public void testLogicDelete() {
        int result = userMapper.deleteById(1L);
        System.out.println(result);
    }

    /**
     * 测试 逻辑删除后的查询：
     * 不包括被逻辑删除的记录
     */
    @Test
    public void testLogicDeleteSelect() {
        User user = new User();
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelect() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age", 28);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    @Test
    public void testSelectOne() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "Tom");
        //seletOne返回的是一条实体记录，当出现多条时会报错
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }

    //selectMaps返回Map集合列表
    @Test
    public void testSelectMaps() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .like("name", "e")
                .likeRight("email", "t");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);//返回值是Map列表
        maps.forEach(System.out::println);
    }

    //orderByDesc、orderByAsc
    @Test
    public void testSelectListOrderBy() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    //LambdaQueryWrapper  使用
    @Test
    public void testLambdaQuery() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getAge,30);
        queryWrapper.like(User::getName,"张");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }


    //查询表所有数据
    //注入service
    @Autowired
    private UserService userService;
    @Test
    public void findAll() {
        List<User> userList = userService.list();
        for (User user:userList) {
            System.out.println(user);
        }
    }

}
