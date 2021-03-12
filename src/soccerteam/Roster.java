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
    private String name; 
    private String position;
    private int jersey_number;
    private double salary;
    private int goals;  //This will keep track of how many players.
    private int assists;
    private static int count = 0;

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
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the jersey_number
     */
    public int getJersey_number() {
        return jersey_number;
    }

    /**
     * @param jersey_number the jersey_number to set
     */
    public void setJersey_number(int jersey_number) {
        this.jersey_number = jersey_number;
    }

    /**
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * @return the goals
     */
    public int getGoals() {
        return goals;
    }

    /**
     * @param goals the goals to set
     */
    public void setGoals(int goals) {
        this.goals = goals;
    }

    /**
     * @return the assists
     */
    public int getAssists() {
        return assists;
    }

    /**
     * @param assists the assists to set
     */
    public void setAssists(int assists) {
        this.assists = assists;
    }

    /**
     * @return the count
     */
    public static int getCount() {
        return count;
    }

    /**
     * @param aCount the count to set
     */
    public static void setCount(int aCount) {
        count = aCount;
    }
    
    
    public void update(int goal, int asts, double sal) 
    {
        
        setGoals(getGoals() + goal);
        setAssists(getAssists() + asts);
        setSalary(sal);
        
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
        
        return capitalize2(getName()) + "\t" + capitalize(getPosition()) + "\t\t" + getJersey_number() +"\t\t" + fmt.format(getSalary()) + "\t" + getGoals() + "\t" + getAssists();

    }
}

