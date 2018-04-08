package lab2.jsonData;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class TemperatureData {
    private static TemperatureData instance;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    @SerializedName("start_date")
    private final Date startDate = new GregorianCalendar(2015, 8, 15).getTime();
    @SerializedName("end_date")
    private final Date endDate = new GregorianCalendar(2016, 12, 5).getTime();
    @SerializedName("num_records")
    private int numRecords;
    @SerializedName("min_temperature")
    private double minTemperature;
    @SerializedName("min_time")
    private Date minTime;
    @SerializedName("max_temperature")
    private double maxTemperature;
    @SerializedName("max_time")
    private Date maxTime;
    @SerializedName("average_temperature")
    private double averageTemperature;

    private TemperatureData() {
        minTemperature = -1.0;
        minTime = null;
        maxTemperature = 0.0;
        maxTime = null;
        averageTemperature = 0.0;
        numRecords = 0;
    }

    public static TemperatureData getInstance() {
        if (instance == null) {
            instance = new TemperatureData();
        }
        return instance;
    }

    public void processData(OceanData oceanData) throws ParseException {
        boolean isTemperatureValid = oceanData.getTemperature_qc() == 0;
        if (isTemperatureValid) {
            numRecords++;
            double tempTemperature = oceanData.getTemperature();
            if (maxTemperature == 0.0 || tempTemperature > maxTemperature) {
                maxTemperature = tempTemperature;
                maxTime = dateFormat.parse(oceanData.getTime());
            }
            if (minTemperature == -1.0 || tempTemperature < minTemperature) {
                minTemperature = tempTemperature;
                minTime = dateFormat.parse(oceanData.getTime());
            }
            averageTemperature += tempTemperature;
        }
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

    public double getMinTemperature() {
        return minTemperature;
    }

    public Date getMinTime() {
        return minTime;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public Date getMaxTime() {
        return maxTime;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public void setNumRecords(int numRecords) {
        this.numRecords = numRecords;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public void setMinTime(Date minTime) {
        this.minTime = minTime;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public void setMaxTime(Date maxTime) {
        this.maxTime = maxTime;
    }

    public void setAverageTemperature(double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }
}