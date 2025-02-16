package Reading;
import java.util.ArrayList;

public class Creator 
{
    public static void createData(ArrayList<String> actorsList, ArrayList<String> certificationList,
                                  ArrayList<String> directorsList, ArrayList<Integer> durationList,
                                  ArrayList<String[]> genresList, ArrayList<String> namesList,
                                  ArrayList<Double> ratingsList, ArrayList<Integer> releaseYearsList,
                                  ArrayList<String> synopsisList) 
    {
        // Read data from CSV files
        ReadingFilesProperties2.readCSV("../Reading/Actors.csv", actorsList);
        ReadingFilesProperties2.readCSV("../Reading/Certificate.csv", certificationList);
        ReadingFilesProperties2.readCSV("../Reading/Directors.csv", directorsList);
        ReadingFilesProperties2.readCSVInt("../Reading/Duration.csv", durationList);
        ReadingFilesProperties2.readCSVArray("../Reading/Genres.csv", genresList);
        ReadingFilesProperties2.readCSV("../Reading/Names.csv", namesList);
        ReadingFilesProperties2.readCSVDouble("../Reading/Rating.csv", ratingsList);
        ReadingFilesProperties2.readCSVInt("../Reading/Release_years.csv", releaseYearsList);
        ReadingFilesProperties2.readCSV("../Reading/Synopsis.csv", synopsisList);
    }

    public static void createArrays(ArrayList<String> actorsList, ArrayList<String[]> genresList,
                                    ArrayList<String> namesList, String[][] actorsArr, String[][] genresArr) 
    {
        // Create 2D arrays for actors and genres
        for (int i = 0; i < namesList.size(); i++) 
        {
            String[] genres = genresList.get(i);
            String[] actors = actorsList.get(i).split(","); // Assuming actors are separated by commas

            // Fill actors array
            for (int j = 0; j < 3; j++) 
            {
                if (j < actors.length) 
                {
                    actorsArr[i][j] = actors[j];
                } else 
                {
                    actorsArr[i][j] = ""; // Empty space if no more actors
                }
            }

            // Fill genres array
            for (int j = 0; j < 3; j++) 
            {
                if (j < genres.length) 
                {
                    genresArr[i][j] = genres[j];
                } else 
                {
                    genresArr[i][j] = ""; // Empty space if no more genres
                }
            }
        }
    }

}
