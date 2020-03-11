package weightTrackerPojo;
// Generated Jan 18, 2018 2:53:48 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;



public class User  implements java.io.Serializable {


     private Integer userId;
     private String userName;
     private Integer userAge;
     private String userGender;
     private Double userHeight;
     private Double userWeight;
     private Double bmiIndex;
     private Double userWaistSize;
     private Set courses = new HashSet(0);

    public User() {
    }

    public User(String userName, Integer userAge, String userGender, Double userHeight, Double userWeight, Double bmiIndex, Double userWaistSize, Set courses) {
       this.userName = userName;
       this.userAge = userAge;
       this.userGender = userGender;
       this.userHeight = userHeight;
       this.userWeight = userWeight;
       this.bmiIndex = bmiIndex;
       this.userWaistSize = userWaistSize;
       this.courses = courses;
    }
   
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Integer getUserAge() {
        return this.userAge;
    }
    
    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
    public String getUserGender() {
        return this.userGender;
    }
    
    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }
    public Double getUserHeight() {
        return this.userHeight;
    }
    
    public void setUserHeight(Double userHeight) {
        this.userHeight = userHeight;
    }
    public Double getUserWeight() {
        return this.userWeight;
    }
    
    public void setUserWeight(Double userWeight) {
        this.userWeight = userWeight;
    }
    public Double getBmiIndex() {
        return this.bmiIndex;
    }
    
    public void setBmiIndex(Double bmiIndex) {
        this.bmiIndex = bmiIndex;
    }
    public Double getUserWaistSize() {
        return this.userWaistSize;
    }
    
    public void setUserWaistSize(Double userWaistSize) {
        this.userWaistSize = userWaistSize;
    }
    public Set getCourses() {
        return this.courses;
    }
    
    public void setCourses(Set courses) {
        this.courses = courses;
    }




}


