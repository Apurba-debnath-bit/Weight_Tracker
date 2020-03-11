/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weightTrackerDao;

import weightTrackerPojo.DailyMeasurement;
import weightTrackerUtil.weightTrackerUtil;

/**
 *
 * @author Partho Debnath
 */
public class DailyMeasurementDao extends WeightTrackerDao<DailyMeasurement>{
    public DailyMeasurement find(DailyMeasurement value) {
        return find(value, value.getMeasurementId()); 
    }

    @Override
    public void delete(DailyMeasurement value) {
        super.delete(find(value)); 
    }

    @Override
    public void update(DailyMeasurement value) {
        session=weightTrackerUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        DailyMeasurement dm=(DailyMeasurement) session.get(value.getClass(),value.getMeasurementId());
        if(dm!=null){
        dm.setMeasurementDate(value.getMeasurementDate());
        dm.setMeasurementShift(value.getMeasurementShift());
        dm.setWeightValue(value.getWeightValue());
        dm.setWaistSize(value.getWaistSize());
        dm.setDailylog(value.getDailylog());// why????
        session.update(dm);
        session.getTransaction().commit();
        }
         
    }
    
}
