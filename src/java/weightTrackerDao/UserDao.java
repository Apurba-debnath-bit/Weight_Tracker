package weightTrackerDao;

import static java.nio.file.Files.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import org.hibernate.Session;
import weightTrackerPojo.User;
import weightTrackerReport.NewReport;
import weightTrackerReport.Report;
import weightTrackerUtil.weightTrackerUtil;

public class UserDao extends WeightTrackerDao<User> {

    public User find(User value) {
        return find(value, value.getUserId());
    }

    @Override
    public void delete(User value) {
        super.delete(find(value));
    }

    @Override
    public void update(User value) {
        User u = find(value);
        if (u != null) {
            u.setUserName(value.getUserName());
            u.setUserGender(value.getUserGender());
            u.setUserHeight(value.getUserHeight());
            u.setUserWeight(value.getUserWeight());
            u.setUserWaistSize(value.getUserWaistSize());
            u.setUserAge(value.getUserAge());
            u.setBmiIndex(value.getBmiIndex());
            super.update(u);
        }

    }
public List<Report> getReportData(int userId) {   
    
String sql = "select user.User_ID, user.User_Name, course.Course_ID,course.Course_Name, dailylog.DailyLog_ID, dailylog.Log_Date, dailylog.Activity_Level, "
        + "mealdailylog.Total_Unit_Take, meal.Calorie_Value, meal.Meal_Unit,exercisedailylog.Total_Unit_Burnt, exercise.Exercise_Duration, exercise.Calorie_Burnt "
     + " from user "
     + " left join course on user.User_ID=course.User_ID "
     + " left join dailylog on course.Course_ID=dailylog.Course_ID "
     + " left join mealdailylog on dailylog.DailyLog_ID=mealdailylog.DailyLog_ID "
     + " left join exercisedailylog on dailylog.DailyLog_ID=exercisedailylog.DailyLog_ID "
     + " left join meal on mealdailylog.Meal_ID=meal.Meal_ID "
     + " left join exercise on exercisedailylog.Exercise_ID=exercise.Exercise_ID "
     + "where user.User_ID=" + userId+
     " group by user.User_ID, user.User_Name, course.Course_ID,course.Course_Name, dailylog.DailyLog_ID, dailylog.Log_Date ";  



List<Report> reports = new ArrayList<Report>();
session = weightTrackerUtil.getSessionFactory().openSession();
session.getTransaction().begin();

List<Object[]> lists = (List<Object[]>) session.createSQLQuery(sql).list();
for (Object[] list : lists) {

Report r = new Report();
r.setUserId(Integer.parseInt(list[0].toString()));
r.setUserName(list[1].toString());
if(list[2]!=null)
r.setCourseId(Integer.parseInt(list[2].toString()));
if(list[3]!=null)
r.setCourseName(list[3].toString());
if(list[4]!=null)
r.setDailylogId(Integer.parseInt(list[4].toString()));
if(list[5]!=null)
r.setDailylogdate(list[5].toString());
if(list[6]!=null)
r.setActivity(list[6].toString());
if(list[7]!=null)
r.setMealCalorie(Double.parseDouble(list[7].toString()));
if(list[8]!=null)
r.setTotalUnitTake(Double.parseDouble(list[8].toString()));
if(list[9]!=null)
r.setMealUnit(Float.parseFloat(list[9].toString()));
if(list[10]!=null)   
r.setCalorieBurnt(Integer.parseInt(list[10].toString()));
if(list[11]!=null)   
r.setExerciseDuration(Integer.parseInt(list[11].toString()));
if(list[12]!=null)
r.setTotalUnitBurnt(Integer.parseInt(list[12].toString()));

reports.add(r);
}
return reports;
}
    


public List<NewReport> getReportChartData(int userId) {
    
     
    
     
String sql ="select user.User_ID, user.User_Name, course.Course_ID,course.Course_Name, dailylog.DailyLog_ID, dailylog.Log_Date, dailylog.Activity_Level,sum( mealdailylog.Total_Unit_Take*meal.Calorie_Value/meal.Meal_Unit)  as 'Total Gain Calorie' , sum(exercisedailylog.Total_Unit_Burnt*exercise.Calorie_Burnt/exercise.Exercise_Duration) as 'Total Burn calorie' ,  " 
+ "  sum( mealdailylog.Total_Unit_Take*meal.Calorie_Value/meal.Meal_Unit)-sum(exercisedailylog.Total_Unit_Burnt*exercise.Calorie_Burnt/exercise.Exercise_Duration) as 'Calorie deficiency' " 
+ "  from user  " 
+ "   left join course on user.User_ID=course.User_ID " 
+ "   left join dailylog on course.Course_ID=dailylog.Course_ID " 
+ "   left join mealdailylog on dailylog.DailyLog_ID=mealdailylog.DailyLog_ID  " 
+ "   left join exercisedailylog on dailylog.DailyLog_ID=exercisedailylog.DailyLog_ID "
+ "   left join meal on mealdailylog.Meal_ID=meal.Meal_ID  " 
+ "   left join exercise on exercisedailylog.Exercise_ID=exercise.Exercise_ID   " 
+ " where user.User_ID=" + userId+
"  group by user.User_ID, user.User_Name, course.Course_ID,course.Course_Name, dailylog.DailyLog_ID, dailylog.Log_Date;";
     
     
    List<NewReport> newreports = new ArrayList<NewReport>();
    session = weightTrackerUtil.getSessionFactory().openSession();
    session.getTransaction().begin();
    
    List<Object[]> lists = (List<Object[]>) session.createSQLQuery(sql).list();
    for (Object[] list : lists) {
    try{
    NewReport er = new NewReport();
    er.setUserId(Integer.parseInt(list[0].toString()));
    er.setUserName(list[1].toString());
    if(list[2]!=null)
    er.setCourseId(Integer.parseInt(list[2].toString()));
    if(list[3]!=null)
    er.setCourseName(list[3].toString());
    if(list[4]!=null)
    er.setDailylogId(Integer.parseInt(list[4].toString()));
    if(list[5]!=null)
    er.setDailylogdate(list[5].toString());
    if(list[6]!=null)
    er.setActivity(list[6].toString());
    if(list[7]!=null)
    er.setTotalGainCalorie(Double.parseDouble(list[7].toString()));
    if(list[8]!=null)
    er.setTotalBurnCalorie(Double.parseDouble(list[8].toString()));
    if(list[9]!=null)
    er.setCalorieDeficiency(Double.parseDouble(list[9].toString()));
    
    
    newreports.add(er);
    }catch(Exception  e){System.out.println("---------------------------"+e.getMessage());}
    }
    return newreports;
    }
}

     
     
     
     
     
     
     
    
