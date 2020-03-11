
package weightTrackerDao;

import weightTrackerPojo.Meal;
import weightTrackerUtil.weightTrackerUtil;


public class MealDao extends WeightTrackerDao<Meal> {
    
      public Meal find(Meal value) {
        return find(value, value.getMealId()); 
    }

    @Override
    public void delete(Meal value) {
        super.delete(find(value)); 
    }

    @Override
    public void update(Meal value) {
        session=weightTrackerUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Meal e=(Meal) session.get(value.getClass(),value.getMealId());
        
        if(e!=null){
        e.setMealName(value.getMealName());
        e.setMealUnit(value.getMealUnit());
        e.setCalorieValue(value.getCalorieValue());
        session.update(e);
        session.getTransaction().commit();
        }
         
    }
    
}
