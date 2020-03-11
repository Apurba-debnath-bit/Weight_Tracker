package weightTrackerPojo;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Course  implements java.io.Serializable {


     private Integer courseId;
     private User user = new User();
     private String courseName;
     private Date courseStartDate;
     private Date courseEndDate;
     private String courseTrainerName;
     private Double bmiIndex;
     private Set dailylogs = new HashSet(0);

    public Course() {
    }

    public Course(User user, String courseName, Date courseStartDate, Date courseEndDate, String courseTrainerName, Double bmiIndex, Set dailylogs) {
       this.user = user;
       this.courseName = courseName;
       this.courseStartDate = courseStartDate;
       this.courseEndDate = courseEndDate;
       this.courseTrainerName = courseTrainerName;
       this.bmiIndex = bmiIndex;
       this.dailylogs = dailylogs;
    }
   
    public Integer getCourseId() {
        return this.courseId;
    }
    
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public String getCourseName() {
        return this.courseName;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public Date getCourseStartDate() {
        return this.courseStartDate;
    }
    
    public void setCourseStartDate(Date courseStartDate) {
        this.courseStartDate = courseStartDate;
    }
    public Date getCourseEndDate() {
        return this.courseEndDate;
    }
    
    public void setCourseEndDate(Date courseEndDate) {
        this.courseEndDate = courseEndDate;
    }
    public String getCourseTrainerName() {
        return this.courseTrainerName;
    }
    
    public void setCourseTrainerName(String courseTrainerName) {
        this.courseTrainerName = courseTrainerName;
    }
    public Double getBmiIndex() {
        return this.bmiIndex;
    }
    
    public void setBmiIndex(Double bmiIndex) {
        this.bmiIndex = bmiIndex;
    }
    public Set getDailylogs() {
        return this.dailylogs;
    }
    
    public void setDailylogs(Set dailylogs) {
        this.dailylogs = dailylogs;
    }




}


