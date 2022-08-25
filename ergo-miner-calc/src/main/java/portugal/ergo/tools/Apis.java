package portugal.ergo.tools;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Scanner;

public class Apis {

    public static double apiCallPrice() {
        try {
            URL apiPrice = new URL("https://api.tokenjay.app/tokens/prices/03faf2cb329f2e90d6d23b58d91bbb6c046aa143261cc21f52fbe2824bfcbf04");
            //URL apiPrice = new URL("https://api.coingecko.com/api/v3/coins/ergo?localization=false&tickers=true&market_data=false&community_data=false&developer_data=false&sparkline=false");
            HttpURLConnection reqPrice = (HttpURLConnection) apiPrice.openConnection();
            reqPrice.setRequestMethod("GET");
            reqPrice.setConnectTimeout(5000);
            reqPrice.setReadTimeout(5000);
            reqPrice.connect();

            if (reqPrice.getResponseCode() != 200) {
                throw new RuntimeException("HttpResponseCode: " + reqPrice.getResponseCode());
            } else {
                StringBuilder dataPrice = new StringBuilder();
                Scanner scanInput = new Scanner(apiPrice.openStream());

                while (scanInput.hasNext()) {
                    dataPrice.append(scanInput.nextLine());
                }
                scanInput.close();

                JSONParser jsonP = new JSONParser();
                Object jsonData = jsonP.parse(String.valueOf(dataPrice));
                JSONObject jsonFinal = (JSONObject) jsonData;


                try {
                    BufferedWriter theWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir")+"/Status_API-Price.json"));
                    theWriter.write(jsonFinal.toJSONString());
                    theWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return ((Long) jsonFinal.get("price")) / 100_000_000.00;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0.00;
        }

    }

    public static String[] apiCallNetwork() {
        try {
            URL apiNetwork = new URL("https://whattomine.com/coins/340.json");
            HttpURLConnection reqNetwork = (HttpURLConnection) apiNetwork.openConnection();
            reqNetwork.setRequestMethod("GET");
            reqNetwork.setConnectTimeout(5000);
            reqNetwork.setReadTimeout(5000);
            reqNetwork.connect();

            if (reqNetwork.getResponseCode() != 200) {
                throw new RuntimeException("HttpResponseCode: " + reqNetwork.getResponseCode());
            } else {
                StringBuilder dataNetwork = new StringBuilder();
                Scanner scanInput = new Scanner(apiNetwork.openStream());

                while (scanInput.hasNext()) {
                    dataNetwork.append(scanInput.nextLine());
                }
                scanInput.close();

                JSONParser jsonP = new JSONParser();
                Object jsonData = jsonP.parse(String.valueOf(dataNetwork));
                JSONObject jsonFinal = (JSONObject) jsonData;

                try {
                    BufferedWriter theWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir")+"/Status_API-Network.json"));
                    theWriter.write(jsonFinal.toJSONString());
                    theWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }


                return new String[]{jsonFinal.get("nethash").toString(), jsonFinal.get("block_reward").toString(), jsonFinal.get("block_time").toString()};
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new String[]{null};
        }
    }
}

