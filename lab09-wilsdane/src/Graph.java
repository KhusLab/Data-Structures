public class Graph {
    Vertex[] graph;
    Vertex[] Q;
    int qHead;
    int qTail;

    public Graph(boolean[][] adjacencyMatrix) {
        // Initialize the graph in the constructor
        int n = adjacencyMatrix.length;
        graph = new Vertex[n];

        // Initialize vertices
        for (int i = 0; i < n; i++) {
            graph[i] = new Vertex();
            graph[i].id = i;
        }

        // Build adjacency list
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (adjacencyMatrix[i][j]) count++;
            }
            Vertex[] neighbors = new Vertex[count];
            int index = 0;
            for (int j = 0; j < n; j++) {
                if (adjacencyMatrix[i][j]) {
                    neighbors[index++] = graph[j];
                }
            }
            if (neighbors.length == 0) {
                graph[i].adjacencyList = new Vertex[0];//here?
            } else {
                graph[i].adjacencyList = neighbors;
            }
        }
    }

    public String bfsPath(int source, int target) {
        // Implement the BFS algorithm
        // Return the path between source and target as string
        // Example: souce = 0, target = 7
        // The shortest path could be "0,3,4,7"
        if (source == target) return Integer.toString(source);

        for (Vertex v : graph) {
            v.color = "white";
            v.distance = -1;
            v.parent = null;
        }

        Vertex s = graph[source];
        s.color = "gray";
        s.distance = 0;
        s.parent = null;

        java.util.Queue<Vertex> queue = new java.util.ArrayDeque<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            Vertex u = queue.poll();
            for (Vertex v : u.adjacencyList) {
                if (v.color.equals("white")) {
                    v.color = "gray";
                    v.distance = u.distance + 1;
                    v.parent = u;
                    queue.add(v);
                }
            }
            u.color = "black";
        }
//so i can push
        Vertex end = graph[target];
        if (end.distance == -1) return "";

        StringBuilder path = new StringBuilder();
        while (end != null) {
            path.insert(0, end.id);
            if (end.parent != null) path.insert(0, ",");
            end = end.parent;
        }
        return path.toString();
    }
}