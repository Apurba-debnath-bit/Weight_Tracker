package weightTrackerDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import net.sf.ehcache.search.aggregator.Count;
import org.hibernate.Session;
import sun.awt.SunHints;
import weightTrackerPojo.Course;
import weightTrackerPojo.Dailylog;
import weightTrackerPojo.User;
import weightTrackerUtil.weightTrackerUtil;

public class DailyLogDao extends WeightTrackerDao<Dailylog> {

    public Dailylog find(Dailylog value) {
        return find(value, value.getDailyLogId());
    }

    @Override
    public void delete(Dailylog value) {
        super.delete(find(value));
    }

    @Override
    public void update(Dailylog value) {
        session = weightTrackerUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Dailylog dl = (Dailylog) session.get(value.getClass(), value.getDailyLogId());
        if (dl != null) {
            dl.setLogDate(value.getLogDate());
            dl.setActivityLevel(value.getActivityLevel());
            dl.setCourse(value.getCourse());
            //dl.setDailyMeasurements(value.getDailyMeasurements());
            //dl.setExercisedailylogs(value.getExercisedailylogs());
            //dl.setMealdailylogs(value.getMealdailylogs());

            session.update(dl);
            session.getTransaction().commit();
        }

    }


 public Dailylog getDailylogById(int id){
                Dailylog dl=new Dailylog();
               Session session = weightTrackerUtil.getSessionFactory().openSession();
               session.getTransaction().begin();
               User u=(User) session.get(User.class,id);
                Iterator<Course> ui = u.getCourses().iterator();
                if(ui.hasNext()){
                  Course  c=ui.next();
                  Iterator<Dailylog> dui =  c.getDailylogs().iterator();
                    while(dui.hasNext())
                        dl=dui.next();
                }
        return dl;
 }
    
//    public static void main(String[] args) {
//        Dailylog dl=new Dailylog();
//        dl.setActivityLevel("Active");
//        dl.getCourse().setCourseId(2);
//        dl.setLogDate(new Date());
//        new DailyLogDao().save(dl);
//    }
    
}
