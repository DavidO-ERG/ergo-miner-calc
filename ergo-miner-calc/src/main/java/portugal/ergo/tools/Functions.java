package portugal.ergo.tools;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Functions {

    public static double kwPerHour(double _userWattsHour, double _userHours) {
        return (_userWattsHour / 1000) * _userHours;
    }

    public static double dailyBlockRewards(double _networkBlockRewards, double _networkBlockTime) {
        int minutesPerDay = 1440;
        return _networkBlockRewards * (minutesPerDay / _networkBlockTime);
    }

    public static double dailyBlockRewardsInValue(double _networkBlockRewards, double _ergoPrice, double _networkBlockTime) {
        return dailyBlockRewards(_networkBlockRewards, _networkBlockTime) * _ergoPrice;
    }

    public static double dailyCost(double _userWattsHour, double _userHours, double _userPriceKwHour) {
        return kwPerHour(_userWattsHour, _userHours) * _userPriceKwHour;
    }

    public static double dailyReturns(double _networkBlockRewards, double _ergoPrice, double _networkHashrate, double _userHashrate, double _networkBlockTime) {
        return (dailyBlockRewardsInValue(_networkBlockRewards, _ergoPrice, _networkBlockTime) / _networkHashrate) * _userHashrate;
    }

    static double minedTokenShare(double _userHashrate, double _networkHashrate) {
        return _userHashrate / _networkHashrate;
    }

    public static double minedReturnsErg(double _networkBlockRewards, double _userHashrate, double _networkHashrate, double _networkBlockTime) {
        return dailyBlockRewards(_networkBlockRewards, _networkBlockTime) * minedTokenShare(_userHashrate, _networkHashrate);
    }


    public static void saveFarmStats(String date, double[] lista) {
        try {
            String[] arrayName = {"ergoPrice", "userHashrate", "userWattsHour", "userHours", "userPriceKwHour", "networkBlockTime", "networkBlockRewards", "networkHashrate", "farmRevenue", "farmCost", "farmProfit", "farmMined"};

            BufferedWriter theWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/Status_Miner-Farm.json"));
            theWriter.append("{\"date\" :").append("\"" + date + "\"");
            for (int i = 0; i < lista.length; i++) {
                theWriter.append(",\"" +arrayName[i]+ "\"").append(":").append(String.valueOf(lista[i]));
            }
            theWriter.append("}");
            theWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
