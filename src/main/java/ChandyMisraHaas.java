import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Chandy-Misra-Haas Distributed Deadlock Detection Algorithm
 *
 * <p> This is a distributed deadlock detection algorithm.</p>
 * @author Raghunandan Gupta
 * @studentId  2022mt13103
 * @email   2022mt13103@wilp.bits-pilani.ac.in
 * @course  Distributed Computing
 * @courseId    SSZG526
 */
public class ChandyMisraHaas {

    private static final String TITLE = "Chandy-Misra-Haas Distributed Deadlock Detection Algorithm";
    public static void main(String[] args) {
        Model model = null;
        model = chandy_Misra_haas_and_eg_1();
        startAlgorithm(model);

        model = chandy_Misra_haas_and_eg_2();
        startAlgorithm(model);


        model = chandy_Misra_haas_and_eg_3();
        startAlgorithm(model);

        model = readInput();
        startAlgorithm(model);
    }

    static class Message {
        private Integer source;
        private Integer destination;
        private Integer initiator;

        @Override
        public String toString() {
            return "(" + initiator + "," + source + "," + destination + ")";
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Message message = (Message) o;
            return source.equals(message.source);
        }

        @Override
        public int hashCode() {
            return Objects.hash(source);
        }

        public Message(Integer initiator, Integer source, Integer destination) {
            this.source = source;
            this.destination = destination;
            this.initiator = initiator;
        }

        public Integer getSource() {
            return source;
        }

        public void setSource(Integer source) {
            this.source = source;
        }

        public Integer getDestination() {
            return destination;
        }

        public void setDestination(Integer destination) {
            this.destination = destination;
        }

        public Integer getInitiator() {
            return initiator;
        }

        public void setInitiator(Integer initiator) {
            this.initiator = initiator;
        }

    }

    private static void startAlgorithm(Model model) {
        System.out.println(TITLE);
        model.printSummary();
        Map<Integer, List<Integer>> adjacencyMatrix = model.getAdjacencyMatrix();

        List<Integer> visited = new ArrayList<>();

        Queue<Message> queue = new LinkedList<>();
        boolean cyclePresent = false;
        List<Integer> initiatorList = new ArrayList<>();

        // Iterate over all the pairs
        for (Pair pair : model.getPairs()) {
            visited.clear();
            Message initiatorMessage = new Message(pair.getSource(), pair.getSource(), pair.getSource());
            if (cyclePresent || initiatorList.contains(pair.getSource())) {
                continue;
            }
            initiatorList.add(pair.getSource());
            System.out.println("\nOriginator P" + pair.getSource() + "");
            queue.add(initiatorMessage);
            while (!queue.isEmpty()) {
                Message polledMessage = queue.poll();
                if (!polledMessage.getSource().equals(polledMessage.getDestination()) && (Objects.isNull(adjacencyMatrix.get(initiatorMessage.getDestination())) || adjacencyMatrix.get(initiatorMessage.getDestination()).size() == 0)) {
                    System.out.println("Discarding Probe "+ polledMessage + " because P" + polledMessage.getDestination() + " is active process.");
                }
                if (polledMessage.getDestination().equals(polledMessage.getInitiator()) && !polledMessage.getSource().equals(polledMessage.getDestination())) {
                    System.out.println("Both Originator and Destination are same for " + polledMessage+" Cycle detected. Hence deadlock is present.");
                    cyclePresent = true;
                    break;
                }
                if (!visited.contains(polledMessage.getDestination())) {
                    visited.add(polledMessage.getDestination());
                    List<Integer> destinations = adjacencyMatrix.get(polledMessage.getDestination());
                    if (Objects.nonNull(destinations) && destinations.size() > 0) {
                        for (Integer destination : destinations) {
                            Message message1 = new Message(polledMessage.getInitiator(), polledMessage.getDestination(), destination);
                            System.out.println(String.format("P%s -> P%s", message1.getSource(), message1.getDestination()) + " with Probe "+ message1);
                            queue.add(message1);
                        }
                    } else {
                        System.out.println("Discarding Probe "+ polledMessage + " because P" + polledMessage.getDestination() + " is active process.");
                    }
                }
            }
        }
        if (!cyclePresent) {
            System.out.println("No cycle detected. Hence, no Deadlock.");
        }
        System.out.println("\n\n");
    }

