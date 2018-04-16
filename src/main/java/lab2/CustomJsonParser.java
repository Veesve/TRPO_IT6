package lab2;



import com.google.gson.*;
import lab2.jsonData.OceanData;
import lab2.jsonData.SalnityData;
import lab2.jsonData.SpeedData;
import lab2.jsonData.TemperatureData;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomJsonParser {



    public static void main(String[] args) throws Exception {
        //args[0] is relative path to JSON file. Might be configured by user if
        // laucnhed from terminal or changed in arguments
        //src/main/resources/E05_aanderaa_all_1769_d432_5004.json to work with resources file

        String jsonString = readJsonFromFile(args[0]);
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(jsonString);
        List<OceanData> oceanDataList = createListFromJson(element);
        System.out.println(oceanDataList.size());


        SpeedData speedData = SpeedData.getInstance();
        SalnityData salnityData = SalnityData.getInstance();
        TemperatureData temperatureData = TemperatureData.getInstance();

        for (OceanData tempOceanData : oceanDataList) {
            speedData.processData(tempOceanData);
            salnityData.processData(tempOceanData);
            temperatureData.processData(tempOceanData);
        }

        System.out.println(gson.toJson(salnityData));
        System.out.println(gson.toJson(temperatureData));
        System.out.println(gson.toJson(speedData));

    }

    private static List<OceanData> createListFromJson(JsonElement element) {
        List<OceanData> oceanDataList = new ArrayList<>();
        if (element.isJsonObject()) {
            JsonObject table = element.getAsJsonObject().getAsJsonObject("table"); //parsing through lines to get table object
            JsonArray rows = table.getAsJsonArray("rows");

            for (int i = 0; i < rows.size(); i++) {
                String[] rowFields = getRowFields(rows, i);
                OceanData tempOceanData = new OceanData(rowFields);
                oceanDataList.add(tempOceanData);
            }
        }
        return oceanDataList;
    }

    private static String[] getRowFields(JsonArray rows, int i) {
        return rows.get(i).toString().
                replaceAll("\\\"", "").
                replaceAll("]", "").
                split(",");
    }


    private static String readJsonFromFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder builder = new StringBuilder();

        while (reader.ready()) {
            builder.append(reader.readLine()); //constructing String
        }

        return builder.toString();
    }


}
