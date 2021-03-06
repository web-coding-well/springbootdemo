package com.junmeng.repository;

import com.junmeng.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 使用jpa后已经有了基本的增删查改，如需扩展，则可以在此实现
 * JpaSpecificationExecutor:查询条件
 * Created by HWJ on 2017/3/18.
 */
public interface UserRepostiory extends JpaRepository<User, Integer> ,JpaSpecificationExecutor<User>{

    /**
     * 根据年龄来查询
     *
     * @param age
     * @return
     */
    List<User> findByAge(int age);


    /**
     * 根据性别和年龄来查询
     * 关键字还有(详见http://sishuok.com/forum/blogPost/list/7000.html)
     * And:         findBySexAndAge
     * Or:          findBySexOrAge
     * Between:     findByAgeBetween
     * LessThan:    findByAgeLessThan
     * GreaterThan: findByAgeGreaterThan
     * After:       findByAgeAfter
     * Before:      findByAgeBefore
     * IsNull:      findByAgeIsNull
     * IsNotNull,NotNulll:
     * Like:
     * NotLike:
     * StartingWith:
     * EndingWith:
     * Containing:
     * OrderBy:      desc
     * Not:
     * In:
     * NotIn:
     * True:
     * False:
     *
     * @param sex
     * @param age
     * @return
     */
    List<User> findBySexAndAge(int sex, int age);

    /**
     * 自定义sql语句
     *
     * @param sex
     * @param age
     * @return
     */
    @Query("select user from User user where user.sex=?1 or user.age=?2")
    List<User> findBySexOrAge(int sex, int age);

    /**
     * %表示匹配任意字符
     *
     * @param name
     * @return
     */
    @Query("select user from User user where user.name like \'?1%\'")
    //@Query("select user from User user where user.name like %?1%")
    //@Query("select user from User user where user.name like %?1")
    List<User> findByNameLike(String name);

    /**
     * 可以指定参数名称
     *
     * @param name
     * @return
     */
    //@Query("select user from User user where user.name like :NAME%")
    @Query("select user from User user where user.name like %:NAME%")
    List<User> findByNameLike2(@Param("NAME") String name);

    /**
     * 加上@Modifying注解才能更新,同时在service要开启事务（加个@Transactional即可）
     * 注意涉及到改变数据库的动作都要配合使用@Modifying和@Transactional
     *
     * @param id
     * @param newName
     * @return 更新条数
     */
    @Modifying
    @Query(value = "update User user set user.name=?2 where user.id = ?1")
    int updateName(int id, String newName);

    /**
     * 支持本地查询
     *
     * @param id
     * @param newName
     * @return
     */
    @Modifying
    @Query(value = "update tb_user set name=?2 where id = ?1", nativeQuery = true)
    int updateName2(int id, String newName);
}