    private static Model chandy_Misra_haas_and_eg_1() {
        Model model = new Model();
        model.setNumberOfSites(4);
        model.setNumberOfEdges(7);
        model.getSites().add(new Site(1, List.of(1, 2)));
        model.getSites().add(new Site(2, List.of(3)));
        model.getSites().add(new Site(3, List.of(4)));
        model.getSites().add(new Site(4, List.of(5, 6, 7)));

        model.setPairs(new ArrayList<>());
        model.getPairs().add(new Pair(6, 5));
        model.getPairs().add(new Pair(1, 2));
        model.getPairs().add(new Pair(1, 3));
        model.getPairs().add(new Pair(2, 5));
        model.getPairs().add(new Pair(3, 4));
        model.getPairs().add(new Pair(7, 1));
        model.getPairs().add(new Pair(5, 7));

        return model;
    }

    private static Model chandy_Misra_haas_and_eg_2() {
        System.out.println("Simulating Chandy_Misra_haas_and_eg_2 image attached in the assignment");
        Model model = new Model();
        model.setNumberOfSites(2);
        model.setNumberOfEdges(7);
        model.getSites().add(new Site(1, List.of(1, 2, 4)));
        model.getSites().add(new Site(2, List.of(3, 5)));

        model.setPairs(new ArrayList<>());
        model.getPairs().add(new Pair(1, 3));
        model.getPairs().add(new Pair(3, 5));
        model.getPairs().add(new Pair(2, 1));
        model.getPairs().add(new Pair(2, 4));
        model.getPairs().add(new Pair(3, 2));

        return model;
    }

    private static Model chandy_Misra_haas_and_eg_3() {
        System.out.println("Simulating Chandy_Misra_haas_and_eg_3 image attached in the assignment");
        Model model = new Model();
        model.setNumberOfSites(3);
        model.setNumberOfEdges(7);
        model.getSites().add(new Site(1, List.of(1, 2,3)));
        model.getSites().add(new Site(2, List.of(4,5,6,7)));
        model.getSites().add(new Site(3, List.of(8,9,10)));

        model.setPairs(new ArrayList<>());
        model.getPairs().add(new Pair(1, 2));
        model.getPairs().add(new Pair(2, 3));
        model.getPairs().add(new Pair(3, 4));
        model.getPairs().add(new Pair(4, 5));
        model.getPairs().add(new Pair(5, 6));
        model.getPairs().add(new Pair(6, 8));
        model.getPairs().add(new Pair(5, 7));
        model.getPairs().add(new Pair(7, 10));
        model.getPairs().add(new Pair(10, 9));
        model.getPairs().add(new Pair(8, 9));
        model.getPairs().add(new Pair(9, 1));
        return model;
    }

    private static boolean isProcessValid(Model model, String source) {
        return model.getSites().stream().map(site -> site.getProcessIds()).flatMap(List::stream)
                .filter(process -> process.intValue() == Integer.parseInt(source.replaceAll("P", ""))).count() > 0;
    }

    private static boolean isProcessOverlapping(Model model, List<Integer> processes) {
        return model.getSites().stream().map(site -> site.getProcessIds()).flatMap(List::stream)
                .filter(process -> processes.contains(process)).count() > 0;
    }

    private static List<String> processList(Model model) {
        return model.getSites().stream().map(site -> site.getProcessIds()).flatMap(List::stream)
                .map(id -> "P" + id)
                .collect(Collectors.toList());
    }

    private static List<Integer> processListNumeric(Model model) {
        return model.getSites().stream().map(site -> site.getProcessIds()).flatMap(List::stream)
                .collect(Collectors.toList());
    }

