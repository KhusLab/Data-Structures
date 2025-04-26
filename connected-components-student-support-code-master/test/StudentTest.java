import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class StudentTest {

    @Test
    public void test() {
        // === Test 1: Basic graph with 2 components ===
        UndirectedAdjacencyList G1 = new UndirectedAdjacencyList(6);
        G1.addEdge(1, 2);
        G1.addEdge(2, 3);
        G1.addEdge(4, 5);
        Map<Integer, Integer> rep1 = new HashMap<>();
        ConnectedComponents.connected_components(G1, rep1);
        assertEquals(rep1.get(1), rep1.get(2));
        assertEquals(rep1.get(2), rep1.get(3));
        assertEquals(rep1.get(4), rep1.get(5));
        assertNotEquals(rep1.get(1), rep1.get(4));

        // === Test 2: Isolated vertices ===
        UndirectedAdjacencyList G2 = new UndirectedAdjacencyList(3);
        Map<Integer, Integer> rep2 = new HashMap<>();
        ConnectedComponents.connected_components(G2, rep2);
        assertEquals(rep2.get(0), 0);
        assertEquals(rep2.get(1), 1);
        assertEquals(rep2.get(2), 2);
        assertNotEquals(rep2.get(0), rep2.get(1));

        // === Test 3: Chain connection ===
        UndirectedAdjacencyList G3 = new UndirectedAdjacencyList(6);
        for (int i = 0; i < 5; i++) G3.addEdge(i, i + 1);
        Map<Integer, Integer> rep3 = new HashMap<>();
        ConnectedComponents.connected_components(G3, rep3);
        Integer first = rep3.get(0);
        for (int i = 1; i < 6; i++) assertEquals(first, rep3.get(i));

        // === Test 4: Multiple distinct groups ===
        int n = 100;
        UndirectedAdjacencyList G4 = new UndirectedAdjacencyList(n);
        Random rand = new Random(0);
        for (int base = 0; base < n; base += 20) {
            for (int i = base; i < base + 19; i++) G4.addEdge(i, i + 1);
        }
        Map<Integer, Integer> rep4 = new HashMap<>();
        ConnectedComponents.connected_components(G4, rep4);
        Set<Integer> reps = new HashSet<>();
        for (int base = 0; base < n; base += 20) reps.add(rep4.get(base));
        assertEquals(5, reps.size());

        // === Test 5: Fully connected graph ===
        UndirectedAdjacencyList G5 = new UndirectedAdjacencyList(10);
        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) G5.addEdge(i, j);
        }
        Map<Integer, Integer> rep5 = new HashMap<>();
        ConnectedComponents.connected_components(G5, rep5);
        Integer repG5 = rep5.get(0);
        for (int i = 1; i < 10; i++) assertEquals(repG5, rep5.get(i));

        // === Test 6: Self-loops only ===
        UndirectedAdjacencyList G6 = new UndirectedAdjacencyList(4);
        for (int i = 0; i < 4; i++) G6.addEdge(i, i);
        Map<Integer, Integer> rep6 = new HashMap<>();
        ConnectedComponents.connected_components(G6, rep6);
        for (int i = 0; i < 4; i++) assertEquals(rep6.get(i), i);

        // === Test 7: Star graph ===
        UndirectedAdjacencyList G7 = new UndirectedAdjacencyList(6);
        for (int i = 1; i < 6; i++) G7.addEdge(0, i);
        Map<Integer, Integer> rep7 = new HashMap<>();
        ConnectedComponents.connected_components(G7, rep7);
        Integer repG7 = rep7.get(0);
        for (int i = 1; i < 6; i++) assertEquals(repG7, rep7.get(i));

        // === Test 8: Two disconnected clusters ===
        UndirectedAdjacencyList G8 = new UndirectedAdjacencyList(7);
        G8.addEdge(0, 1);
        G8.addEdge(1, 2);
        G8.addEdge(5, 6);
        Map<Integer, Integer> rep8 = new HashMap<>();
        ConnectedComponents.connected_components(G8, rep8);
        assertEquals(rep8.get(0), rep8.get(2));
        assertNotEquals(rep8.get(0), rep8.get(3));
        assertNotEquals(rep8.get(3), rep8.get(5));
        assertEquals(rep8.get(5), rep8.get(6));

        // === Test 9: Empty graph ===
        UndirectedAdjacencyList G9 = new UndirectedAdjacencyList(0);
        Map<Integer, Integer> rep9 = new HashMap<>();
        ConnectedComponents.connected_components(G9, rep9);
        assertTrue(rep9.isEmpty());

        // === Test 10: Deterministic component labeling ===
        UndirectedAdjacencyList G10 = new UndirectedAdjacencyList(4);
        G10.addEdge(0, 1);
        G10.addEdge(2, 3);
        Map<Integer, Integer> rep10a = new HashMap<>();
        ConnectedComponents.connected_components(G10, rep10a);
        Map<Integer, Integer> rep10b = new HashMap<>();
        ConnectedComponents.connected_components(G10, rep10b);
        assertEquals(rep10a, rep10b); // should be the same

        // === Test 11: Graph with only one node ===
        UndirectedAdjacencyList G11 = new UndirectedAdjacencyList(1);
        Map<Integer, Integer> rep11 = new HashMap<>();
        ConnectedComponents.connected_components(G11, rep11);
        assertEquals(rep11.get(0), 0); // should be its own component

        // === Test 12: Random large graph ===
        int largeN = 1000;
        UndirectedAdjacencyList G12 = new UndirectedAdjacencyList(largeN);
        Random random = new Random(42);
        for (int i = 0; i < largeN / 2; i++) {
            int u = random.nextInt(largeN);
            int v = random.nextInt(largeN);
            if (u != v) G12.addEdge(u, v);
        }
        Map<Integer, Integer> rep12 = new HashMap<>();
        ConnectedComponents.connected_components(G12, rep12);

        // === Test 13: Disconnected complete subgraphs ===
        int subgraphSize = 20;
        UndirectedAdjacencyList G13 = new UndirectedAdjacencyList(subgraphSize * 2);
        for (int i = 0; i < subgraphSize; i++) {
            for (int j = i + 1; j < subgraphSize; j++) G13.addEdge(i, j);
        }
        for (int i = subgraphSize; i < subgraphSize * 2; i++) {
            for (int j = i + 1; j < subgraphSize * 2; j++) G13.addEdge(i, j);
        }
        Map<Integer, Integer> rep13 = new HashMap<>();
        ConnectedComponents.connected_components(G13, rep13);
        Set<Integer> reps13 = new HashSet<>(rep13.values());
        assertEquals(2, reps13.size()); // Should have 2 distinct components

    }
}