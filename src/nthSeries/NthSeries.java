package nthSeries;

public class NthSeries {

    public static String seriesSum(int series) {
        return String.format("%.2f", sum(series, 1, 0)).replace(",", ".");
    }

    private static float sum(int series, float count, float result){
        if(series == 0)
            return  result;
        return sum(series -1, count +3, result + 1/count);
    }
}
