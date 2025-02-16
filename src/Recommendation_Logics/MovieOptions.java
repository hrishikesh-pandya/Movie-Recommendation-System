package Recommendation_Logics;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import EXCEPTIONS.*;

public class MovieOptions
{
    private static Scanner sc2=new Scanner(System.in);

    public static void searchByMovieName(ArrayList<String> actorsList,ArrayList<String> certificationList,ArrayList<String> directorsList,ArrayList<Integer> durationList,ArrayList<String[]> genresList,ArrayList<String> namesList,ArrayList<Double> ratingList,ArrayList<Integer> releaseYearsList,ArrayList<String> synopsisList,String[][] actorsArr, String[][] genresArr)
    {
        System.out.print("Enter the name of the movie: ");
        String movie=sc2.nextLine();
        if(namesList.contains(movie))
        {
            int k=namesList.indexOf(movie);
            System.out.println("\n\nMOVIE INFORMATION: ");
            System.out.println("\n\nMovie Name: "+namesList.get(k));
            System.out.println("\nSynopsis: "+synopsisList.get(k));
            System.out.println("\nStarring: "+actorsList.get(k));
            System.out.println("\nDirected By: "+directorsList.get(k));
            System.out.println("\nDuration: "+durationList.get(k)+" mins");
            System.out.println("\nCerification: "+certificationList.get(k));
            System.out.println("\nRating: "+ratingList.get(k));
            System.out.println("\nReleased in: "+releaseYearsList.get(k));
            System.out.println("\nGenres: "+genresArr[k][0]+","+genresArr[k][1]+","+genresArr[k][2]);

            searchByDirector(directorsList.get(k),k,directorsList,namesList);
            searchByActor(actorsArr, k, actorsList, namesList);
            System.out.println("\n\n\nMore movies with similar genres : \n");
            searchByGenre(genresArr, k, namesList);

        }

        else
        {
            NameChecker(movie,namesList,actorsList,certificationList,directorsList,durationList,genresList,ratingList,releaseYearsList,synopsisList,actorsArr,genresArr);
        }

    }


    public static void searchByDirector(String dir,int k,ArrayList<String> directorsList,ArrayList<String> namesList)
    {
        int c=0;
        for(int i=0;i<directorsList.size();i++)
        {
            if(directorsList.get(i).equals(dir))
            {
                c++;
            }
        }
        if(c>1)
        {
            System.out.println("\n\nMore films from "+dir+"\n");
            for(int i=0;i<directorsList.size();i++)
            {
                if(directorsList.get(i).equals(dir) && i!=k)
                {
                    System.out.println(namesList.get(i));
                }
            }
        }
        else
        {
            System.out.println("\nThis is the only film by "+dir+" to make it in the list!");
        }
    }

    public static void searchByActor(String[][] actorsArr,int k,ArrayList<String> actorsList,ArrayList<String> namesList)
    {
        int c=0;
        String actor;
        for(int l=0;l<3;l++)
        {
            actor=actorsArr[k][l];
            c=0;
            for(int i=0;i<actorsList.size();i++)
            {
                for(int j=0;j<3;j++)
                {
                    if((actorsArr[i][j].trim()).equals(actor.trim()))
                    {
                        c++;
                    }
                }
            }
            if(c>1)
            {
                System.out.println("\n\nMore films starring "+actor+"\n");
                actor=actorsArr[k][l];
                for(int i=0;i<namesList.size();i++)
                {

                    for(int j=0;j<3;j++)
                    {
                        if((actorsArr[i][j].trim()).equals(actor.trim()) && i!=k)
                        {
                            System.out.println(namesList.get(i));
                        }
                    }
                }
            }

        }
    }

    public static void searchByGenre(String[][] genresArr,int k,ArrayList<String> namesList)
    {
        String G[]={genresArr[k][0],genresArr[k][1],genresArr[k][2]};
        pointSystem.pts(G,k,3,namesList,genresArr);
        pointSystem.pts(G,k,2,namesList,genresArr);
        System.out.println("\n\n\nNOTE: We have tried to show relevant movies with a similarity rating of at least 2/3, to reduce the number of movies shown.");
        System.out.println("\n Do you want movies with a similarity rating of 1/3? Y/y for YES and N/n for NO");
        String ch2=sc2.nextLine();
        if(ch2.length()==1)
        {
            if(ch2.equals("n") || ch2.equals("N"))
            {
                System.out.println("Ok. Continue with your search!");

            }
            else if(ch2.equals("Y") || ch2.equals("y"))
            {
                pointSystem.pts(G,k,1,namesList,genresArr);
            }
            else
            {
                System.out.println("Invalid input");

            }
        }
        else
        {
            System.out.println("Invalid input");

        }

    }


    private static final String NAMES_FILE = "../Reading/Names.csv";
    private static final String GENRE_FILE = "../Reading/Genres.csv";
    private static final String ACTORS_FILE = "../Reading/Actors.csv";
    private static final String CERT_FILE = "../Reading/Certificate.csv";
    private static final String DIR_FILE = "../Reading/Directors.csv";
    private static final String DUR_FILE = "../Reading/Duration.csv";
    private static final String RAT_FILE = "../Reading/Rating.csv";
    private static final String YRS_FILE = "../Reading/Release_years.csv";
    private static final String SYN_FILE = "../Reading/Synopsis.csv";

