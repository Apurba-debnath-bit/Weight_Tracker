
package weightTrackerConroller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import weightTrackerDao.CourseDao;
import weightTrackerDao.UserDao;
import weightTrackerPojo.Course;
import weightTrackerPojo.User;



@ManagedBean
@RequestScoped
public class CourseController {

    
    public CourseController() {
    }
    
 
  
public Course course=new Course();
public ArrayList<Course> courses=new ArrayList<Course>();
CourseDao courseDao =new CourseDao();
public String msg ="";

    public User users=new User();

    ArrayList<SelectItem> selectItemsUser =new ArrayList<SelectItem>();
    UserDao userDao=new UserDao();

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public ArrayList<SelectItem> getSelectItemsUser() {
        selectItemsUser.clear();
        selectItemsUser=new ArrayList<>();
        for(User u : userDao.getAll(users)){
            selectItemsUser.add(new SelectItem(u.getUserId(), u.getUserName()));
        }
        return selectItemsUser;
    }

    public void setSelectItemsUser(ArrayList<SelectItem> selectItemsUser) {
        this.selectItemsUser = selectItemsUser;
    }
    
    
     
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    
    public void setCourses(ArrayList<Course> courses) {     
        this.courses = courses;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
public void save(){
    
        users.setUserId(course.getUser().getUserId());
        users=userDao.find(users);
        course.setBmiIndex(users.getBmiIndex());
        if(users.getBmiIndex()>24)
            course.setBmiIndex(24-users.getBmiIndex());
        else if(users.getBmiIndex()<18)
            course.setBmiIndex(users.getBmiIndex()-18);
        courseDao.save(course);
        setMsg("Course Save");
        clear();
        
    }
     public void delete(){
        courseDao.delete(course);
        setMsg("Course Deleted");
        clear();
    }
      public void update(){
        courseDao.update(course);
        setMsg("Course Updated");
        clear();
    }
      
    public void find(){
           Course c=courseDao.find(course);
           if(c!=null){
               course.setUser(c.getUser());
               course.setCourseStartDate(c.getCourseStartDate());
               course.setCourseEndDate(c.getCourseEndDate());
               course.setBmiIndex(c.getBmiIndex());
               course.setCourseTrainerName(c.getCourseTrainerName());
               course.setCourseName(c.getCourseName());
               
        }else{
        
        setMsg("Course not Found");  
           }
       
    }
 public void clear(){
     course.setCourseId(null);
     course.setCourseStartDate(null);
     course.setCourseEndDate(null);
     course.setCourseTrainerName(null);
     course.setBmiIndex(null);
     course.setCourseName(null);
     
       }
    public void display(){
        courses=courseDao.getAll(course);
    }
     public void newCourse(){
       course=new Course();
    }
    
    public ArrayList<SelectItem> getCourseCombo() {

        ArrayList<SelectItem>courseCombo = new ArrayList<SelectItem>();
        for (Course c : courseDao.getAll(course)) {
            courseCombo.add(new SelectItem(c.getCourseId()));

        }

        return courseCombo;
    }
    
    
}
