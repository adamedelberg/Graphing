package graphs;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Adam Edelberg
 * @author Adam Kaliski
 * @Date: 12 May 2015
 * @Assignment: Assignment 6 - Graphs and Paths
 *
 */
public class Vertex {

    
    public String name;   // Vertex name
    public List<Edge> adjacent;    // Adjacent vertices
    public int distance;   // Cost
    public int scratch;   // visited
    

    //constructor
    public Vertex(String name) {
        this.name = name;
        this.adjacent = new LinkedList<Edge>();
        reset();
        
    }//constructor
    
    public void reset(){
        adjacent.clear();
        scratch = 0;
        
    }

    
    //Generated getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getAdjacent() {
        return adjacent;
    }

    public void setAdjacent(List<Edge> adjacent) {
        this.adjacent = adjacent;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getScratch() {
        return scratch;
    }

    public void setScratch(int scratch) {
        this.scratch = scratch;
    }


    

}
