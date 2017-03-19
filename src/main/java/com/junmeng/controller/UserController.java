package com.junmeng.controller;

import com.junmeng.exception.CommonException;
import com.junmeng.model.User;
import com.junmeng.service.UserService;
import com.junmeng.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by HWJ on 2017/3/18.
 */
@RestController
@RequestMapping("user")
public class UserController {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;


    @GetMapping(value = "/getAll")
    public List<User> getUserList() {
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    public User addUser(@RequestParam("name") String name,
                        @RequestParam("age") int age,
                        @RequestParam("sex") int sex
    ) {

        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setSex(sex);
        return userService.addUser(user);
    }

    /**
     * 如果User里加了限制的注解，这里可在BindingResult得到验证的结果
     *
     * @param user
     * @param bindingResult
     * @return
     */
    @PostMapping("/add2")
    public Object addUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //输出验证不通过的信息
            logger.error(bindingResult.getFieldError().getDefaultMessage());
            return ResultUtil.error(-1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(userService.update(user));
    }

    @GetMapping("/{id}")
    public User findUser(@PathVariable("id") int id) {
        return userService.find(id);
    }

    @GetMapping("/age/{age}")
    public List<User> findUsersByAge(@PathVariable("age") int age) {
        return userService.findByAge(age);
    }


    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") int id,
                           @RequestParam("name") String name,
                           @RequestParam("age") int age,
                           @RequestParam("sex") int sex
    ) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        user.setSex(sex);
        return userService.update(user);
    }


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        try {
            userService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "delete failed";
        }

        return "delete success";
    }

    @GetMapping("/addtwo")
    public String addTwo() {
        try {
            userService.addTwo();
        } catch (Exception e) {
            e.printStackTrace();
            return "add two failed";
        }
        return "add two success";
    }


    @GetMapping("/getAge/{id}")
    public void getAge(@PathVariable("id") int id) throws CommonException {
        userService.getAge(id);
    }


    @PostMapping("/findBySexAndAge")
    public List<User> findBySexAndAge(@RequestParam("age") int age,
                                      @RequestParam("sex") int sex) {
        return userService.findBySexAndAge(sex, age);
    }

    @PostMapping("/findBySexOrAge")
    public List<User> findBySexOrAge(@RequestParam("age") int age,
                                      @RequestParam("sex") int sex) {
        return userService.findBySexOrAge(sex, age);
    }

    @PostMapping("/findByNameLike")
    public List<User> findByNameLike(@RequestParam("name") String name) {
        return userService.findByNameLike(name);
    }

    @PostMapping("/findByNameLike2")
    public List<User> findByNameLike2(@RequestParam("name") String name) {
        return userService.findByNameLike2(name);
    }

    @PostMapping("/updateName")
    public int updateName(@RequestParam("name") String newName,
                          @RequestParam("id") int id) {
        return userService.updateName(id,newName);
    }

}
