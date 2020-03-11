/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weightTrackerDao;

import java.util.Iterator;
import org.hibernate.Session;
import weightTrackerPojo.Course;
import weightTrackerPojo.Dailylog;
import weightTrackerPojo.Mealdailylog;
import weightTrackerPojo.User;
import weightTrackerUtil.weightTrackerUtil;

/**
 *
 * @author Partho Debnath
 */
public class MealDailyLogDao extends WeightTrackerDao<Mealdailylog>{
    
    
    public Mealdailylog find(Mealdailylog value) {
        return find(value, value.getMealDailyLogId()); 
    }

    @Override
    public void delete(Mealdailylog value) {
        super.delete(find(value)); 
    }

    @Override
    public void update(Mealdailylog value) {
      session=weightTrackerUtil.getSessionFactory().openSession();
      session.getTransaction().begin();
      Mealdailylog md=(Mealdailylog) session.get(value.getClass(),value.getMealDailyLogId());
        if(md!=null)
       
        if(md!=null){
        md.setMeal(value.getMeal());
        md.setDailylog(value.getDailylog());
        md.setTotalUnitTake(value.getTotalUnitTake());
        session.update(md);
        session.getTransaction().commit();
        }
         
    }
    
    
}
