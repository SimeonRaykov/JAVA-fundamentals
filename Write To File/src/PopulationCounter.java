import java.util.*;


public class PopulationCounter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, Long> countriesMap = new LinkedHashMap<>();
        LinkedHashMap<String, HashMap<String, Long>> bigMap = new LinkedHashMap<>();

        String line = sc.nextLine();
        while (!line.equals("report")) {
            String[] tokens = line.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Integer.parseInt(tokens[2]);
            if (!countriesMap.containsKey(country)) {
                countriesMap.put(country, population);
                bigMap.put(country, new HashMap<>());
            } else {
                countriesMap.put(country, countriesMap.get(country) + population);
            }
            if (!bigMap.get(country).containsKey(city)) {
                bigMap.get(country).put(city, population);
            } else {
                bigMap.get(country).put(city, bigMap.get(country).get(city) + population);
            }
            line = sc.nextLine();
        }

        bigMap.entrySet().stream().sorted((country1, country2) -> country2.getValue().values().stream().reduce(0L, Long::sum)
                .compareTo(country1.getValue().values().stream().reduce(0L, Long::sum))).forEach(country -> {
            System.out.println(country.getKey()+" (total population: " + country.getValue().values().stream().reduce(0L, Long::sum)+")");
            country.getValue().entrySet().stream().sorted((city1, city2) -> city2.getValue().compareTo(city1.getValue()))
                    .forEach(city-> System.out.println("=>"+city.getKey()+": "+city.getValue())
            );
        });


    }
}
