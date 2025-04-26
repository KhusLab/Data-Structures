import java.util.HashMap;
import java.util.Map;

public class ConnectedComponents {

    public static <V> void
    connected_components(Graph<V> G, Map<V, V> representative) {
        Map<V, Boolean> visited = new HashMap<>();
        for (V vert : G.vertices()) {
            if (!visited.containsKey(vert)) {
                dfs(G, vert, vert, visited, representative);
            }
        }
    }

    private static <V> void
    dfs(Graph<V> G, V current, V rep, Map<V, Boolean> visited, Map<V, V> representative) {
        visited.put(current, true);
        representative.put(current, rep);

        for (V neighbor : G.adjacent(current)) {
            if (!visited.containsKey(neighbor)) {
                dfs(G, neighbor, rep, visited, representative);
            }
        }
    }
}

