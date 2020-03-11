/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weightTrackerReport;


public class NewReport implements java.io.Serializable {
    private int userId;
    private String userName="";
    private double userWeight;
    private int courseId;
    private String courseName;
    private int dailylogId;
    private String dailylogdate="";
    private String activity="";
    private double totalGainCalorie;
    private double totalBurnCalorie;
    private double calorieDeficiency;
    private float mealUnit;
    private double mealCalorie;
    private double totalUnitTake;
    private int totalUnitBurnt;
    private int exerciseDuration;
    private int calorieBurntPermin;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(double userWeight) {
        this.userWeight = userWeight;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getDailylogId() {
        return dailylogId;
    }

    public void setDailylogId(int dailylogId) {
        this.dailylogId = dailylogId;
    }

    public String getDailylogdate() {
        return dailylogdate;
    }

    public void setDailylogdate(String dailylogdate) {
        this.dailylogdate = dailylogdate;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public double getTotalGainCalorie() {
        return totalGainCalorie;
    }

    public void setTotalGainCalorie(double totalGainCalorie) {
        this.totalGainCalorie = totalGainCalorie;
    }

    public double getTotalBurnCalorie() {
        return totalBurnCalorie;
    }

    public void setTotalBurnCalorie(double totalBurnCalorie) {
        this.totalBurnCalorie = totalBurnCalorie;
    }

    public double getCalorieDeficiency() {
        return calorieDeficiency;
    }

    public void setCalorieDeficiency(double calorieDeficiency) {
        this.calorieDeficiency = calorieDeficiency;
    }

    public float getMealUnit() {
        return mealUnit;
    }

    public void setMealUnit(float mealUnit) {
        this.mealUnit = mealUnit;
    }

    public double getMealCalorie() {
        return mealCalorie;
    }

    public void setMealCalorie(double mealCalorie) {
        this.mealCalorie = mealCalorie;
    }

    public double getTotalUnitTake() {
        return totalUnitTake;
    }

    public void setTotalUnitTake(double totalUnitTake) {
        this.totalUnitTake = totalUnitTake;
    }

    public int getTotalUnitBurnt() {
        return totalUnitBurnt;
    }

    public void setTotalUnitBurnt(int totalUnitBurnt) {
        this.totalUnitBurnt = totalUnitBurnt;
    }

    public int getExerciseDuration() {
        return exerciseDuration;
    }

    public void setExerciseDuration(int exerciseDuration) {
        this.exerciseDuration = exerciseDuration;
    }

    public int getCalorieBurntPermin() {
        return calorieBurntPermin;
    }

    public void setCalorieBurntPermin(int calorieBurntPermin) {
        this.calorieBurntPermin = calorieBurntPermin;
    }

    @Override
    public String toString() {
        return "NewReport{" + "userId=" + userId + ", userName=" + userName + ", userWeight=" + userWeight + ", courseId=" + courseId + ", courseName=" + courseName + ", dailylogId=" + dailylogId + ", dailylogdate=" + dailylogdate + ", activity=" + activity + ", totalGainCalorie=" + totalGainCalorie + ", totalBurnCalorie=" + totalBurnCalorie + ", calorieDeficiency=" + calorieDeficiency + ", mealUnit=" + mealUnit + ", mealCalorie=" + mealCalorie + ", totalUnitTake=" + totalUnitTake + ", totalUnitBurnt=" + totalUnitBurnt + ", exerciseDuration=" + exerciseDuration + ", calorieBurntPermin=" + calorieBurntPermin + '}';
    }
    
    
}
