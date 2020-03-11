
package weightTrackerConroller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import weightTrackerDao.UserDao;
import weightTrackerPojo.User;
import weightTrackerReport.NewReport;



@ManagedBean
@RequestScoped
public class ReportChartController implements Serializable {

private LineChartModel dateModel=new LineChartModel();
    private NewReport newreport = new NewReport();
    //Arraylist<Report> reports=new Arraylist<Report>();
    private List<NewReport> newreports = new ArrayList<NewReport>();
    private User user = new User();
    private UserDao userdao = new UserDao();
  
    ArrayList<SelectItem> selectItemsUser =new ArrayList<SelectItem>();
    UserDao userDao=new UserDao();

    public NewReport getNewreport() {
        return newreport;
    }

    public void setNewreport(NewReport newreport) {
        this.newreport = newreport;
    }

    public List<NewReport> getNewreports() {
        return newreports;
    }

    public void setNewreports(List<NewReport> newreports) {
        this.newreports = newreports;
    }
    

//   public ArrayList<SelectItem> getSelectItemsUser() {
//        selectItemsUser.clear();
//        selectItemsUser=new ArrayList<SelectItem>();
//        for(User u : userDao.getAll(user)){
//            selectItemsUser.add(new SelectItem(u.getUserId(), u.getUserName()));
//        }
//        return selectItemsUser;
//    }
   
   public ArrayList<SelectItem> getUserCombo(){

    ArrayList<SelectItem> userCombo=new ArrayList<SelectItem>();
    for(User u:userDao.getAll(user)){
    userCombo.add(new SelectItem(u.getUserId()));

    }

    return userCombo;
    }

    public void setSelectUser(ArrayList<SelectItem> selectUser) {
        this.selectItemsUser = selectUser;
    }
    
    

  

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
   public void selectUser(){
    newreports = userDao.getReportChartData(user.getUserId());
   
   }

   
    public LineChartModel getDateModel() {
        return dateModel;
    }
     public void newReport(){
       newreport = new NewReport();
   }
     
    public void createDateModel() {
       // System.out.println("create model");
        newreports = userDao.getReportChartData(user.getUserId());
        dateModel = new LineChartModel();
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Caloric inkate");
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Burncalory ");
        LineChartSeries series3 = new LineChartSeries();
        series3.setLabel("Deficited ");
      for(NewReport r:newreports)
      {
      series1.set(r.getDailylogdate(), r.getTotalGainCalorie());
      series2.set(r.getDailylogdate(), r.getTotalBurnCalorie());
      series3.set(r.getDailylogdate(), r.getTotalGainCalorie()-r.getTotalBurnCalorie());
          System.out.println("............"+r);
     }
        dateModel.addSeries(series1);
        dateModel.addSeries(series2);
        dateModel.addSeries(series3);
        dateModel.setTitle("Zoom for Details");
        dateModel.setZoom(true);
        dateModel.getAxis(AxisType.Y).setLabel("Values");
        DateAxis axis = new DateAxis("Dates");
        axis.setTickAngle(-50);
        axis.setMax("2018-01-31");
        axis.setTickFormat("%b %#d, %y");
         
        dateModel.getAxes().put(AxisType.X, axis);
    }
    
    
    public static void main(String[] args) {
        ReportChartController pController=new ReportChartController();
        pController.createDateModel();
        
    }
    
   
    
}
