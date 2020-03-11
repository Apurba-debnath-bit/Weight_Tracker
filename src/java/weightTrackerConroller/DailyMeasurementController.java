
package weightTrackerConroller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import weightTrackerDao.DailyLogDao;
import weightTrackerDao.DailyMeasurementDao;
import weightTrackerPojo.DailyMeasurement;
import weightTrackerPojo.Dailylog;
import weightTrackerPojo.User;


@ManagedBean
@RequestScoped
public class DailyMeasurementController {

    
    public DailyMeasurementController() {
    }
    public DailyMeasurement dailymeasurement = new DailyMeasurement();
    public ArrayList<DailyMeasurement> dailymeasurements = new ArrayList<DailyMeasurement>();
    DailyMeasurementDao DailyMeasurementDao = new DailyMeasurementDao();
    public String msg = "";

    public Dailylog dailylog=new Dailylog();
    ArrayList<SelectItem> selectItemsDailylog =new ArrayList<SelectItem>();
    DailyLogDao dailyLogDao = new DailyLogDao();
    User users=new User();
   
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

    public DailyMeasurement getDailyMeasurement() {
        return dailymeasurement;
    }

    public void setDailyMeasurement(DailyMeasurement dailymeasurement) {
        this.dailymeasurement = dailymeasurement;
    }

    public ArrayList<DailyMeasurement> getDailyMeasurements() {
        return dailymeasurements;
    }

    public void setDailyMeasurements(ArrayList<DailyMeasurement> dailymeasurements) {
        this.dailymeasurements = dailymeasurements;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void save() {
        
        //dailymeasurement.setDailylog(dailylog);
        DailyMeasurementDao.save(dailymeasurement);
        setMsg("Daily Measurement saved");
        clear();
        
    }

    public void delete() {
        DailyMeasurementDao.delete(dailymeasurement);
        setMsg("Daily Measurement deleted");
        clear();
    }

    public void update() {

       DailyMeasurementDao.update(dailymeasurement);
        setMsg("Daily Measurement  updated");
        clear();
    }

    public void find() {
        DailyMeasurement u = DailyMeasurementDao.find(dailymeasurement);
        if (u != null) {
            dailymeasurement.setMeasurementDate(u.getMeasurementDate());
            dailymeasurement.setMeasurementShift(u.getMeasurementShift());
            dailymeasurement.setWeightValue(u.getWeightValue());
            dailymeasurement.setWaistSize(u.getWaistSize());
            dailymeasurement.setDailylog(u.getDailylog());
            
        } else {
            setMsg("Daily Measurement is  not found!!");
        }
    }

    public void display() {
       dailymeasurements = DailyMeasurementDao.getAll(dailymeasurement);
    }

    public void newDailyMeasurement() {
        dailymeasurement = new DailyMeasurement();
    }
    
    public void selectDailyLog() {
    dailylog=dailyLogDao.getDailylogById(users.getUserId());
        System.out.println(""+dailylog.getDailyLogId());
    }
    
    public ArrayList<SelectItem> getDailyMeasurementCombo(){

    ArrayList<SelectItem> dailyMeasurementCombo=new ArrayList<SelectItem>();
    for(DailyMeasurement dmt:DailyMeasurementDao.getAll(dailymeasurement)){
    dailyMeasurementCombo.add(new SelectItem(dmt.getMeasurementId()));

    }

    return dailyMeasurementCombo;
    }
    public void clear(){
    
    dailymeasurement.setMeasurementId(null);
    dailymeasurement.setMeasurementDate(null);
    dailymeasurement.setMeasurementShift(null);
    dailymeasurement.setWaistSize(null);
    dailymeasurement.setWeightValue(null);
    
    }
}
