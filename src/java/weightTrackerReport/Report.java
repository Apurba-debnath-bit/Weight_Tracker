
package weightTrackerReport;


public class Report implements java.io.Serializable {
    private int userId;
    private String userName="";
    private int courseId;
    private String courseName;
    private int dailylogId;
    private String dailylogdate="";
    private String activity="";
    private float mealUnit;
    private double mealCalorie;
    private double totalUnitTake;
    private int exerciseDuration;
    private int totalUnitBurnt;
    private int calorieBurnt;

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

    public int getExerciseDuration() {
        return exerciseDuration;
    }

    public void setExerciseDuration(int exerciseDuration) {
        this.exerciseDuration = exerciseDuration;
    }

    public int getTotalUnitBurnt() {
        return totalUnitBurnt;
    }

    public void setTotalUnitBurnt(int totalUnitBurnt) {
        this.totalUnitBurnt = totalUnitBurnt;
    }

    public int getCalorieBurnt() {
        return calorieBurnt;
    }

    public void setCalorieBurnt(int calorieBurnt) {
        this.calorieBurnt = calorieBurnt;
    }

    @Override
    public String toString() {
        return "Report{" + "userId=" + userId + ", userName=" + userName + ", courseId=" + courseId + ", courseName=" + courseName + ", dailylogId=" + dailylogId + ", dailylogdate=" + dailylogdate + ", activity=" + activity + ", mealUnit=" + mealUnit + ", mealCalorie=" + mealCalorie + ", totalUnitTake=" + totalUnitTake + ", exerciseDuration=" + exerciseDuration + ", totalUnitBurnt=" + totalUnitBurnt + ", calorieBurnt=" + calorieBurnt + '}';
    }
    
   



    
   
    
    
    
}
