package weightTrackerDao;

import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.Session;
import weightTrackerPojo.Course;
import weightTrackerPojo.Dailylog;
import weightTrackerPojo.User;
import weightTrackerUtil.weightTrackerUtil;

public class CourseDao extends WeightTrackerDao<Course> {

    public Course find(Course value) {
        return find(value, value.getCourseId());
    }

    @Override
    public void delete(Course value) {
        super.delete(find(value));
    }

    @Override
    public void update(Course value) {
        session = weightTrackerUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Course c = (Course) session.get(value.getClass(), value.getCourseId());
        if (c != null) {

            c.setCourseName(value.getCourseName());
            c.setUser(value.getUser());
            c.setCourseStartDate(value.getCourseStartDate());
            c.setCourseEndDate(value.getCourseEndDate());
            c.setCourseTrainerName(value.getCourseTrainerName());
            c.setBmiIndex(value.getBmiIndex());

            session.update(c);
            session.getTransaction().commit();
        }

    }

//    public Course getCourseById(int id) {
//        
//        
//        Course c = new Course();
//        Session session = weightTrackerUtil.getSessionFactory().openSession();
//                session.getTransaction().begin();
//
//        User u = (User) session.get(User.class, id);
//
//        ArrayList<Course> courses;
//        courses = (ArrayList<Course>) session.createQuery("Select * from Course c where c.userId=" + u.getUserId()).list();
//
//        if (courses.size() > 0) {
//            c = courses.get(courses.size() - 1);
//
//  
//        }
//    return c;
//    }
    
//    public Course getCourseById(int id){
//    Course c=new Course();
//    session=weightTrackerUtil.getSessionFactory().openSession();
//        session.getTransaction().begin();
//        User u=(User) session.get(User.class,id);
//         Iterator<Course> ui = u.getCourses().iterator();
//         if(ui.hasNext())
//             c=ui.next();
//       
// return c;
// }
    
}