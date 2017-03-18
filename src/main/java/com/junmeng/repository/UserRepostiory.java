package com.junmeng.repository;

import com.junmeng.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 使用jpa后已经有了基本的增删查改，如需扩展，则可以在此实现
 * Created by HWJ on 2017/3/18.
 */
public interface UserRepostiory extends JpaRepository<User,Integer> {

    //比如要根据年龄来查询
    List<User> findByAge(int age);
}
