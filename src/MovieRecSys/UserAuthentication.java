package MovieRecSys;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import EXCEPTIONS.*;


public class UserAuthentication 
{
    private static Scanner sc=new Scanner(System.in);
    private static final String CREDENTIALS_FILE = "src\\USERS\\USERS.csv";

    public static boolean USERCHECK() 
    {

        // Ask the user to login
        while (true) 
        {
            System.out.print("Enter username: ");
            String username = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            boolean exists=true;
            try 
            {
                authenticateUser(username, password);
                System.out.println("Login successful!");
                return exists;
            } 
            catch (AuthenticationException e) 
            {
                System.out.println(e.getMessage());
                System.out.println("Would you like to create an account? (yes/no)");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("yes")) 
                {
                    registerUser();
                    return true;
                }
                else
                {
                    System.out.println("You need an account to use this application! Goodbye.");
                    exists=false;
                    return exists;
                }
            }

        }

    }

    public static void authenticateUser(String username, String password) throws AuthenticationException 
    {
        try (BufferedReader br = new BufferedReader(new FileReader(CREDENTIALS_FILE))) 
        {
            String line;
            while ((line = br.readLine()) != null) 
            {
                String[] parts = line.split(",");

                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) 
                {
                    return;
                }
            }
            throw new AuthenticationException("Invalid username or password.");
            
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }


    }

    private static void registerUser() 
    {
        Scanner s2 = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = s2.nextLine();
        System.out.print("Enter password: ");
        String password = s2.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(CREDENTIALS_FILE));
             BufferedWriter bw = new BufferedWriter(new FileWriter(CREDENTIALS_FILE, true))) 
        {
            String line;
            while ((line = br.readLine()) != null) 
            {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].equals(username)) 
                {
                    throw new AuthenticationException("Username already exists.");
                }
            }
            bw.write(username + "," + password);
            bw.newLine();
            
            System.out.println("User created successfully!");
        } 
        catch (IOException | AuthenticationException e) 
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        finally{s2.close();}

    }


}
