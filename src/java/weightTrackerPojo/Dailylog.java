package weightTrackerPojo;
// Generated Jan 18, 2018 2:53:48 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Dailylog  implements java.io.Serializable {


     private Integer dailyLogId;
     private Course course = new Course();
     private Date logDate;
     private String activityLevel;
     private Set exercisedailylogs = new HashSet(0);
     private Set mealdailylogs = new HashSet(0);
     private Set dailyMeasurements = new HashSet(0);

    public Dailylog() {
    }

    public Dailylog(Course course, Date logDate, String activityLevel, Set exercisedailylogs, Set mealdailylogs, Set dailyMeasurements) {
       this.course = course;
       this.logDate = logDate;
       this.activityLevel = activityLevel;
       this.exercisedailylogs = exercisedailylogs;
       this.mealdailylogs = mealdailylogs;
       this.dailyMeasurements = dailyMeasurements;
    }
   
    public Integer getDailyLogId() {
        return this.dailyLogId;
    }
    
    public void setDailyLogId(Integer dailyLogId) {
        this.dailyLogId = dailyLogId;
    }
    public Course getCourse() {
        return this.course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
    public Date getLogDate() {
        return this.logDate;
    }
    
    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }
    public String getActivityLevel() {
        return this.activityLevel;
    }
    
    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }
    public Set getExercisedailylogs() {
        return this.exercisedailylogs;
    }
    
    public void setExercisedailylogs(Set exercisedailylogs) {
        this.exercisedailylogs = exercisedailylogs;
    }
    public Set getMealdailylogs() {
        return this.mealdailylogs;
    }
    
    public void setMealdailylogs(Set mealdailylogs) {
        this.mealdailylogs = mealdailylogs;
    }
    public Set getDailyMeasurements() {
        return this.dailyMeasurements;
    }
    
    public void setDailyMeasurements(Set dailyMeasurements) {
        this.dailyMeasurements = dailyMeasurements;
    }




}


