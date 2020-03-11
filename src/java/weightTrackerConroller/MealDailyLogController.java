
package weightTrackerConroller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import weightTrackerDao.DailyLogDao;
import weightTrackerDao.MealDailyLogDao;
import weightTrackerDao.MealDao;
import weightTrackerPojo.Dailylog;
import weightTrackerPojo.Meal;
import weightTrackerPojo.Mealdailylog;
import weightTrackerPojo.User;


@ManagedBean
@RequestScoped
public class MealDailyLogController {



    
    public MealDailyLogController() {
    }
    
    private Mealdailylog mealdailylog = new Mealdailylog();
    private ArrayList<Mealdailylog> mealdailylogs = new ArrayList<Mealdailylog>();
    MealDailyLogDao mealDailyLogDao = new MealDailyLogDao();
    public String msg = "";

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    

    public Mealdailylog getDailyMeal() {
        return mealdailylog;
    }

    public void setDailyMeal(Mealdailylog dailyMeal) {
        this.mealdailylog = dailyMeal;
    }

    public ArrayList<Mealdailylog> getDailyMeals() {
        return mealdailylogs;
    }

    public void setDailyMeals(ArrayList<Mealdailylog> dailyMeals) {
        this.mealdailylogs = dailyMeals;
    }

    public void save() {
        mealDailyLogDao.save(mealdailylog);
        setMsg("DailyMeal Has been Saved");
        clear();
    }

    public void update() {
        mealDailyLogDao.update(mealdailylog);
        setMsg("DailyMeal Has been Updated");
        clear();
    }

    public void delete() {
        mealDailyLogDao.delete(mealdailylog);
        setMsg("DailyMeal Has been deleted");
        clear();
    }

    public void find() {
        Mealdailylog dm = mealDailyLogDao.find(mealdailylog, mealdailylog.getMealDailyLogId());
        if (dm != null) {
            
            mealdailylog.setDailylog(dm.getDailylog());
            mealdailylog.setMeal(dm.getMeal());
            mealdailylog.setTotalUnitTake(dm.getTotalUnitTake());
            
            
            
        } else {
            setMsg("DailyMeal Not found ");
        }
    }

    public void display() {
        mealdailylogs = mealDailyLogDao.getAll(mealdailylog);
        clear();

    }
    
    public void newDailyMeal(){
    mealdailylog=new Mealdailylog();
    }
    public ArrayList<SelectItem> getDailyMealCombo(){

    ArrayList<SelectItem> dailyMealCombo=new ArrayList<SelectItem>();
    for(Mealdailylog dm:mealDailyLogDao.getAll(mealdailylog)){
    dailyMealCombo.add(new SelectItem(dm.getMealDailyLogId()));

    }

return dailyMealCombo;
}
    
    public void clear(){
    
   
    mealdailylog.setMealDailyLogId(null);
    mealdailylog.setTotalUnitTake(null);
    } 
    
    
    
    
    
}
