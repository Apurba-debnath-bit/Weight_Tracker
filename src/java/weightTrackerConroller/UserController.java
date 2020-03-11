
package weightTrackerConroller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import weightTrackerDao.UserDao;
import weightTrackerPojo.Course;
import weightTrackerPojo.User;


@ManagedBean
@RequestScoped
public class UserController {

    
    public UserController() {
    }
    
    public User user = new User();
    public ArrayList<User> userses = new ArrayList<User>();
    UserDao userDao = new UserDao();
    public String msg = "";

    
   

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<User> getUserses() {
        return userses;
    }

    public void setUserses(ArrayList<User> userses) {
        this.user = user;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void save() {

        double bmi=user.getUserWeight()/(user.getUserHeight()*user.getUserHeight());
        user.setBmiIndex(bmi);
        userDao.save(user);
        setMsg("User Save");
        clear();
    }

    public void delete() {
        userDao.delete(user);
        setMsg("User Deleted");
        clear();
    }

    public void update() {

        double bmi=user.getUserWeight()/(user.getUserHeight()*user.getUserHeight());
        user.setBmiIndex(bmi);
        userDao.update(user);
        setMsg("User Updated");
        clear();
    }

    public void find() {
        User u = userDao.find(user);
        if (u != null) {
            user.setUserName(u.getUserName());
            user.setUserGender(u.getUserGender());
            user.setUserHeight(u.getUserHeight());
            user.setUserWeight(u.getUserWeight());
            user.setUserWaistSize(u.getUserWaistSize());
            user.setUserAge(u.getUserAge());
            user.setBmiIndex(u.getBmiIndex());
        } else {
            setMsg("User not found");
        }
    }
    public void clear(){
       user.setUserId(null);
       user.setUserName(null);
       user.setUserGender(null);
       user.setUserHeight(null);
       user.setUserWeight(null);
       user.setUserWaistSize(null);
       user.setUserAge(null);
       user.setBmiIndex(null);
       
       }
    
    public void display() {
        userses = userDao.getAll(user);
    }

    public void newUser() {
        user = new User();
    }
    
    
    

    public ArrayList<SelectItem> getUserCombo(){

    ArrayList<SelectItem> userCombo=new ArrayList<SelectItem>();
    for(User u:userDao.getAll(user)){
    userCombo.add(new SelectItem(u.getUserId()));

    }

    return userCombo;
    }
}

