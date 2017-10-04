package graphs;

//imports
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adam Edelberg
 * @author Adam Kaliski
 * @Date: 12 May 2015
 * @Assignment: Assignment 6 - Graphs and Paths
 *
 * Implement the following naïve solution: a. Consider city A as the starting
 * point b. Generate all possible paths from A through all the nodes in the
 * graph and back to A c. Calculate the cost of the paths and keep track of the
 * minimum cost path d. Return the minimum cost path.
 */
public class Graph {

    Map<String, Vertex> vertex = new HashMap<String, Vertex>();

    //add edge to graph method
    public void addEdge(String source, String destination, int cost) {
        Vertex src = getVertex(source);         //parse to vertex
        Vertex dest = getVertex(destination);   //parse to vertex
        src.adjacent.add(new Edge(dest, cost)); //add dest vertex to adjacent list
    }

    //calculates and returns the cost of an edge 
    public double calculateEdgeCost(String source, String destination) {
        double cost = 0;
        Vertex src = vertex.get(source);
        Vertex des = vertex.get(destination);
        List<Edge> adjacent = src.getAdjacent(); //get adjacent vertices
        for (Edge vertices : adjacent) { // loop as many vertices in map
            //if vertex name = destination vertex name 
            if (vertices.getDestination().getName().equals(destination)) {
                //get cost
                cost = vertices.getCost();
            }
        }
        return cost;
    }

    public double getMinimumCost(String name) {
        Vertex v = vertex.get(name); //get vertex
        double cost = 0;
        List<Edge> adjacent = v.getAdjacent(); //get adjacent vertices
        List<String> adjacentNames = new ArrayList<String>();

        // continue if the vertex is not null
        if (v != null) {
            // loop through adjancent vertices
            for (int i = 0; i < adjacent.size(); i++) {
                // add the names of the vertices to an array of strings
                adjacentNames.add(adjacent.get(i).getDestination().getName());

            }

            //get all permutations
            List<List<String>> permutations = generatePermutations(new ArrayList<List<String>>(), v);

            //loop through the size of the list 
            for (int i = 0; i < permutations.size(); i++) {
                if (calculatePermutationCost(name, permutations.get(i)) < cost) {
                    cost = calculatePermutationCost(name, permutations.get(i));
                }
            }
        }
        else {
            System.out.println("check getMinimumCost method");
        }

        return cost;
    }

    // generates all the possible permutations and returns a list of a list of strings
    public List<List<String>> generatePermutations(List<List<String>> ans, Vertex v)
    {
        ans = new ArrayList<List<String>>();
        for (int i = 0; i < v.getAdjacent().size(); i++)
        {
            List<String> first = new ArrayList<String>();
            first.add(v.getAdjacent().get(i).getDestination().getName());
            ans.add(first);
        }
        System.out.println(ans.toString());
        for (int i = 0; i < ans.size(); i++)
        {
            for (int j = 0; j < ans.get(i).size(); j++)
            {
                if (ans.get(i).size() == vertex.size())
                {
                    break;
                }
                Vertex current = vertex.get(ans.get(i).get(ans.get(i).size() - 1));
                boolean inserted = true;
                for (int k = 0; k < current.getAdjacent().size(); k++)
                {
                    if (inserted)
                    {
                        if (!(ans.get(i).contains(current.getAdjacent().get(k).getDestination().getName())))
                        {
                            inserted = false;
                            ans.get(i).add(current.getAdjacent().get(k).getDestination().getName());
                        }
                        else
                        {
                            if (!(ans.get(i).contains(current.getAdjacent().get(k).getDestination().getName())))
                            {
                                List<String> first = new ArrayList<String>(ans.get(i));
                                first.remove(first.size()-1);
                                first.add(current.getAdjacent().get(k).getDestination().getName());
                                ans.add(first);
                            }
                        }
                    }
                    else
                    {
                        if (!(ans.get(i).contains(current.getAdjacent().get(k).getDestination().getName())))
                        {
                            List<String> first = new ArrayList<String>(ans.get(i));
                            first.remove(first.size()-1);
                            first.add(current.getAdjacent().get(k).getDestination().getName());
                            ans.add(first);
                        }
                    }

                }     
            }
            
        }
        return ans;
    }
    //cost of traveling path of permutation
    public double calculatePermutationCost(String name, List<String> permutation) {
        double cost = 0;
        
     
        
        //cost of permute front to end
        cost += calculateEdgeCost(name, permutation.get(0));
        //cost of permute end to front
        cost = cost + calculateEdgeCost(permutation.get(permutation.size() - 1), name);
        //cost of permutations of vertices
        for (int i = 0; i < permutation.size(); i++) {
            cost = cost + calculateEdgeCost(permutation.get(i), permutation.get(i+1));

         }
        return cost;
    }

    //returns vertex / adds new vertex
    public Vertex getVertex(String name) {
        Vertex v = vertex.get(name); // get vertex
        if (v == null) //vertex does not exist
        {
            v = new Vertex(name); // create new vertex
            vertex.put(name, v); //add to the hashMap
        }
        return v;
    }

    //More efficient solution
    public double getMinimumCostEfficient(String name) {

        double cost = 0; // store cost value
        Vertex v = vertex.get(name); // get vertex
        v.setScratch(1); //visited
        Edge currentEdge;

        List<Edge> adjacent = v.getAdjacent(); //get adjacent vertices

            //get shortest path
           // cost+=currentEdge.getCost();
        return cost;
    }

}