    /**
     * This method reads input and set in Model object
     * @return
     */
    private static Model readInput() {
        System.out.println("########Chandy Misra Haas Algorithm########");
        Model model = new Model();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter number of sites (In Numeric Format only)");
        while (true) {
            try {
                int numberOfSites = Integer.parseInt(bufferedReader.readLine());
                if (numberOfSites > 0) {
                    model.setNumberOfSites(numberOfSites);
                    break;
                } else {
                    System.out.println("[Error Message]Please enter number of sites > 0");
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("[Error Message]Please enter number of sites (In Numeric Format only)");
            }
        }

        for (int i = 0; i < model.getNumberOfSites(); i++) {
            Site site = new Site();
            site.setSiteId(i + 1);
            model.getSites().add(site);
            while (true) {
                String processes = "";
                try {
                    System.out.println("Please enter at least 2 processes (comma separated positive numeric integers e.g. 1,2,3...) in Site " + (i + 1) + " :");
                    processes = bufferedReader.readLine();
                    if (processes.trim().length() > 0) {
                        if(Arrays.asList(processes.split(",")).stream().map(processId -> Integer.parseInt(processId.trim())).distinct().collect(Collectors.toList()).size() <= 1) {
                            System.out.println("[Error Message]Please enter more than 1 process in comma separated format");
                            continue;
                        } else if(Arrays.asList(processes.split(",")).stream().map(processId -> Integer.parseInt(processId.trim())).distinct().collect(Collectors.toList()).size() != Arrays.asList(processes.split(",")).stream().map(processId -> Integer.parseInt(processId.trim())).collect(Collectors.toList()).size()) {
                            System.out.println("[Error Message]Process Ids should be unique.");
                            continue;
                        } else if(isProcessOverlapping(model, Arrays.asList(processes.split(",")).stream().map(processId -> Integer.parseInt(processId.trim())).collect(Collectors.toList()))) {
                            System.out.println("[Error Message]Process Ids should be unique.");
                            continue;
                        }
                        site.getProcessIds().addAll(Arrays.asList(processes.split(",")).stream().map(processId -> Integer.parseInt(processId.trim())).distinct().collect(Collectors.toList()));
                        break;
                    }
                } catch (NumberFormatException | IOException e) {
                    System.out.println("[Error Message]Please enter at least 2 processes (comma separated numeric integers e.g. 1,2,3...)");
                }
            }
        }

        int numberOfEdges = 0;
        while (true) {
            try {
                System.out.println("Please enter number of edges (In Numeric Format only)");
                numberOfEdges = Integer.parseInt(bufferedReader.readLine());
                if (numberOfEdges > 0) {
                    model.setNumberOfEdges(numberOfEdges);
                    break;
                } else {
                    System.out.println("[Error Message]Please enter number of processes greater than 0");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("[Error Message]Please enter number of edges (In Numeric Format only)");
            }
        }

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < numberOfEdges; i++) {
            while(true) {
                try {
                    System.out.println("Please enter edge " + (i+1) +" (Source, Destination) E.g. P1,P2 Process List is : " + processList(model));
                    String edge = bufferedReader.readLine().trim();
                    if (edge.trim().length() > 0 && edge.split(",").length == 2 && isProcessValid(model, edge.split(",")[0].trim()) && isProcessValid(model, edge.split(",")[1])) {
                        Pair pair = new Pair(Integer.parseInt(edge.split(",")[0].trim().replace("P", "")), Integer.parseInt(edge.split(",")[1].trim().replace("P", "")));
                        if(pair.getSource().equals(pair.getDestination())) {
                            System.out.println("[Error Message]Source and Destination can't be same.");
                        } else if(pairs.contains(pair)) {
                            System.out.println("Edge P"+pair.getSource() + " -> P"+pair.getDestination() +" is already present.");
                        } else {
                            pairs.add(pair);
                            System.out.println("Edge P"+pair.getSource() + " -> P"+pair.getDestination() +" added successfully");
                            break;
                        }
                    } else {
                        System.out.println("[Error Message]Please enter valid edge (Source, Destination) E.g. P1,P2. Process List is : " + processList(model));
                    }
                } catch (NumberFormatException | IOException e) {
                    System.out.println("[Error Message]Please enter valid edge (Source, Destination) E.g. P1,P2. Process List is : " + processList(model));
                }
            }
        }
        model.setPairs(pairs);
        return model;
    }

    /**
     * This method represents an Edge between 2 processes
     */
    static class Pair {

        /*
        Source Process
         */
        private Integer source;

        /*
        Destination Process
         */
        private Integer destination;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(source, pair.source) && Objects.equals(destination, pair.destination);
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, destination);
        }

