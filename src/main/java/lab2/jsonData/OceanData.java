package lab2.jsonData;

public class OceanData {
    private String station;
    private String mooring_site_desc;
    private float water_depth;
    private String time;
    private float current_speed;
    private byte current_speec_qc;
    private float current_direction;
    private byte current_direction_qc;
    private float current_u;
    private byte current_u_qc;
    private float current_v;
    private byte current_v_qc;
    private float temperature;
    private byte temperature_qc;
    private float conductivity;
    private byte conductivity_qc;
    private float salinity;
    private byte salinity_qc;
    private float sigma_t;
    private byte sigma_t_qc;
    private String time_created;
    private String time_modified;
    private float longtitude;
    private float latitude;
    private float depth;

    public OceanData(String station, String mooring_site_desc,
                     float water_depth, String time,
                     float current_speed, byte current_speec_qc,
                     float current_direction, byte current_direction_qc,
                     float current_u, byte current_u_qc, float current_v,
                     byte current_v_qc, float temperature,
                     byte temperature_qc, float conductivity,
                     byte conductivity_qc, float salinity,
                     byte salinity_qc, float sigma_t,
                     byte sigma_t_qc, String time_created,
                     String time_modified,
                     float longtitude,
                     float latitude,
                     float depth) {
        this.station = station;
        this.mooring_site_desc = mooring_site_desc;
        this.water_depth = water_depth;
        this.time = time;
        this.current_speed = current_speed;
        this.current_speec_qc = current_speec_qc;
        this.current_direction = current_direction;
        this.current_direction_qc = current_direction_qc;
        this.current_u = current_u;
        this.current_u_qc = current_u_qc;
        this.current_v = current_v;
        this.current_v_qc = current_v_qc;
        this.temperature = temperature;
        this.temperature_qc = temperature_qc;
        this.conductivity = conductivity;
        this.conductivity_qc = conductivity_qc;
        this.salinity = salinity;
        this.salinity_qc = salinity_qc;
        this.sigma_t = sigma_t;
        this.sigma_t_qc = sigma_t_qc;
        this.time_created = time_created;
        this.time_modified = time_modified;
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.depth = depth;
    }

    public OceanData(String[] fields) {
        station = fields[0];
        mooring_site_desc = fields[1];
        water_depth = Float.parseFloat(fields[2]);
        time = fields[3];
        current_speed = Float.parseFloat(fields[4]);
        current_speec_qc = Byte.parseByte(fields[5]);
        current_direction = Float.parseFloat(fields[6]);
        current_direction_qc = Byte.parseByte(fields[7]);
        current_u = Float.parseFloat(fields[8]);
        current_u_qc = Byte.parseByte(fields[9]);
        current_v = Float.parseFloat(fields[10]);
        current_v_qc = Byte.parseByte(fields[11]);
        temperature = Float.parseFloat(fields[12]);
        temperature_qc = Byte.parseByte(fields[13]);
        conductivity = Float.parseFloat(fields[14]);
        conductivity_qc = Byte.parseByte(fields[15]);
        salinity = Float.parseFloat(fields[16]);
        salinity_qc = Byte.parseByte(fields[17]);
        sigma_t = Float.parseFloat(fields[18]);
        sigma_t_qc = Byte.parseByte(fields[19]);
        time_created = fields[20];
        time_modified = fields[21];
        longtitude = Float.parseFloat(fields[22]);
        latitude = Float.parseFloat(fields[23]);
        depth = Float.parseFloat(fields[24]);

    }

    public String getStation() {
        return station;
    }

    public String getMooring_site_desc() {
        return mooring_site_desc;
    }

    public float getWater_depth() {
        return water_depth;
    }

    public String getTime() {
        return time;
    }

    public float getCurrent_speed() {
        return current_speed;
    }

    public byte getCurrent_speec_qc() {
        return current_speec_qc;
    }

    public float getCurrent_direction() {
        return current_direction;
    }

    public byte getCurrent_direction_qc() {
        return current_direction_qc;
    }

    public float getCurrent_u() {
        return current_u;
    }

    public byte getCurrent_u_qc() {
        return current_u_qc;
    }

    public float getCurrent_v() {
        return current_v;
    }

    public byte getCurrent_v_qc() {
        return current_v_qc;
    }

    public float getTemperature() {
        return temperature;
    }

    public byte getTemperature_qc() {
        return temperature_qc;
    }

    public float getConductivity() {
        return conductivity;
    }

    public byte getConductivity_qc() {
        return conductivity_qc;
    }

    public float getSalinity() {
        return salinity;
    }

    public byte getSalinity_qc() {
        return salinity_qc;
    }

    public float getSigma_t() {
        return sigma_t;
    }

    public byte getSigma_t_qc() {
        return sigma_t_qc;
    }

    public String getTime_created() {
        return time_created;
    }

    public String getTime_modified() {
        return time_modified;
    }

    public float getLongtitude() {
        return longtitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getDepth() {
        return depth;
    }

    @Override
    public String toString() {
        return "OceanData{" +
                "station='" + station + '\'' +
                ", mooring_site_desc='" + mooring_site_desc + '\'' +
                ", water_depth=" + water_depth +
                ", time='" + time + '\'' +
                ", current_speed=" + current_speed +
                ", current_speec_qc=" + current_speec_qc +
                ", current_direction=" + current_direction +
                ", current_direction_qc=" + current_direction_qc +
                ", current_u=" + current_u +
                ", current_u_qc=" + current_u_qc +
                ", current_v=" + current_v +
                ", current_v_qc=" + current_v_qc +
                ", temperature=" + temperature +
                ", temperature_qc=" + temperature_qc +
                ", conductivity=" + conductivity +
                ", conductivity_qc=" + conductivity_qc +
                ", salinity=" + salinity +
                ", salinity_qc=" + salinity_qc +
                ", sigma_t=" + sigma_t +
                ", sigma_t_qc=" + sigma_t_qc +
                ", time_created='" + time_created + '\'' +
                ", time_modified='" + time_modified + '\'' +
                ", longtitude=" + longtitude +
                ", latitude=" + latitude +
                ", depth=" + depth +
                '}';
    }
}