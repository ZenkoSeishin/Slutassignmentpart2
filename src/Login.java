import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Login {
    File myObj = new File("C:\\Users\\adems\\Music\\Slutassignment2\\Hej.txt");
    public Scanner scanner = new Scanner(System.in);
    Path path = Paths.get("C:\\Users\\adems\\Music\\Slutassignment2\\Hej.txt");

    //attribut

    String username;
    String userInput;
    int MenuStage = 1;
    boolean hej = true;

    //construktor

    public Login() {

        Scanner scanner = new Scanner(System.in);
        while (hej == true) {

            try {
                System.out.println("Choose an option:");
                System.out.println("1. Option A");
                System.out.println("2. Option B");
                MenuStage = scanner.nextInt();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Enter a number between 1 and 2");
            }


            switch (MenuStage) {

                case 1:
                    GetName(myObj);
                    break;
                case 2:
                    SetName(myObj);
                    break;
                default:
                    System.out.println("NEJ");
                    break;
            }


        }
    }


    //metoder

    public static boolean isLetter(String input){
        char[] chars = input.toCharArray();
        if (input.length() < 3 || input.contains(" ")) {
            return false;
        }
        for(char c : chars) {
            if(!Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }

    public static boolean isMatch(File fileName, String userInput) {
        boolean isMatch = false;

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader reader = new BufferedReader(fileReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(userInput)) {
                    isMatch = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        return isMatch;
    }


    //getseters

    public static void SetName(File myObj){
        System.out.println("Enter text to write to file:");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        while(!isLetter(text)){
            System.out.print("Invalid input, please enter text containing 3 letters or more: ");
            text = scanner.nextLine();    }
        try {
            FileWriter writer = new FileWriter(myObj, true); // append mode
            writer.write(text + "\n"); // add a newline character
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public void GetName(File myObj){
        System.out.println("What is your name?");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        while(!isLetter(text)){
            System.out.print("Invalid input, please enter text containing 3 letters or more: ");
            text = scanner.nextLine();
        }
            boolean match = isMatch(myObj,text);
            if (match){
                System.out.println("Välkommen");
                hej = false;
            }  else{
                System.out.println("Du finns inte med i systemet!");
                hej = true;
            }


    }
}
