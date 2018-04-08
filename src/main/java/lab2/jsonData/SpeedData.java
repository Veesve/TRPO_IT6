package lab2.jsonData;


import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;



public class SpeedData {
    private static SpeedData instance;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    @SerializedName("startDate")
    private final Date startDate = new GregorianCalendar(2015, 8,15).getTime();
    @SerializedName("end_date")
    private final Date end_date = new GregorianCalendar(2016,12,5).getTime();

    @SerializedName("num_records")
    private  int numRecords;
    @SerializedName("min_speed")
    private double minSpeed;
    @SerializedName("min_time")
    private Date minTime;
    @SerializedName("max_speed")
    private double maxSpeed;
    @SerializedName("max_time")
    private Date maxTime;
    @SerializedName("average_speed")
    private double averageSpeed;

    private SpeedData() {
        minSpeed = -1.0;
        minTime = null;
        maxSpeed = 0.0 ;
        maxTime = null;
        averageSpeed = 0.0;
        numRecords = 0;
    }

    public static SpeedData getInstance() {
        if(instance == null) {
            instance = new SpeedData();
        }
        return instance;
    }

    public void processData(OceanData oceanData) throws ParseException {
        boolean isSpeedValid = oceanData.getCurrent_speec_qc() == 0;

        if(isSpeedValid) {
            numRecords++;
            double tempSpeed = oceanData.getCurrent_speed();
            if(maxSpeed == 0.0 || tempSpeed > maxSpeed) {
                maxSpeed = tempSpeed;
                maxTime = dateFormat.parse(oceanData.getTime());
            }
            if(minSpeed == -1.0 || (tempSpeed < minSpeed)){
                minSpeed = tempSpeed;
                minTime = dateFormat.parse(oceanData.getTime());
            }
            averageSpeed+=tempSpeed;
        }
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public int getNum_records() {
        return numRecords;
    }

    public double getMinSpeed() {
        return minSpeed;
    }

    public Date getMinTime() {
        return minTime;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public Date getMaxTime() {
        return maxTime;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setNum_records(int num_records) {
        this.numRecords = num_records;
    }

    public void setMinSpeed(double minSpeed) {
        this.minSpeed = minSpeed;
    }

    public void setMinTime(Date minTime) {
        this.minTime = minTime;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setMaxTime(Date maxTime) {
        this.maxTime = maxTime;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }
}