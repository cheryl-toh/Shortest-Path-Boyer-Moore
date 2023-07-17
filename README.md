# Shortest Path Finding and Boyer-Moore Algorithm Project

This project implements two algorithms: Shortest Path Finding using Dijkstra's algorithm and Boyer-Moore Algorithm for pattern searching. The Shortest Path Finding algorithm finds the shortest path between nodes in a graph, while the Boyer-Moore Algorithm efficiently searches for a pattern within a given text.

## Classes

- **ShortestPathFinding**: This class implements the Dijkstra's algorithm to find the shortest path between nodes in a graph. It contains methods for initializing the algorithm, performing the shortest path computation, and printing the results.

- **Node**: This class represents a node in the graph and is used by the ShortestPathFinding class. It stores the node number and its cost.

- **Driver**: This class contains the main method and serves as the entry point for the project. It initializes the graph, prompts the user to enter the source node, and invokes the Dijkstra's algorithm.

- **BoyerMooreAlgorithm**: This class implements the Boyer-Moore Algorithm for pattern searching. It provides methods for constructing the shift tables and performing the pattern search.

- **BoyerMooreExample**: This class demonstrates the usage of the Boyer-Moore Algorithm by searching for a pattern in a given text.

## How to Run

To run the Shortest Path Finding algorithm:
1. Compile and run the Driver class.
2. When prompted, enter the source node for the shortest path computation. Ensure the node number is within the valid range.

To run the Boyer-Moore Algorithm:
1. Compile and run the BoyerMooreExample class.
2. The example code demonstrates the pattern search for a given text and pattern. Modify the text and pattern variables to search for different patterns within the text.

## Dependencies

This project does not have any external dependencies. It is implemented in Java and uses standard libraries.
