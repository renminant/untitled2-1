package service;


import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;

import java.util.HashMap;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {
    @Autowired
    UserMapper userMapper;

    @Override
    public User Login(User user) {

        return userMapper.Login(user);
    }


//    @Override
//    public List<User> getUserList(User user) {
//        return userMapper.getUserList(user);
//    }


    @Override
    public List<User> tablelayui() {
        return userMapper.tablelayui();
    }

    @Override
    public List<User> selectpage(HashMap map) {
        return userMapper.selectpage(map);
    }

    @Override
    public Integer usercount() {
        return userMapper.usercount();
    }

    @Override
    public int updatetable(User user) {
        return userMapper.updatetable(user);
    }
}
