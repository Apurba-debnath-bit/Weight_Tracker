/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weightTrackerDao;

import weightTrackerPojo.Exercisedailylog;
import weightTrackerUtil.weightTrackerUtil;

/**
 *
 * @author Partho Debnath
 */
public class ExerciseDailyLogDao extends WeightTrackerDao<Exercisedailylog> {
    public Exercisedailylog find(Exercisedailylog value) {
        return find(value, value.getExerciseDailyLogId()); 
    }

    @Override
    public void delete(Exercisedailylog value) {
        super.delete(find(value)); 
    }

    @Override
    public void update(Exercisedailylog value) {
        session=weightTrackerUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Exercisedailylog ed=(Exercisedailylog) session.get(value.getClass(),value.getExerciseDailyLogId());
        if(ed!=null){
        ed.setDailylog(value.getDailylog());
        ed.setExercise(value.getExercise());
        ed.setTotalUnitBurnt(value.getTotalUnitBurnt());
        session.update(ed);
        session.getTransaction().commit();
        }
         
    }
    
    
}
