
package weightTrackerConroller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import weightTrackerDao.UserDao;
import weightTrackerPojo.User;
import weightTrackerReport.Report;


@ManagedBean
@RequestScoped
public class ReportController {

    ArrayList<Report> reports=new ArrayList<Report>();
    UserDao userDao=new UserDao();
    User users=new User();

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
    
    public ArrayList<Report> getReports() {
        return reports;
    }

    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }
    
   public void viewReport() {
 
   reports=(ArrayList<Report>) userDao.getReportData(users.getUserId());
   //reports=(ArrayList<Report>) userDao.getReportData(Integer.parseInt("7"));
    }
    public ReportController() {
    }
    
}