    public static void enterMovieInformation()
    {
        System.out.println("\nEnter the name of the film");
        addMovieInfo(NAMES_FILE);

        System.out.println("\nEnter the 3 genres of the film");
        addArrayMovieInfo(GENRE_FILE);

        System.out.println("\nEnter the 3 actors of the film");
        addArrayMovieInfo(ACTORS_FILE);

        System.out.println("\nEnter the certification of the film");
        addMovieInfo(CERT_FILE);

        System.out.println("\nEnter the director of the film");
        addMovieInfo(DIR_FILE);

        System.out.println("\nEnter the Duration of the film(int value)");
        addMovieInfo(DUR_FILE,1);

        System.out.println("\nEnter the Rating of the film(double value)");
        addMovieInfo(RAT_FILE,2);

        System.out.println("\nEnter the release year of the film(int value)");
        addMovieInfo(YRS_FILE,1);

        System.out.println("\nEnter the Synopsis of the film");
        addMovieInfo(SYN_FILE);



    }

    public static void UsersearchByDirector(String dir,ArrayList<String> directorsList,ArrayList<String> namesList)
    {

        if(directorsList.contains(dir))
        {
            System.out.println("\n\nFilms from the mind of "+dir+":\n");

            for(int i=0;i<namesList.size();i++)
            {
                if(directorsList.get(i).equalsIgnoreCase(dir))
                {
                    System.out.println(namesList.get(i));
                }
            }
        }
        else
        {
            System.out.println("Oops! We don't have anything from this director. Would you like to try again? Y/y for YES and N/n for NO.");
            TryAgain();
            sc2.nextLine();
            System.out.println("Enter directors name");
            dir=sc2.nextLine();

            UsersearchByDirector(dir, directorsList, namesList);
        }
    }

