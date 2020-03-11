
package weightTrackerConroller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import weightTrackerDao.CourseDao;
import weightTrackerDao.DailyLogDao;
import weightTrackerPojo.Course;
import weightTrackerPojo.Dailylog;
import weightTrackerPojo.User;


@ManagedBean
@RequestScoped
public class DailyLogController {

    
    public DailyLogController() {
    }
    

    
  // New code........  
    
    private Dailylog dailyLog = new Dailylog();
    private Course course=new Course();
    private ArrayList<Dailylog> dailyLogs = new ArrayList<Dailylog>();
    DailyLogDao dailyLogDao = new DailyLogDao();
    public String msg = "";

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    
    

    public Dailylog getDailyLog() {
        return dailyLog;
    }

    public void setDailyLog(Dailylog dailyLog) {
        this.dailyLog = dailyLog;
    }

    public ArrayList<Dailylog> getDailyLogs() {
        return dailyLogs;
    }

    public void setDailyLogs(ArrayList<Dailylog> dailyLogs) {
        this.dailyLogs = dailyLogs;
    }

    public void save() {
        System.out.println("test dl cousid ............."+getCourse().getCourseId());
        dailyLog.setCourse(course);
        dailyLogDao.save(dailyLog);
        setMsg("DailyLog Has been Saved");
        clear();
    }

    public void update() {
        dailyLogDao.update(dailyLog);
        setMsg("DailyLog Has been Updated");
        clear();
    }

    public void delete() {
        dailyLogDao.delete(dailyLog);
        setMsg("DailyLog Has been deleted");
    }

    public void find() {
        Dailylog dl = dailyLogDao.find(dailyLog, dailyLog.getDailyLogId());
        if (dl != null) {
            dailyLog.setCourse(dl.getCourse());
            dailyLog.setLogDate(dl.getLogDate());
            dailyLog.setActivityLevel(dl.getActivityLevel());   
        } else {
            setMsg("DailyLog Not found ");
        }
    }

    public void display() {
        dailyLogs = dailyLogDao.getAll(dailyLog);
        clear();

    }
    
    public void newDailyLog(){
    dailyLog=new Dailylog();
    }

    
    
     public void newDailylog() {
        dailyLog = new Dailylog();
    }
    public void clear(){
        
        
        dailyLog.setDailyLogId(null);
        dailyLog.setLogDate(null);
        dailyLog.setCourse(null);
        
    }
    
   public ArrayList<SelectItem> getDailyLogCombo(){

    ArrayList<SelectItem> dailyLogCombo=new ArrayList<SelectItem>();
    for(Dailylog dl:dailyLogDao.getAll(dailyLog)){
    dailyLogCombo.add(new SelectItem(dl.getDailyLogId()));

    }

    return dailyLogCombo;
    }
    
    
    

    
}
