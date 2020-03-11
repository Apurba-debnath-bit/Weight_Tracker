
package weightTrackerConroller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import weightTrackerDao.MealDao;
import weightTrackerPojo.Meal;



@ManagedBean
@RequestScoped
public class MealController {

    
    public MealController() {
    }
       
    public Meal meal = new Meal();
    public ArrayList<Meal> meals = new ArrayList<Meal>();
    MealDao MealDao = new MealDao();
    public String msg = "";

    
   

    public Meal getMeal() {
        return meal;
    }

    public void setUser(Meal meal) {
        this.meal = meal;
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public void setUserses(ArrayList<Meal> userses) {
        this.meal = meal;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void save() {

        MealDao.save(meal);
        setMsg("Meal saved");
        clear();
    }

    public void delete() {
        MealDao.delete(meal);
        setMsg("Meal deleted");
        clear();
    }

    public void update() {

        MealDao.update(meal);
        setMsg("Meal updated");
        clear();
    }

    public void find() {
        Meal m = MealDao.find(meal);
        if (m != null) {
            meal.setMealName(m.getMealName());
            meal.setMealUnit(m.getMealUnit());
            meal.setCalorieValue(m.getCalorieValue());
            
           
        } else {
            setMsg("Meal not found");
        }
        
    }
    public void clear(){
    meal.setMealId(null);
    meal.setMealName(null);
    meal.setMealUnit(null);
    meal.setCalorieValue(null);
    }
    public void display() {
        meals = MealDao.getAll(meal);
        clear();
    }

    public void newMeal() {
        meal = new Meal();
    }
    public ArrayList<SelectItem> getMealCombo() {

        ArrayList<SelectItem>mealCombo = new ArrayList<SelectItem>();
        for (Meal m : MealDao.getAll(meal)) {
            mealCombo.add(new SelectItem(m.getMealId(), m.getMealName()));

        }

        return mealCombo;
    }
}
