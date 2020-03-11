package weightTrackerPojo;

public class Exercisedailylog  implements java.io.Serializable {


     private Integer exerciseDailyLogId;
     private Dailylog dailylog = new Dailylog();
     private Exercise exercise = new Exercise();
     private Integer totalUnitBurnt;

    public Exercisedailylog() {
    }

    public Exercisedailylog(Dailylog dailylog, Exercise exercise, Integer totalUnitBurnt) {
       this.dailylog = dailylog;
       this.exercise = exercise;
       this.totalUnitBurnt = totalUnitBurnt;
    }
   
    public Integer getExerciseDailyLogId() {
        return this.exerciseDailyLogId;
    }
    
    public void setExerciseDailyLogId(Integer exerciseDailyLogId) {
        this.exerciseDailyLogId = exerciseDailyLogId;
    }
    public Dailylog getDailylog() {
        return this.dailylog;
    }
    
    public void setDailylog(Dailylog dailylog) {
        this.dailylog = dailylog;
    }
    public Exercise getExercise() {
        return this.exercise;
    }
    
    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
    public Integer getTotalUnitBurnt() {
        return this.totalUnitBurnt;
    }
    
    public void setTotalUnitBurnt(Integer totalUnitBurnt) {
        this.totalUnitBurnt = totalUnitBurnt;
    }




}


