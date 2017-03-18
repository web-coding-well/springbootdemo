package com.junmeng;

import com.junmeng.model.User;
import com.junmeng.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by HWJ on 2017/3/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void test(){
        User user=userService.find(9);
        Assert.assertEquals(16,user.getAge());
    }

}
