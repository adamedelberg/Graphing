package graphs;


import graphs.Graph;
import java.io.BufferedReader;
import java.io.FileReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author adamedelberg
 */
public class Main {

    public static void main(String[] args) {
      
        Graph graph = new Graph(); // create new instance of graph object
        try {
            //read file
            BufferedReader f = new BufferedReader(new FileReader("graph.txt"));
            String line = f.readLine();
            while (line != null) {
                String split[] = line.split(" : ");
                String source = split[0];
                String destination = split[1];
                int cost = Integer.parseInt(split[2].trim());
                //add edge
                graph.addEdge(source, destination, cost);
                graph.addEdge(destination, source, cost);
                //System.out.println(source+destination+cost);
                line = f.readLine();
            }
            System.out.println("Naive Result: "+graph.getMinimumCost("A"));
            System.out.println("Optimised Result: ");
            
        }
        catch (Exception e) {
            System.out.println("File Error: " + e);
e.printStackTrace();        
        }

    }

}
