/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccerteam;


import java.text.NumberFormat;

/**
 *
 * @author rkane
 */
public class Roster {
    public String name, position;      
    public int jersey_number; 
    public double salary;
    public int goals;
    public int assists;
    public static int count =0;  //This will keep track of how many players.
     
    public Roster(String name, String position, int jersey_number, double salary, int goals, int assists)
    {
        this.name = name;
        this.position = position;
        this.jersey_number = jersey_number;
        this.salary = salary;
        this.goals = goals;
        this.assists = assists;
        
        count++;
        
    }
    
    public void update(int goal, int asts, double sal) 
    {
        
        goals += goal;
        assists += asts;
        salary = sal;
        
    }
    
    private static String capitalize(String word)
    {
        String words[]=word.split("\\s");  //The parameter is a two word name, so split strings up along white space, and create an array of the strings
        String capitalizeWord="";          //declare a new variable for the newly capitlized word and set it equal to nothing initially (so we can add chars to it"
        for(int k =0; k < words.length; k++)
        //String w:words)
        {  
            String first=words[k].substring(0,1);  //take the first letter/char of the word
            String afterfirst=words[k].substring(1);  //.substring(1) means from index 1 (2nd char of the word) to the end
            capitalizeWord+=first.toUpperCase()+afterfirst.toLowerCase()+" ";  
        }  
        return capitalizeWord.trim();  //.trim() trims any extra white space before or after the word.
    }  
    
    private static String capitalize2(String word) //Using an enhanced for loop
    {
        String words[]=word.split("\\s");  //The parameter is a two word name, so split strings up along white space, and create an array of the strings
        String capitalizeWord="";          //declare a new variable for the newly capitlized word and set it equal to nothing initially (so we can add chars to it"
        for(String w:words)
        {  
            String first=w.substring(0,1);  //take the first letter/char of the word
            String afterfirst=w.substring(1);  //.substring(1) means from index 1 (2nd char of the word) to the end
            capitalizeWord+=first.toUpperCase()+afterfirst.toLowerCase()+" ";  
        }  
        return capitalizeWord.trim();  //.trim() trims any extra white space before or after the word.
    }  
    
    public String toPrint() {
        
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        
        return capitalize2(name) + "\t" + capitalize(position) + "\t\t" + jersey_number +"\t\t" + fmt.format(salary) + "\t" + goals + "\t" + assists;

    }
}

