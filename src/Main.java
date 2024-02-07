import java.util.*;



public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> cityNames = new ArrayList<>();
        List<Double> cityTemp = new ArrayList<>();
        Map<String, Double> tempPerCity = new TreeMap<>();
        List<Double> tempAvg = new ArrayList<>();
        cityAndTemp(input, cityNames, cityTemp, tempPerCity, tempAvg);
        cityPrint(tempPerCity);
    }

    static void cityAndTemp(Scanner input, List<String> cityNames, List<Double> cityTemp, Map<String, Double> tempPerCity, List<Double> tempAvg) {
        while (!cityNames.contains("END")) {
            System.out.println("Please provide a city name: ");
            cityNames.add(input.next());
            input.nextLine();
        }
        cityNames.remove("END");
        for (String cityName : cityNames) {
            System.out.println("Please provide the 5 temperatures for " + cityName);
            for (int i = 0; i < 5; i++) {
                cityTemp.add(input.nextDouble());
                input.nextLine();
            }
            double total = 0;
                for (double tempa : cityTemp) {
                    total += tempa;
                }
            tempAvg.add( (total / 5));
            System.out.println(tempAvg);
            cityTemp.clear();
        }
        for(String city : cityNames) {
            tempPerCity.put(city, tempAvg.get(cityNames.indexOf(city)));
        }
    }
    public static void cityPrint(Map<String, Double> tempPerCity) {
        for (Map.Entry<String, Double> entry : tempPerCity.entrySet()) {
           System.out.println(entry.getKey() + ": " + entry.getValue());
       }

}
}