    public static void UsersearchByActor(String actor,String[][] actorsArr,ArrayList<String> namesList)
    {
        int c=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<namesList.size();j++)
            {
                if((actorsArr[j][i].trim()).equalsIgnoreCase(actor.trim()))
                {
                    c++;
                }
            }
        }

        if(c!=0)
        {
            System.out.println("\n\nFilms starring "+actor+": \n");

            for(int i=0;i<namesList.size();i++)
            {
                for(int j=0;j<3;j++)
                {
                    if(actorsArr[i][j].trim().equalsIgnoreCase(actor.trim()))
                    {
                        System.out.println(namesList.get(i));
                    }
                }
            }
        }

        else
        {
            System.out.println("Oops! There are no films starring this actor! Would you like to try again? Y/y for YES and N/n for NO");
            TryAgain();
            sc2.nextLine();
            System.out.println("Enter actors name");
            actor=sc2.nextLine();

            UsersearchByActor(actor, actorsArr, namesList);
        }
    }

    public static void UsersearchByGenre(String gen,String[][] genresArr,ArrayList<String> namesList)
    {
        if(Genchecker(gen))
        {
            {
                System.out.println("\nFilms in the "+gen+" genre: \n");

                for(int i=0;i<3;i++)
                {
                    for(int j=0;j<namesList.size();j++)
                    {
                        if(genresArr[j][i].equalsIgnoreCase(gen.trim()))
                        {
                            System.out.println(namesList.get(j));
                        }
                    }
                }
            }
        }
        else
        {
            System.out.println("Oops! There are no films in this genre! Would you like to try again? Y/y for YES and N/n for NO");
            TryAgain();
            sc2.nextLine();
            System.out.println("Enter genre name");
            gen=sc2.nextLine();
            UsersearchByGenre(gen, genresArr, namesList);
        }
    }

    public static void NameChecker(String movie,ArrayList<String> namesList,ArrayList<String> actorsList,ArrayList<String> certificationList,ArrayList<String> directorsList,ArrayList<Integer> durationList,ArrayList<String[]> genresList,ArrayList<Double> ratingList,ArrayList<Integer> releaseYearsList,ArrayList<String> synopsisList,String[][] actorsArr,String[][] genresArr)
    {
        System.out.printf("\nWe dont have a movie named \"%s\" .\n",movie);
        int c=0;
        for(String i:namesList)
        {
            if(i.contains(movie))
            {
                c++;
                if(c==1)
                {
                    System.out.println("Please check if you meant one of the following movies instead.\n");
                }
                System.out.println(i);
            }
        }
        if(c==0)
        {
            System.out.printf("\nWe could not find any relevant movie with the keyword \"%s\".",movie);
            System.out.println(" Would you like to continue?Enter y/Y for YES and n/N for NO\n");
            char ch=sc2.next().charAt(0);
            if(ch=='Y' || ch=='y')
            {
                searchByMovieName(actorsList, certificationList, directorsList, durationList, genresList, namesList, ratingList, releaseYearsList, synopsisList, actorsArr, genresArr);
            }
            else if(ch=='N' || ch=='n')
            {
                System.out.println("Ok! Goodbye!");
                System.exit(0);
            }
            else
            {
                System.out.println("Invalid input");
                System.exit(0);
            }
        }
        else
        {
            System.out.println("\nDo any of these movies interest you? If yes, type y/Y, else type x/X to leave.");
            String inp=sc2.nextLine();
            if(inp.equals("x") || inp.equals("X"))
            {

                System.out.println("Thanks for using this system!");
                System.exit(0);
            }
            else if(inp.equals("y") || inp.equals("Y"))
            {

                searchByMovieName(actorsList, certificationList, directorsList, durationList, genresList, namesList, ratingList, releaseYearsList, synopsisList, actorsArr, genresArr);
            }
            else
            {
                System.out.println("\nInvalid input!\n");
                System.exit(0);
            }

        }

    }

    public static void TryAgain()
    {
            char ch2=sc2.next().charAt(0);
            if(Character.toString(ch2).length()==1)
            {

                if(ch2=='N' || ch2=='n')
                {
                    System.out.println("Thanks for using this system!");

                    System.exit(0);
                }
                else if(ch2=='Y' || ch2=='y')
                {
                    System.out.println("Please try again!");
                }
                else
                {
                    System.out.println("Invalid input.");

                    System.exit(0);
                }
            }
            else
            {
                System.out.println("Invalid input.");

                System.exit(0);
            }
    }

    public static boolean Genchecker(String gen)
    {
        String[] genre1={"Drama", "Prison", "Melodrama", "Crime", "Suspense", "Action", "Thriller", "Classic", "Biography", "History", "Fantasy", "Adventure", "Dark-Comedy", "Western", "Romance", "Comedy", "Mystery", "Animation", "Sci-Fi", "Family", "War", "Music", "Horror", "Film-Noir", "Musical","Sport"};
        boolean c=false;
        for(int i=0;i<genre1.length;i++)
        {
            c=gen.equals(genre1[i]);
            if(c)
            break;
        }

        return c;
    }

    public static void addMovieInfo(String file)
    {
        try (
             BufferedWriter writer = new BufferedWriter(new FileWriter(file, true)))
        {

            // Prompt the user for movie information
            System.out.println("Enter movie information:");
            System.out.print("Info: ");
            String name = sc2.nextLine();
            // Append the movie information to the CSV file
            if(!(name.contains(",")))
            {
                writer.write(name);
                writer.newLine();
                System.out.println("Movie info added successfully!");
            }
            else
            {
                throw new CommaEnteredException("Can't enter commas!");
            }
        }
        catch (IOException e)
        {
            System.err.println("Error: " + e.getMessage());
        }
        catch(CommaEnteredException cee)
        {
            System.out.println("Try again!");
            addMovieInfo(file);
        }
    }

    public static void addMovieInfo(String file,int k)
    {
        try (
             BufferedWriter writer = new BufferedWriter(new FileWriter(file, true)))
        {

            // Prompt the user for movie information
            System.out.println("Enter movie information:");
            System.out.print("Info: ");
            String name = sc2.nextLine();

            // Append the movie information to the CSV file
            if(!(name.contains(",")))
            {
                if(k==1)
                {
                    try
                    {
                        Integer.parseInt(name);
                        writer.write(name);
                        writer.newLine();
                        System.out.println("Movie info added successfully!");
                    }
                    catch(NumberFormatException nfe)
                    {
                        System.out.println("Enter a valid integer input!");
                        addMovieInfo(file);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }

                }

                else if(k==2)
                {
                    try
                    {
                        Double.parseDouble(name);
                        writer.write(name);
                        writer.newLine();
                        System.out.println("Movie info added successfully!");
                    }
                    catch(NumberFormatException nfe)
                    {
                        System.out.println("Enter a valid double input!");
                        addMovieInfo(file);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }
            else
            {
                throw new CommaEnteredException("Can't enter commas!");
            }
        }
        catch (IOException e)
        {
            System.err.println("Error: " + e.getMessage());
        }
        catch(CommaEnteredException cee)
        {
            System.out.println("Try again!");
            addMovieInfo(file,k);
        }
}


    public static void addArrayMovieInfo(String file)
    {

        try (
             BufferedWriter writer = new BufferedWriter(new FileWriter(file, true)))
        {

            // Prompt the user for movie information
            System.out.print("1: ");
            String g1 = sc2.nextLine();
            System.out.print("2: ");
            String g2 = sc2.nextLine();
            System.out.print("3: ");
            String g3 = sc2.nextLine();

            // Append the movie information to the CSV file
            if(!(g1.contains(",") || g2.contains(",") || g3.contains(",")))
            {
                writer.write(g1+","+g2+"," +g3);
                writer.newLine();
                System.out.println("Added successfully!");
            }

            else
            {
                throw new CommaEnteredException("Can't enter commas!");
            }
        }
        catch (IOException e)
        {
            System.err.println("Error: " + e.getMessage());
        }
        catch(CommaEnteredException cee)
        {
            System.out.println("Try again!");
            addArrayMovieInfo(file);
        }

    }
}
