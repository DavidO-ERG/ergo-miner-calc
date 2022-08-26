package portugal.ergo.tools;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Scanner;

public class Apis {

    public static JSONObject makeApiCall(String apiName, URL apiUrl) {
        try {
            // Call to an API
            HttpURLConnection req = (HttpURLConnection) apiUrl.openConnection();
            req.setRequestMethod("GET");
            req.setConnectTimeout(5000);
            req.setReadTimeout(5000);
            req.connect();

            // Validate request and if successful, returns data
            if (req.getResponseCode() != 200) {
                throw new RuntimeException("HttpResponseCode: " + req.getResponseCode());
            } else {
                Scanner scanInput = new Scanner(apiUrl.openStream());
                StringBuilder data = new StringBuilder();

                while (scanInput.hasNext()) {
                    data.append(scanInput.nextLine());
                }
                scanInput.close();

                JSONParser jsonparser = new JSONParser();
                Object obj = jsonparser.parse(data.toString());

                // Save to file
                BufferedWriter theWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/Status_API-" + apiName + ".json"));
                theWriter.write(obj.toString());
                theWriter.close();

                return (JSONObject) obj;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }
}
