
package graphs;

/**
 *
 * @author Adam Edelberg
 * @author Adam Kaliski
 * @Date: 12 May 2015 
 * @Assignment: Assignment 6 - Graphs and Paths
 *
 */
public class Edge {
    
    private Vertex destination;
    private int cost;
    
    //constructor
     public Edge(Vertex destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }//constructor

     //Generated getter and setter code
    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
     
}
