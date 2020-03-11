
package weightTrackerConroller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import weightTrackerDao.ExerciseDao;
import weightTrackerPojo.Exercise;


@ManagedBean
@RequestScoped
public class ExerciseController {

   
    public ExerciseController() {
    }
    public Exercise exercise = new Exercise();
    public ArrayList<Exercise> exercises = new ArrayList<Exercise>();
    ExerciseDao ExerciseDao = new ExerciseDao();
    public String msg = "";

    
   

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void save() {

      ExerciseDao.save(exercise);
        setMsg("Exercise saved");
        clear();
    }

    public void delete() {
        ExerciseDao.delete(exercise);
        setMsg("Exercise deleted");
        clear();
    }

    public void update() {

       ExerciseDao.update(exercise);
        setMsg("Exercise updated");
        clear();
    }

    public void find() {
        Exercise u = ExerciseDao.find(exercise);
        if (u != null) {
            exercise.setExerciseType(u.getExerciseType());
            exercise.setExerciseDuration(u.getExerciseDuration());
            exercise.setCalorieBurnt(u.getCalorieBurnt());
            
            
        } else {
            setMsg("Sorry!! This exercise type is not found!!");
        }
    }

    public void display() {
       exercises = ExerciseDao.getAll(exercise);
       clear();
    }

    public void newExercise() {
        exercise = new Exercise();
    }
    public void clear(){
    exercise.setExerciseId(null);
    exercise.setExerciseType(null);
    exercise.setExerciseDuration(null);
    exercise.setCalorieBurnt(null);
    
    }
    
public ArrayList<SelectItem> getExerciseCombo(){

ArrayList<SelectItem> exerciseCombo=new ArrayList<SelectItem>();
for(Exercise e:ExerciseDao.getAll(exercise)){
exerciseCombo.add(new SelectItem(e.getExerciseId()));

}

return exerciseCombo;
}
}
