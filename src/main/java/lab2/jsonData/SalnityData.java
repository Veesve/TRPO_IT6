package lab2.jsonData;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class SalnityData {
    private static SalnityData instance;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    @SerializedName("start_date")
    private Date startDate = new GregorianCalendar(2015, 8, 15).getTime();
    @SerializedName("end_date")
    private Date endDate = new GregorianCalendar(2016, 12, 5).getTime();
    @SerializedName("num_records")
    private int numRecords;
    @SerializedName("min_salnity")
    private double minSalnity;
    @SerializedName("min_time")
    private Date minTime;
    @SerializedName("max_salnity")
    private double maxSalnity;
    @SerializedName("max_time")
    private Date maxTime;
    @SerializedName("average_salnity")
    private double averageSalnity;

    private SalnityData() {
        minSalnity = -1.0;
        minTime = null;
        maxSalnity = 0.0;
        maxTime = null;
        averageSalnity = 0.0;
        numRecords = 0;
    }

    public static SalnityData getInstance() {
        if (instance == null) {
            instance = new SalnityData();
        }
        return instance;
    }

    public void processData(OceanData oceanData) throws ParseException {
        boolean isSalnityValid = oceanData.getSalinity_qc() == 0;
        if (isSalnityValid) {
            numRecords++;
            double tempSalnity = oceanData.getSalinity();
            if (maxSalnity == 0.0 || tempSalnity > maxSalnity) {
                maxSalnity = tempSalnity;
                maxTime = dateFormat.parse(oceanData.getTime());
            }
            if (minSalnity == -1.0 || tempSalnity < minSalnity) {
                minSalnity = tempSalnity;
                minTime = dateFormat.parse(oceanData.getTime());
            }
            averageSalnity += tempSalnity;
        }
    }

    public void setNumRecords(int numRecords) {
        this.numRecords = numRecords;
    }

    public void setMinSalnity(double minSalnity) {
        this.minSalnity = minSalnity;
    }

    public void setMinTime(Date minTime) {
        this.minTime = minTime;
    }

    public void setMaxSalnity(double maxSalnity) {
        this.maxSalnity = maxSalnity;
    }

    public void setMaxTime(Date maxTime) {
        this.maxTime = maxTime;
    }

    public void setAverageSalnity(double averageSalnity) {
        this.averageSalnity = averageSalnity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getNumRecords() {
        return numRecords;
    }

    public double getMinSalnity() {
        return minSalnity;
    }

    public Date getMinTime() {
        return minTime;
    }

    public double getMaxSalnity() {
        return maxSalnity;
    }

    public Date getMaxTime() {
        return maxTime;
    }

    public double getAverageSalnity() {
        return averageSalnity;
    }
}
