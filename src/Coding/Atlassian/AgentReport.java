package Coding.Atlassian;

import java.util.*;

/**
 * Atlassian onsite:
 *
 * create customer ticketing System, which can rate agents on scale of 1-5
 * and then generate a report
 *
 * take those ratings return report highest average to lowest average.
 *
 * You need to generate report on basis of highest to lowest average rating.
 */
public class AgentReport {
    static class Ticket {
        int ticketId;
        int agentId;
        int rating;

        public Ticket(int ticketId, int agentId, int rating){
            this.ticketId = ticketId;
            this.agentId = agentId;
            this.rating = rating;
        }
    }

    class AgentRating {
        String name;
        Double averageRating;

        public AgentRating(String name, Double averageRating){
            this.name = name;
            this.averageRating = averageRating;
        }

        public Double getAverageRating() {
            return averageRating;
        }

        @Override
        public String toString() {
            return "AgentRating{" +
                    "name='" + name + '\'' +
                    ", averageRating=" + String.format("%.2f", averageRating) +
                    '}';
        }
    }

    public List<AgentRating> generateReport(List<Ticket> tickets, Map<Integer, String> agents){
        Map<Integer, List<Integer>> agentRatingMap = new HashMap<>();
        for(Ticket ticket : tickets){
            if(ticket.rating > 0 && ticket.rating <= 5){
                agentRatingMap.computeIfAbsent(ticket.agentId, rating -> new ArrayList<>()).add(ticket.rating);
            }
        }

        List<AgentRating> agentRatingReport = new ArrayList<>();

        for(Map.Entry<Integer, List<Integer>> entry : agentRatingMap.entrySet()) {
            int agentId = entry.getKey();
            List<Integer> agentRatings = entry.getValue();

            Double averageRating = agentRatings.stream().mapToInt(Integer::intValue).average().orElse(0.0);
            String agentName = agents.getOrDefault(agentId, "Agent Not Found");
            agentRatingReport.add(new AgentRating(agentName, averageRating));
        }

        agentRatingReport.sort(Comparator.comparingDouble(AgentRating::getAverageRating).reversed()); // Need Desc.

        return agentRatingReport;
    }
    public static void main(String[] args) {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(1, 101, 5));
        tickets.add(new Ticket(2, 102, 4));
        tickets.add(new Ticket(3, 101, 3));
        tickets.add(new Ticket(4, 102, 5));
        tickets.add(new Ticket(5, 103, 5));
        tickets.add(new Ticket(6, 103, 1));
        tickets.add(new Ticket(7, 101, 5));
        tickets.add(new Ticket(8, 101, 4));
        tickets.add(new Ticket(9, 102, 2));
        tickets.add(new Ticket(10, 103, 3));
        tickets.add(new Ticket(11, 104, 6)); //invalid Rating
        tickets.add(new Ticket(12, 105, 0)); //no rating.
        tickets.add(new Ticket(13, 106, -1)); //invalid rating.

        Map<Integer, String> agentNames = new HashMap<>();
        agentNames.put(101, "Alice");
        agentNames.put(102, "Bob");
        agentNames.put(103, "Charlie");
        agentNames.put(104, "David");
        agentNames.put(105, "Eve");
        agentNames.put(106, "Frank");

        AgentReport reportGenerator = new AgentReport();
        try {
            List<AgentReport.AgentRating> report = reportGenerator.generateReport(tickets, agentNames);

            for (AgentReport.AgentRating agentRating : report) {
                System.out.println(agentRating);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
