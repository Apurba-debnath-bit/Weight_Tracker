package weightTrackerPojo;
// Generated Jan 18, 2018 2:53:48 PM by Hibernate Tools 4.3.1



/**
 * Mealdailylog generated by hbm2java
 */
public class Mealdailylog  implements java.io.Serializable {


     private Integer mealDailyLogId;
     private Dailylog dailylog = new Dailylog();
     private Meal meal = new Meal();
     private Double totalUnitTake;

    public Mealdailylog() {
    }

    public Mealdailylog(Dailylog dailylog, Meal meal, Double totalUnitTake) {
       this.dailylog = dailylog;
       this.meal = meal;
       this.totalUnitTake = totalUnitTake;
    }
   
    public Integer getMealDailyLogId() {
        return this.mealDailyLogId;
    }
    
    public void setMealDailyLogId(Integer mealDailyLogId) {
        this.mealDailyLogId = mealDailyLogId;
    }
    public Dailylog getDailylog() {
        return this.dailylog;
    }
    
    public void setDailylog(Dailylog dailylog) {
        this.dailylog = dailylog;
    }
    public Meal getMeal() {
        return this.meal;
    }
    
    public void setMeal(Meal meal) {
        this.meal = meal;
    }
    public Double getTotalUnitTake() {
        return this.totalUnitTake;
    }
    
    public void setTotalUnitTake(Double totalUnitTake) {
        this.totalUnitTake = totalUnitTake;
    }




}


