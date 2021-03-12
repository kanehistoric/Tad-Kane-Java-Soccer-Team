
package soccerteam;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.*;
import static java.lang.System.*;   //so you can just write .out.println()

/*
 * @author rkane
 */
public class SoccerTeam {
    
    public static void printDetail(ArrayList<Roster>  teamRoster)     //total salary is calc'd after updates, and used as a parameter in this function.
    {//Let's make a printDetail function in our main, so we don't have to keep writing all this everytime we want to reprint the team.
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        System.out.println("***************************************************\n");
        System.out.println("Soccer Team Roster Report\n");
        
        System.out.println("Number of Players: " + Roster.count);
        //System.out.println("Team Salary: " + fmt.format(total_salary));
        //Use a for loop to add up total salaries
        double total_salary =0;
        for(int i = 0; i < teamRoster.size(); i++)
        {
            total_salary += teamRoster.get(i).salary;
        }
        System.out.println("Team Salary: " + fmt.format(total_salary));
        System.out.println("Average Player Salary: " + fmt.format(total_salary/Roster.count) +"\n");
        
        System.out.println("Player Roster Details:\n");
        System.out.println("Name\t\tPosition\tJersey\t\tSalary\t\tGoals\tAssists");
        System.out.println("---------------------------------------------------------------------------------------\n");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner kbReader = new Scanner(System.in);
        System.out.println("You are going to build a SOCCER team of players.\n");
        
        ArrayList<Roster> team = new ArrayList<Roster>();
        String answer = "yes";
        double total_salary = 0;
        
        while(answer.equalsIgnoreCase("yes"))
        {
            System.out.println("What is the player's name?: ");
            String name = kbReader.nextLine();
        
            System.out.println("What is the player's Position? (Offense, Defense, or Mid: ");
            String position = kbReader.next();
            
            System.out.println("What is the player's jersey Number?: ");
            int number = kbReader.nextInt();
            
            System.out.println("What is the player's Salary?: ");
            int salary = kbReader.nextInt();
            
            System.out.println("How many Goals does the player have currently?: ");
            int goals = kbReader.nextInt();
            
            System.out.println("How many Assists does the player have currently?: ");
            int assists = kbReader.nextInt();
                    
            Roster player = new Roster(name, position, number, salary, goals, assists);//make the new "player" ojbect, and
            team.add(player);   //store that new object as a new element in our growing ArrayList called "team"
            total_salary+= salary;  //Keep incrementing the total team salary as you add each player to the ArrayList 'team'
            
            System.out.println("Do you want to add another player? (yes or no): ");
            answer = kbReader.next();
            kbReader.nextLine();
                        
        }
        
        printDetail(team);
        
        //The listIterator method on ArrayList returns a ListIterator object that can be
        //used to iterate through the items in the list. Use .hasNext and .next to loop through elements of the list.
        for(int i=0; i < Roster.count; i++)  //Use the count state variable instead of calling team.size()
            System.out.println(team.get(i).toPrint());
        
        //NOW LET'S TAKE IN ANY UPDATES TO INFORMATION ABOUT THE TEAM
        System.out.println("\nPlayer Updates (NEW goals, assists, salary):");
        System.out.println("\nWould you like to update player information? (yes or no):");
        answer = kbReader.next();
        kbReader.nextLine();
        if(answer.equalsIgnoreCase("yes"))
            total_salary=0;                 //Updates will be made 
        while(answer.equalsIgnoreCase("yes"))
        {
            System.out.println("Name of Player: ");
            String name = kbReader.nextLine();
            System.out.println("You entered: " + name);   //debug just to make sure nextLine is working correct.
            
            System.out.println("New Goals scored: ");
            int goals = kbReader.nextInt();
            System.out.println("You entered: " + goals);  //debug just to make sure nextInt is working correct.
            
            System.out.println("New Assists: ");
            int assists = kbReader.nextInt();
            System.out.println("You entered: " + assists);  //debug just to make sure nextInt is working correct.
            
            System.out.println("Current Salary: ");
            double salary = kbReader.nextDouble();
            System.out.println("You entered: " + salary);  //debug just to make sure nextDouble is working correct.
            
            for(int i=0; i < Roster.count; i++)
            {
                if(team.get(i).name.equalsIgnoreCase(name))
                {
                    team.get(i).update(goals, assists, salary);
                    break;                         
                }
            }
            
            System.out.println("\nDo you want to update update player information? (yes or no):");
            answer = kbReader.next();
            kbReader.nextLine();
        }
        
        //So updating is done, now let's total the team salary.
//        total_salary = 0;   //need to rezero the total team salary, otherwise, it will keep counting from before.
//        for(int i=0; i < Roster.count; i++)
//                total_salary += team.get(i).salary; //team.get(i) will be the Player Class objects.
                                                    //team.get(i).salary is the salary of that particular player.
        printDetail(team);                  //
        
        for(int i=0; i < Roster.count; i++)
            System.out.println(team.get(i).toPrint());
        out.println("Size of ArrayList using the .size() method: " + team.size());
        out.println("Size of ArrayList using the Roster.count static variable: " + Roster.count);
    }
    
}


