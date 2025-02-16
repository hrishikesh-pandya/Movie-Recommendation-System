package MovieRecSys;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Reading.*;
import Recommendation_Logics.MovieOptions;
public class MovieRecommendationSystem 
 
{
    private static Scanner sc=new Scanner(System.in);

    public static ArrayList<String> actorsList = new ArrayList<>();
    public static ArrayList<String> certificationList = new ArrayList<>();
    public static ArrayList<String> directorsList = new ArrayList<>();
    public static ArrayList<Integer> durationList = new ArrayList<>();
    public static ArrayList<String[]> genresList = new ArrayList<>();
    public static ArrayList<String> namesList = new ArrayList<>();
    public static ArrayList<Double> ratingsList = new ArrayList<>();
    public static ArrayList<Integer> releaseYearsList = new ArrayList<>();
    public static ArrayList<String> synopsisList = new ArrayList<>();
    
    public static void main(String[] args) 
    {
        if(UserAuthentication.USERCHECK())
        {
            
                
            Creator.createData(actorsList, certificationList, directorsList, durationList, genresList, namesList, ratingsList, releaseYearsList, synopsisList);
                
            String[][] actorsArr = new String[actorsList.size()][3];
            String[][] genresArr = new String[genresList.size()][3];
    
            Creator.createArrays(actorsList, genresList, namesList, actorsArr, genresArr);
            int choice;
            while(true)
            {
                System.out.println("\nPlease choose an option:");
                System.out.println("1. Search for a movie by its name");
                System.out.println("2. Search for movies by a particular director");
                System.out.println("3. Search for movies by a particular actor");
                System.out.println("4. Search for a movie by a genre");
                System.out.println("5. Enter your own information about the movie");
                System.out.println("6. Exit the program");
                System.out.print("Enter your choice: ");
                try
                {


                    choice=sc.nextInt();


                    switch (choice) 
                    {
                        case 1:
                            MovieOptions.searchByMovieName(actorsList,certificationList,directorsList,durationList,genresList,namesList,ratingsList,releaseYearsList,synopsisList,actorsArr,genresArr);
                            
                            break;
                        case 2:
                            sc.nextLine(); //this needs to be here for all the cases!
                            System.out.print("\nEnter the name of the director: ");
                            String dir=sc.nextLine();
                            
                            MovieOptions.UsersearchByDirector(dir,directorsList,namesList);
                            break;
                        case 3:
                            sc.nextLine();
                            System.out.print("\nEnter name of the actor: ");
                            String actor=sc.nextLine();
                            
                            MovieOptions.UsersearchByActor(actor,actorsArr,namesList);
                            break;
                        case 4:
                            sc.nextLine();
                            System.out.print("\nEnter the genre: ");
                            String gen=sc.nextLine();
                            
                            MovieOptions.UsersearchByGenre(gen, genresArr, namesList);
                            break;
                        case 5:
                            System.out.println("\nEnter the following details, then the program will end.");
                            System.out.println("Rerun the program to see the changes!\nDuration and Release years should be integers, Ratings are doubles.");
                            System.out.println("Make sure that the inputs are of relevant data types!");
                            MovieOptions.enterMovieInformation();
                            System.exit(0);
                            break;
                        case 6:
                            System.out.println("\nExiting the program... Goodbye!");
                            
                            System.exit(0);
                            break;
                        default:
                            System.out.println("\nPlease enter a number between 1 and 6.");
                            
                            break;
        
                    }
                }
                catch(InputMismatchException ime)
                {
                    System.out.println("Wrong input. Please rerun the code.");
                    System.exit(0);
                }

            }
        }



    }
}
