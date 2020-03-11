
package weightTrackerConroller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import weightTrackerDao.DailyLogDao;
import weightTrackerDao.ExerciseDailyLogDao;
import weightTrackerDao.ExerciseDao;
import weightTrackerPojo.Dailylog;
import weightTrackerPojo.Exercise;
import weightTrackerPojo.Exercisedailylog;
import weightTrackerPojo.User;


@ManagedBean
@RequestScoped
public class ExerciseDailyLogController {

    
    public ExerciseDailyLogController() {
    }
    public Exercisedailylog exerciseDailylog = new Exercisedailylog();
    public ArrayList<Exercisedailylog> exerciseDailylogs = new ArrayList<Exercisedailylog>();
    ExerciseDailyLogDao ExerciseDailyLogDao = new ExerciseDailyLogDao();
    public String msg = "";

    public Dailylog dailylog=new Dailylog();
    ArrayList<SelectItem> selectItemsDailylog =new ArrayList<SelectItem>();
    DailyLogDao dailyLogDao = new DailyLogDao();
    public Exercise excercise =new Exercise();
    ArrayList<SelectItem> selectItemsExercise =new ArrayList<SelectItem>();
    ExerciseDao exerciseDao =new ExerciseDao();
    User users=new  User();

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
    
   

    public Dailylog getDailylog() {
        return dailylog;
    }

    public void setDailylog(Dailylog dailylog) {
        this.dailylog = dailylog;
    }

    public ArrayList<SelectItem> getSelectItemsDailylog() {
        
        return selectItemsDailylog;
    }

    public void setSelectItemsDailylog(ArrayList<SelectItem> selectItemsDailylog) {
        this.selectItemsDailylog = selectItemsDailylog;
    }

   public Exercise getExcercise() {
        return excercise;
    }

    public void setExcercise(Exercise excercise) {
        this.excercise = excercise;
    }

    public ArrayList<SelectItem> getSelectItemsExercise() {
        selectItemsExercise.clear();
        for(Exercise e: exerciseDao.getAll(excercise)){
            selectItemsExercise.add(new SelectItem(e.getExerciseId(), e.getExerciseType()));
        }
        return selectItemsExercise;
    }

    public void setSelectItemsExercise(ArrayList<SelectItem> selectItemsExercise) {
        this.selectItemsExercise = selectItemsExercise;
    }


    public Exercisedailylog getExerciseDailylog() {
        return exerciseDailylog;
    }

    public void setExerciseDailylog(Exercisedailylog exerciseDailylog) {
        this.exerciseDailylog = exerciseDailylog;
    }

    public ArrayList<Exercisedailylog> getExerciseDailylogs() {
        return exerciseDailylogs;
    }

    public void setExerciseDailylogs(ArrayList<Exercisedailylog> exerciseDailylogs) {
        this.exerciseDailylogs = exerciseDailylogs;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void save() {
        //exerciseDailylog.setDailylog(dailylog);
        ExerciseDailyLogDao.save(exerciseDailylog);
        setMsg("Daily exercise has been saved");
        clear();
        
    }

    public void delete() {
       ExerciseDailyLogDao.delete(exerciseDailylog);
        setMsg("Daily exercise has been deleted");
        clear();
        
    }

    public void update() {

       ExerciseDailyLogDao.update(exerciseDailylog);
        setMsg("Daily exercise has been updated");
        clear();
        
    }

    public void find() {
        Exercisedailylog u = ExerciseDailyLogDao.find(exerciseDailylog);
        if (u != null) {
            exerciseDailylog.setExercise(u.getExercise());
            exerciseDailylog.setDailylog(u.getDailylog());
            exerciseDailylog.setTotalUnitBurnt(u.getTotalUnitBurnt());
            
            
        } else {
            setMsg("Sorry!! This Daily exercise is not found!!");
        }
    }

    public void display() {
      exerciseDailylogs = ExerciseDailyLogDao.getAll(exerciseDailylog);
      clear();
      
    }
     public void clear(){
       exerciseDailylog.setExerciseDailyLogId(null);
        
       exerciseDailylog.setTotalUnitBurnt(null);
       }
    public void newExercisedailylog() {
      exerciseDailylog = new Exercisedailylog();
    }
//    public void selectDailylog() {
//    dailylog=dailyLogDao.getDailylogById(users.getUserId());
//    }
    public ArrayList<SelectItem> getDailyExerciseCombo(){

    ArrayList<SelectItem> dailyExerciseCombo=new ArrayList<SelectItem>();
    for(Exercisedailylog de:ExerciseDailyLogDao.getAll(exerciseDailylog)){
    dailyExerciseCombo.add(new SelectItem(de.getExerciseDailyLogId()));

    }

    return dailyExerciseCombo;
    }
    
   
}