/*List<Report> reports = new ArrayList<Report>();
session = weightTrackerUtil.getSessionFactory().openSession();
session.getTransaction().begin();

List<Object[]> lists = (List<Object[]>) session.createSQLQuery(sql).list();
for (Object[] list : lists) {

Report r = new Report();
r.setUserId(Integer.parseInt(list[0].toString()));
r.setUserName(list[1].toString());
if(list[2]!=null)
r.setCourseId(Integer.parseInt(list[2].toString()));
if(list[3]!=null)
r.setCourseName(list[3].toString());
if(list[4]!=null)
r.setDailylogId(Integer.parseInt(list[4].toString()));
if(list[5]!=null)
r.setDailylogdate(list[5].toString());
if(list[6]!=null)
r.setActivity(list[6].toString());
if(list[7]!=null)
r.setMealCalorie(Double.parseDouble(list[7].toString()));
if(list[8]!=null)
r.setTotalUnitTake(Double.parseDouble(list[8].toString()));
if(list[9]!=null)
r.setExerciseDuration(Integer.parseInt(list[9].toString()));
if(list[10]!=null)
r.setTotalBurn(Integer.parseInt(list[10].toString()));

reports.add(r);
}
return reports;
}*/
    
/*public List<Report> getCaloriDeffiency(int id) {

Session sesso = weightTrackerUtil.getSessionFactory().openSession();

String sql =
"SELECT " +
"u.User_ID, u.User_Name, " +
"dl.Log_Date, " +

"sum( (ml.Total_Unit_Take*m.Calorie_Value) ) as 'Gain Calori', " +
"sum( (ed.Total_Unit_Burnt* e.Calorie_Burnt))as 'Burn calori', " +
"sum( (ml.Total_Unit_Take*m.Calorie_Value) ) - sum( (ed.Total_Unit_Burnt* e.Calorie_Burnt)) as 'deficiate'  " +
" FROM user as u,course as c,dailylog as dl,exercisedailylog as ed,mealdailylog as ml,meal as m,exercise as e  " +

"WHERE u.User_ID = c.User_ID AND c.Course_ID=dl.Course_ID AND dl.DailyLog_ID = ed.DailyLog_ID AND  " +

" dl.DailyLog_ID=ml.DailyLog_ID AND m.Meal_ID=ml.Meal_ID AND e.Exercise_ID=ed.Exercise_ID " +

" AND u.User_ID="+id+" group by u.User_ID, u.User_Name, dl.Log_Date; ";

List<Object[]> list=(List<Object[]>) sesso.createSQLQuery(sql).list();
List<Report> reports=new ArrayList<Report>();
for (Object[] objects : list) {
Report report=new Report();
report.setUserId(Integer.parseInt(objects[0].toString()));
report.setUserName((objects[1].toString()));
report.setDailylogdate((objects[2].toString()));
report.setTotalUnitTake(Float.parseFloat(objects[3].toString()));
report.setTotalBurn((int) Float.parseFloat(objects[4].toString()));
reports.add(report);
}

return reports;
}*/


