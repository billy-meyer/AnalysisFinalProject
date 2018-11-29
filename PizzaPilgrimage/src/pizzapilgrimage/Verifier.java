//Authors: Regan Johnson and Billy Meyer
//Emails: rxjsolo@gmail.com and billy_meyer@comcast.net
//Course #: CSC 3380 001
//Title: Verifier
//Creation Date: 11/27/2018
//Date Last Modified: 11/29/2018

//FSC Honor Pledge:
//I will practice academic and personal integrity and excellence of character and expect the
//same from others.

package verifier;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;


public class Verifier{
    public static void main(String[] args) throws Exception {
        File inputFile = new File("graph.txt");
        Scanner input = new Scanner(inputFile);
        File inputFileTwo = new File("results.txt");
        File outputFile = new File("verifier.out");
        PrintWriter output = new PrintWriter(outputFile);
        Scanner inputTwo = new Scanner(inputFileTwo);
        Scanner inputThree = new Scanner(inputFileTwo);
        int numgraphs = input.nextInt();
        
        int error = 0; //used for the boolean that prints if incorrect or not
        
        
        
        
        for (int m = 0; m < numgraphs; m++) { //initial loop to run through every graph
            int vertices = input.nextInt();
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
            
            
            
            int total = 0; //adding up the connecting vertexes 
            int a = inputTwo.nextInt(); 
            int b = a;
            int c = inputTwo.nextInt();
            int count = 0;
            int visited = 1;
            track[a] = 1;
            track[c] = 1;

            
            String numcount = inputThree.nextLine();  //amount of vertexes given for solution
            //System.out.println(numcount.length());
            String garbage = inputThree.nextLine();   //skipping over the line with the answer
            int nums = (numcount.length() + 1) / 2;   // getting rid of the spaces
            for(int i = 0; i < nums - 1; i++) {
                total = total + graph[b][c];
                b = c;
                track[b] = 1;   //when a vertices is visited it is labeled "1" for visited
                c = inputTwo.nextInt();
               // System.out.println(total);
            }

            for (int i = 0; i < vertices; i++) {
                if(track[i] == 0){
                    visited = 0; //if any 0s in array then not all vertices were visited and case is invalid
                }
            }

            total = total + graph[b][a];
            int ans = c;
            

            if(ans != total || visited == 0){  // makes sure answer given by algorithm adds up correctly 

                if(error == 0){
                    output.println("The following cases are invalid or incorrect:");
                    error = error + 1;
                }
                output.println(m + 1);
            }

        }
        if(error == 0){
            output.println("All cases are valid!"); //if no incorrect answers
        }

        input.close();
        output.close(); 

    }
    
}


