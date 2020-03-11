/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weightTrackerDao;

import weightTrackerPojo.Exercise;
import weightTrackerUtil.weightTrackerUtil;

/**
 *
 * @author Partho Debnath
 */
public class ExerciseDao extends WeightTrackerDao<Exercise> {
   public Exercise find(Exercise value) {
        return find(value, value.getExerciseId()); 
    }

    @Override
    public void delete(Exercise value) {
        super.delete(find(value)); 
    }

    @Override
    public void update(Exercise value) {
        session=weightTrackerUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Exercise e=(Exercise) session.get(value.getClass(),value.getExerciseId());
        
        if(e!=null){
        e.setExerciseType(value.getExerciseType());
        e.setExerciseDuration(value.getExerciseDuration());
        e.setCalorieBurnt(value.getCalorieBurnt());
        //e.setExercisedailylogs(value.getExercisedailylogs());                                                                    
        session.update(e);
        session.getTransaction().commit();
        }
         
    }
    
}
