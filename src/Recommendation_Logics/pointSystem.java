package Recommendation_Logics;
import java.util.*;

public class pointSystem 
{

    public static void pts(String G[],int k,int target,ArrayList<String> namesList,String[][] genresArr)
    {
        for(int i=0;i<namesList.size();i++)
        {
            int pt=0;
            for(int j=0;j<3;j++)
            {
                if(genresArr[i][j].equals(G[j]) && i!=k)
                {
                    pt++;
                }
            }
            if(pt==target)
            {
                System.out.println(namesList.get(i)+"\n\t\t\t\t\t\t\t\t\t\t\t\tSimilarity rating for "+namesList.get(i)+": "+target+"/3");
            }

        }
    
    }
}
