//Authors: Regan Johnson, Billy Meyer and Jake Mattarella
//Emails: rxjsolo@gmail.com and billy_meyer@comcast.net
//Course #: CSC 3380 001
//Title: Verifier
//Creation Date: 11/27/2018
//Date Last Modified: 11/29/2018

//FSC Honor Pledge:
//I will practice academic and personal integrity and excellence of character and expect the
//same from others.

package pp;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;


public class PP{
    public static void main(String[] args) throws Exception {
        
        //Getting all of the files opened
        File inputFile = new File("graph.txt");
        
        Scanner input = new Scanner(inputFile);
        File outputFile = new File("results.txt");

        PrintWriter output = new PrintWriter(outputFile);

        int numgraphs = input.nextInt();
        
      
        
        
        
        
        for (int m = 0; m < numgraphs; m++) { //initial loop to run through every graph
            int vertices = input.nextInt();
            int[] visited = new int[vertices]; //array of 1s and 0s to represent if visited or not
            int[][] graph = new int[vertices][vertices];
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    graph[i][j] = input.nextInt();
                }
            }
            
            int track[] = new int[vertices];
            for (int i = 0; i < vertices; i++) {
                track[i] = 0;              //all vertices are labeled as "0" for not visited
            }
            
            visited[0] = 0;
            int min = Integer.MAX_VALUE; //guarantees that one of the values will be minimum 
            int curind = 0;
            int weight = 0;
            int holdind = 0;
            output.print(0);
            for(int i = 1; i < vertices; i++){
                min = Integer.MAX_VALUE;
                for(int j = 0; j < vertices; j++){
                    if(graph[curind][j] <= min && track[j] == 0 && graph[curind][j] > 0){ //checks if its been visited and if its minimum
                        min = graph[curind][j];
                        holdind = j; //holds the minimum index
                        
                    }
                }
                
                track[curind] = 1;
                weight+= graph[curind][holdind];
                curind = holdind; //sets current index to last minimum index that was held
                
                output.print(" " + curind);
            }
            weight+= graph[curind][0];
            output.println("");
            output.println(weight);

           
           

        }
        
        input.close();
        output.close(); 

    }
    
}


