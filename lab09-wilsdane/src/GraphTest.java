import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @org.junit.jupiter.api.Test
    void testCase1() {
        boolean[][] adjacencyMatrix = {
                {false, true},
                {true, false},
        };
        Graph graph = new Graph(adjacencyMatrix);
        assertEquals(graph.bfsPath(0,1),"0,1");
    }

    @org.junit.jupiter.api.Test
    void testCase2() {

        boolean[][]adjacencyMatrix = {
                {false, true, false, false, true, false, true, true, false},
                {true, false, true, false, false, false, false, false, false},
                {false, true, false, true, false, false, false, false, false},
                {false, false, true, false, false, true, true, false, true},
                {true, false, false, false, false, true, false, false, false},
                {false, false, false, true, true, false, false, false, false},
                {true, false, false, true, false, false, false, false, false},
                {true, false, false, false, false, false, false, false, true},
                {false, false, false, true, false, false, false, true, false},
        };
        Graph graph = new Graph(adjacencyMatrix);
        assertEquals(graph.bfsPath(0,3),"0,6,3");
    }
}