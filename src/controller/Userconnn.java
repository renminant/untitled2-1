package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pojo.User;
import service.UserDao;
import tool.Tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import static tool.Tool.testLayui;
@Controller
public class Userconnn {
    @Autowired
    UserDao userDao;
    @Autowired
    HttpServletRequest request;


    //点击“用户管理”or"查询"后
//    @RequestMapping("/userList.action")
//    public ModelAndView u serList(User user, @RequestParam(required = false,defaultValue = "1",value = "page")int page){
//        ModelAndView mad = new ModelAndView();
//        //首先是设置第几页，第二个参数是每页的记录数
//        PageHelper.startPage(page,5);
//        List<User> userList = userDao.getUserList(user);//调用getUserList方法
//        PageInfo pageinfo = new PageInfo(userList);
//        mad.addObject("searchName",user.getName() );
//        mad.addObject("pageinfo",pageinfo);
//        mad.setViewName("userList");
//        return mad;
//    }
//登录
    @RequestMapping("/loginLayui.action")
    @ResponseBody
    public Map<String,String> Login(@RequestBody User user) {
        HttpSession session = request.getSession();
        User loginUser = userDao.Login(user);
        Map<String,String> msg = new HashMap<>();
        if (loginUser != null) {
            session.setAttribute("user", loginUser);
            msg.put("msg","success");
            return msg;
        } else {
            msg.put("msg","false");
            return msg;
        }
    }

    @RequestMapping("/tableLayui.action")
    @ResponseBody
    public Map<String, Object> tableLayui() {
//        Map<String,Object> returnTable =new HashMap<>();
//        returnTable.put("code",0);
//        returnTable.put("msg","");
        List<User> users = userDao.tablelayui();
        return Tool.testLayui(users, 0, 0);
//        returnTable.put("count",users.size());
//        JSONArray data = JSONArray.fromObject(users);
//        returnTable.put("data",data);
//        return returnTable;


    }

    @RequestMapping("/tableLayuiPage.action")
    public String tableLayuiPage() {
        return "table";
    }

    @RequestMapping("/back.action")
    public String back() {
        return "back";
    }


    //分页
    @RequestMapping("/selectlayuitable.action")
    @ResponseBody
    public Map<String, Object> selectlayuitable(int page, int limit) {
        HashMap<String, Object> map = new HashMap<>();
        int pagestart = (page - 1) * limit;
        map.put("pagestart", pagestart);
        map.put("size", limit);
        List<User> users = userDao.selectpage(map);
        Integer pagecount = userDao.usercount();
        Map<String, Object> returnTable = testLayui(users, page, limit);
        returnTable.put("count", pagecount);
        return returnTable;
    }

    @RequestMapping("/updatetable.action")
    @ResponseBody
   public int updatetable(User user){
        return userDao.updatetable(user);
    }
}
