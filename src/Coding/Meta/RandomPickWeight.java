package Coding.Meta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * You are building a news platform that serves local news based on user location.
 * You have a list of cities and their corresponding populations.
 * You need to implement a feature that randomly selects a city to display a local news story,
 * with the probability of selecting a city proportional to its population.
 * Input: A list of City objects, where each City object has a name (String) and population (int).
 * Output: A function pickCity() that returns the name of a randomly selected city.
 * Constraints: Populations are positive integers. The list of cities is not empty.
 *
 * Variant 2: A/B Testing with Weighted Groups
 *
 * "You are running an A/B test on a website. You have different user groups
 * (A, B, C, etc.) with varying proportions of users assigned to each group.
 * You need to implement a function that randomly assigns a user to a group based on these proportions.
 *
 * Input: Two arrays: groupNames (String array) and weights (int array),
 * where weights[i] represents the proportion of users assigned to groupNames[i].
 * Output: A function assignGroup() that returns the name of the randomly assigned group.
 * Constraints: Weights are positive integers. The arrays are not empty and have the same length.
 * How would you implement this? Discuss the time and space complexity.
 * How would you handle a very large number of groups?"
 *
 * Variant 3: Server Selection with Weighted Capacity
 *
 * "You are managing a distributed system with multiple servers, each with a different capacity.
 * You need to implement a load balancer that randomly selects a server to handle an incoming
 * request, with the probability of selecting a server proportional to its capacity.
 *
 * Input: A list of Server objects, where each Server object has an id (int) and capacity (int).
 * Output: A function selectServer() that returns the id of a randomly selected server.
 * Constraints: Capacities are positive integers. The list of servers is not empty.
 * How would you implement this load balancer? Discuss the time and space complexity of your
 * solution. What if the server capacities are constantly changing? How would you update your
 * data structure efficiently?"
 *
 * LeetCode 528.
 *
 */

// when a map of city to its population is given
public class RandomPickWeight {
    private Random random;
    private List<City> cities;
    private int totalPopulation;
    private int[] prefix;

    private static class City {
        String name;
        int population;

        public City(String name, int population) {
            this.name = name;
            this.population = population;
        }
    }

    public RandomPickWeight(List<City> cities) {
        prefix = new int[cities.size()];
        prefix[0] = cities.get(0).population;
        for(int i = 1; i < cities.size(); i++){
            prefix[i] = cities.get(i).population + prefix[i-1];
        }
        totalPopulation = prefix[cities.size() - 1];
        random = new Random();
    }

    public String pickCity() {
        int target = random.nextInt(totalPopulation) + 1;
        int low = 0, high = prefix.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(prefix[mid] == target){
                return cities.get(mid).name;
            } else if(prefix[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return cities.get(low).name;
    }

    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();
        cities.add(new City("London", 9000000));
        cities.add(new City("Tokyo", 14000000));
        cities.add(new City("New York", 8400000));
        cities.add(new City("Mumbai", 20000000));

        RandomPickWeight picker = new RandomPickWeight(cities);

        for (int i = 0; i < 10; i++) {
            System.out.println("Picked city: " + picker.pickCity());
        }
    }
}
