package com.junmeng.service;

import com.junmeng.enums.ResultCode;
import com.junmeng.exception.BussinessException;
import com.junmeng.model.User;
import com.junmeng.repository.UserRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by HWJ on 2017/3/18.
 */
@Service
public class UserService {
    @Autowired
    private UserRepostiory userRepostiory;

    public List<User> getAllUsers() {
        return userRepostiory.findAll();
    }

    public User addUser(User user) {
        return userRepostiory.save(user);
    }

    public User find(int id) {
        return userRepostiory.findOne(id);
    }

    public List<User> findByAge(int age) {
        return userRepostiory.findByAge(age);
    }

    public User update(User user) {
        return userRepostiory.save(user);
    }

    public void delete(int id) {
        userRepostiory.delete(id);
    }

    /**
     * 事务管理
     */
    @Transactional
    public void addTwo() {
        User user1 = new User();
        user1.setName("user1");
        user1.setSex(1);
        user1.setAge(19);
        userRepostiory.save(user1);
        User user2 = new User();
        user2.setName("user2");
        user2.setSex(0);
        user2.setAge(10);
        userRepostiory.save(user2);
    }

    public void getAge(int id) throws BussinessException {
        User user = userRepostiory.findOne(id);
        if (user == null) {
            throw new BussinessException(ResultCode.CANNOT_FIND, "找不到用户");
        } else {
            if (user.getAge() < 18) {
                throw new BussinessException(ResultCode.UNDER_AGE, "未满18周岁");
            }
        }
    }

    public List<User> findBySexAndAge(int sex, int age) {
        return userRepostiory.findBySexAndAge(sex, age);
    }

    public List<User> findBySexOrAge(int sex, int age) {
        return userRepostiory.findBySexOrAge(sex, age);
    }

    public List<User> findByNameLike(String name) {
        return userRepostiory.findByNameLike(name);
    }

    public List<User> findByNameLike2(String name) {
        return userRepostiory.findByNameLike2(name);
    }

    @Transactional
    public int updateName(int id, String newName) {
        return userRepostiory.updateName(id, newName);
    }


    public Page<User> findAll(int page, int size) {
        Specification<User> specification=new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root,//查询的类型
                                         CriteriaQuery<?> criteriaQuery,//查询条件
                                         CriteriaBuilder criteriaBuilder//构建criteria
            ) {
                Path path=root.get("age");
                return criteriaBuilder.gt(path,18);//年龄大于18
            }
        };
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "age");
        Sort sort = new Sort(order);
        Pageable pageable = new PageRequest(page, size, sort);
        return userRepostiory.findAll(specification,pageable);
    }

    public boolean exists(int id) {
        return userRepostiory.exists(id);
    }
}
