package ad4;

// #import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

// import static org.junit.Assert.assertTrue;

public class DijkstraAlgorithmLongRunningUnitTest {

  @Test
  public void ad4_part1(){

    Node node1 = new Node("1");
    Node node2 = new Node("2");
    Node node3 = new Node("3");
    Node node4 = new Node("4");
    Node node5 = new Node("5");
    Node node6 = new Node("6");

    node1.addDestination(node2, 2);
    node1.addDestination(node3, 5);
    node1.addDestination(node4, 1);

    node2.addDestination(node3, 3);
    node2.addDestination(node4, 2);

    node3.addDestination(node4, 3);
    node3.addDestination(node5, 1);
    node3.addDestination(node6, 5);

    node4.addDestination(node5, 1);

    node5.addDestination(node6, 2);

    Graph graph = new Graph();
    graph.addNode(node1);
    graph.addNode(node2);
    graph.addNode(node3);
    graph.addNode(node4);
    graph.addNode(node5);
    graph.addNode(node6);

    graph = Dijkstra.calculateShortestPathFromSource(graph, node1);

    var allNodes = graph.getNodes();

  }

  @Test
  public void whenSPPSolved_thenCorrect() {

    Node nodeA = new Node("A");
    Node nodeB = new Node("B");
    Node nodeC = new Node("C");
    Node nodeD = new Node("D");
    Node nodeE = new Node("E");
    Node nodeF = new Node("F");

    nodeA.addDestination(nodeB, 10);
    nodeA.addDestination(nodeC, 15);

    nodeB.addDestination(nodeD, 12);
    nodeB.addDestination(nodeF, 15);

    nodeC.addDestination(nodeE, 10);

    nodeD.addDestination(nodeE, 2);
    nodeD.addDestination(nodeF, 1);

    nodeF.addDestination(nodeE, 5);

    Graph graph = new Graph();

    graph.addNode(nodeA);
    graph.addNode(nodeB);
    graph.addNode(nodeC);
    graph.addNode(nodeD);
    graph.addNode(nodeE);
    graph.addNode(nodeF);

    graph = Dijkstra.calculateShortestPathFromSource(graph, nodeA);

    List<Node> shortestPathForNodeB = Arrays.asList(nodeA);
    List<Node> shortestPathForNodeC = Arrays.asList(nodeA);
    List<Node> shortestPathForNodeD = Arrays.asList(nodeA, nodeB);
    List<Node> shortestPathForNodeE = Arrays.asList(nodeA, nodeB, nodeD);
    List<Node> shortestPathForNodeF = Arrays.asList(nodeA, nodeB, nodeD);

    for (Node node : graph.getNodes()) {
      switch (node.getName()) {
        case "B":
          assertTrue(node
              .getShortestPath()
              .equals(shortestPathForNodeB));
          break;
        case "C":
          assertTrue(node
              .getShortestPath()
              .equals(shortestPathForNodeC));
          break;
        case "D":
          assertTrue(node
              .getShortestPath()
              .equals(shortestPathForNodeD));
          break;
        case "E":
          assertTrue(node
              .getShortestPath()
              .equals(shortestPathForNodeE));
          break;
        case "F":
          assertTrue(node
              .getShortestPath()
              .equals(shortestPathForNodeF));
          break;
      }
    }
  }
}
