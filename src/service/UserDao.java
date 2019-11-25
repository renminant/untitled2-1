package service;

import pojo.User;

import java.util.HashMap;
import java.util.List;

public interface UserDao {
    public User Login(User user);
//    public List<User> getUserList(User user);

    public   List<User> tablelayui();

    public  List<User> selectpage(HashMap map);

    public Integer usercount();

    public int updatetable(User user);
}
