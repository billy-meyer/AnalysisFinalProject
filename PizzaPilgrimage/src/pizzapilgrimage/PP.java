/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzapilgrimage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author billy
 */
public class PP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        /**
         * ****** OPEN FILES *******
         */
        // Input
        File inputFile = new File("graph.txt");
        if (!inputFile.exists()) {
            System.out.println("Input file, " + inputFile + ","
                    + " does not exist.");
            System.exit(0);
        }

        // Output
        File outputFile = new File("results.txt");

        //Create a Scanner
        Scanner myScanner = new Scanner(inputFile);

        //Create a PrintWriter
        PrintWriter output = new PrintWriter(outputFile);

        /**
         * ******* READ IN GRAPH ********
         */
        int numGraphs = myScanner.nextInt();
        System.out.println("Number of graphs in the file: " + numGraphs);
        int graphCount = 0;
        int numVerts = myScanner.nextInt();
        System.out.println("Number of Vertices in the graph: " + numVerts);
        int[][] graph = new int[numVerts][numVerts];
        for (int i = 0; i < numVerts; i++) {
            for (int j = 0; j < numVerts; j++) {
                graph[i][j] = myScanner.nextInt();
            }
        }
        
        
        /**
         * ******* PRINT GRAPH *******
         */
        for (int i = 0; i < numVerts; i++) {
            for (int j = 0; j < numVerts; j++) {
                output.print(graph[i][j] + " ");
            }
            output.println();
        }
        
        /**
         * ****** CLOSE FILES  ***** 
         */
        myScanner.close();
        output.close();
    }
    
    public void dijkstra(int graph[][], int root, int numVerts){
        
        int dist[] = new int[numVerts];         //Create the set D, which lists the distance estimates for each vertex
        boolean s[] = new boolean[numVerts];    //Create the set S, which tells if the vertex has been considered yet
        
        
    }
    
}