        public Integer getSource() {
            return source;
        }

        public Pair(Integer source, Integer destination) {
            this.source = source;
            this.destination = destination;
        }

        public void setSource(Integer source) {
            this.source = source;
        }

        public Integer getDestination() {
            return destination;
        }

        public void setDestination(Integer destination) {
            this.destination = destination;
        }

        @Override
        public String toString() {
            return "P" + source + "->P" + destination + "";
        }
    }

    /**
     * Data Structure to represent a Distributed System containing multiple Site
     */
    static class Model {
        private int numberOfSites;
        private List<Site> sites = new ArrayList<>();

        private int numberOfEdges;

        public int getNumberOfEdges() {
            return numberOfEdges;
        }

        public void setNumberOfEdges(int numberOfEdges) {
            this.numberOfEdges = numberOfEdges;
        }

        private List<Pair> pairs;

        public List<Pair> getPairs() {
            return pairs;
        }

        public void setPairs(List<Pair> pairs) {
            this.pairs = pairs;
        }

        public int getNumberOfSites() {
            return numberOfSites;
        }

        public void setNumberOfSites(int numberOfSites) {
            this.numberOfSites = numberOfSites;
        }

        public List<Site> getSites() {
            return sites;
        }

        public void setSites(List<Site> sites) {
            this.sites = sites;
        }

        private void printSummary() {
            System.out.println("Number of sites: " + this.getNumberOfSites());
            for (Site site : this.getSites()) {
                System.out.println(site);
            }
            System.out.println("Edges - "+ this.getPairs().stream().map(pair -> pair.toString()).collect(Collectors.joining(", ")));

            System.out.println("Adjacency Matrix for representing edges");

            for(int i = 0; i< this.getSites().stream().map(site -> site.getProcessIds()).flatMap(List::stream).sorted().collect(Collectors.toList()).size(); i++) {
                System.out.print("\tP"+(i+1));
            }
            System.out.println();
            for(int i = 0; i< this.getSites().stream().map(site -> site.getProcessIds()).flatMap(List::stream).sorted().collect(Collectors.toList()).size(); i++) {
                System.out.print("P"+(i+1)+"\t");
                for(int j = 0; j< this.getSites().stream().map(site -> site.getProcessIds()).flatMap(List::stream).sorted().collect(Collectors.toList()).size(); j++) {
                    if(getAdjacencyMatrix().get(i+1) != null && getAdjacencyMatrix().get(i+1).contains(j+1)) {
                        System.out.print("1\t");
                    } else {
                        System.out.print("0\t");
                    }
                }
                System.out.println();
            }
        }

        public Map<Integer, List<Integer>> getAdjacencyMatrix() {
            return this.getPairs().stream().collect(Collectors.groupingBy(Pair::getSource, Collectors.mapping(Pair::getDestination, Collectors.toList())));
        }
    }

    /**
     * Data Structure to represent a Site containing multiple Processes
     */

    static class Site {
        private int siteId;

        private List<Integer> processIds = new ArrayList<>();

        public int getSiteId() {
            return siteId;
        }

        public Site() {
        }

        public Site(int siteId, List<Integer> processIds) {
            this.siteId = siteId;
            this.processIds = processIds;
        }

        public void setSiteId(int siteId) {
            this.siteId = siteId;
        }

        public List<Integer> getProcessIds() {
            return processIds;
        }

        public void setProcessIds(List<Integer> processIds) {
            this.processIds = processIds;
        }

        @Override
        public String toString() {
            return "Site" + siteId +
                    "\t" + processIds.stream().map(processId -> "P"+processId).collect(Collectors.joining(","));
        }
    }

}
