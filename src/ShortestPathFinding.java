import java.util.*;

class ShortestPathFinding{

    int[] dist;
    Set<Integer> visited;
    PriorityQueue<Node> pqueue;
    int V; // Number of Vertices
    List<List<Node>> adj_list;

    // class constructor
    ShortestPathFinding(int V){
        this.V = V;
        dist = new int[V];
        visited = new HashSet<>();
        pqueue = new PriorityQueue<>(V,new Node());
    }

    public void dijkstra(List<List<Node>> adj_list, int src){
        this.adj_list = adj_list;

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // Add Source Vertex into Priority Queue
        pqueue.add(new Node(src,0));
        // Distance from source to source is 0
        dist[src] = 0;

        while (visited.size() != V){    // While All Nodes are not Visited,
            int u = pqueue.remove().node; // Put node with minimum distance into the visited set
            visited.add(u);
            graph_adjacentNodes(u);

        }

        System.out.println("Source\t" + "Node#\t\t" + "Distance\t\t");
        for (int i = 0; i < V; i++){
            System.out.println("\t" + src + "\t\t" + i + "\t\t" + dist[i]);
        }

    }

    private void graph_adjacentNodes(int u){
        int edgeDistance;
        int newDistance;

        // Process All Neighbouring Nodes of u
        for (int i = 0; i < adj_list.get(u).size(); i++){

            Node v = adj_list.get(u).get(i);

            // Proceed Only if Current Node is Not in Visited
            if (!visited.contains(v.node)){
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                // Compare Distances
                if (newDistance < dist[v.node]){
                    dist[v.node] = newDistance;
                }
                pqueue.add(new Node(v.node, dist[v.node]));
            }
        }
    }

}

class Node implements Comparator<Node>{
    public int node;
    public int cost;

    public Node(){} // Empty Constructor

    public Node(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
    public int compare(Node node1, Node node2){
        return Integer.compare(node1.cost, node2.cost);
    }
}

class Driver{
    public static void main(String[] args) {
        int V = 20;
        int source;
        // Adjacency List Representation of Graph
        List<List<Node>> adj_list = new ArrayList<>();

        // Initialise adjacency list for every node in the graph
        for (int i = 0; i < V; i++){
            List<Node> x = new ArrayList<>();
            adj_list.add(x);
        }

        // Describe Graph
        adj_list.get(0).add(new Node(1,75));
        adj_list.get(1).add(new Node(0,75));
        adj_list.get(0).add(new Node(13,71));
        adj_list.get(13).add(new Node(1,71));
        adj_list.get(1).add(new Node(16,140));
        adj_list.get(16).add(new Node(1,140));
        adj_list.get(1).add(new Node(17,118));
        adj_list.get(17).add(new Node(1,118));
        adj_list.get(2).add(new Node(6, 211));
        adj_list.get(6).add(new Node(2,211));
        adj_list.get(2).add(new Node(7,90));
        adj_list.get(7).add(new Node(2,90));
        adj_list.get(2).add(new Node(14,101));
        adj_list.get(14).add(new Node(2,101));
        adj_list.get(2).add(new Node(18,142));
        adj_list.get(18).add(new Node(2,142));
        adj_list.get(3).add(new Node(4,120));
        adj_list.get(4).add(new Node(3,120));
        adj_list.get(3).add(new Node(14,138));
        adj_list.get(14).add(new Node(3,138));
        adj_list.get(3).add(new Node(15,146));
        adj_list.get(15).add(new Node(3,146));
        adj_list.get(4).add(new Node(11,75));
        adj_list.get(11).add(new Node(4,75));
        adj_list.get(5).add(new Node(8,86));
        adj_list.get(8).add(new Node(5,86));
        adj_list.get(6).add(new Node(16,99));
        adj_list.get(16).add(new Node(6,99));
        adj_list.get(8).add(new Node(18,98));
        adj_list.get(18).add(new Node(8,98));
        adj_list.get(9).add(new Node(12,87));
        adj_list.get(12).add(new Node(9,87));
        adj_list.get(9).add(new Node(19,92));
        adj_list.get(19).add(new Node(9,92));
        adj_list.get(10).add(new Node(11,70));
        adj_list.get(11).add(new Node(10,70));
        adj_list.get(10).add(new Node(17,111));
        adj_list.get(17).add(new Node(10,111));
        adj_list.get(13).add(new Node(16,151));
        adj_list.get(16).add(new Node(13,151));
        adj_list.get(14).add(new Node(15,97));
        adj_list.get(15).add(new Node(14,97));
        adj_list.get(15).add(new Node(16,80));
        adj_list.get(16).add(new Node(15,80));
        adj_list.get(18).add(new Node(19,142));
        adj_list.get(19).add(new Node(18,142));

        // Call Algorithm
        ShortestPathFinding algo = new ShortestPathFinding(V);
        Scanner input = new Scanner(System.in);
        System.out.println("Which node should be the source node?");
        source = input.nextInt();
        while (source < 0 || source > 19){
            System.out.println("That is beyond the range of our graph!\nWhich node should be the source node?");
            source = input.nextInt();
        }
        algo.dijkstra(adj_list,source);
    }
}

