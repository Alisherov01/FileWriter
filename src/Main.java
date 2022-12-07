import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String text1 = "Chaked exceptions - проверяемые исключения\n";
        String text2 = "Unchaked exceptions - не проверяемые исключения";
        try {
            FileWriter fileWriter = new FileWriter("oldFile.txt");
            fileWriter.write(text1);
            fileWriter.write(text2);
            fileWriter.close();
            System.out.println("Программа отработана)");
            System.out.println();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            FileReader fileReader = new FileReader("oldFile.txt");
            Scanner scan = new Scanner(fileReader);
            int i = 1;
            while (scan.hasNextLine()) {
                System.out.println(i + " " + scan.nextLine());
                i++;
            }
            fileReader.close();
        } catch (IOException notFoundException) {
            System.out.println(notFoundException.getMessage());
        }

        System.out.println("---------------------------------------------");

        try {
            FileWriter fileWriter = new FileWriter("NewFile.txt");
            fileWriter.write(text1);
            fileWriter.write(text2);
            fileWriter.close();
            System.out.println(text1.replaceAll("\\s+", ""));
            System.out.println(text2.replaceAll("\\s+", ""));
        } catch (IOException notFoundException) {
            System.out.println(notFoundException.getMessage());
        }

        System.out.println("---------------------------------------------");


       try {
           FileWriter fileWriter = new FileWriter("File.txt");
           fileWriter.write("123");
           PrintWriter printWriter = new PrintWriter("File.txt");
           printWriter.close();
       } catch (IOException notFoundException) {
           notFoundException.getMessage();
       }

        try {
            FileReader fileReader = new FileReader("File.txt");
            Scanner scan = new Scanner(fileReader);
            int i = 1;
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
                i++;
            }
            fileReader.close();
        } catch (IOException notFoundException) {
            System.out.println(notFoundException.getMessage());
        }
    }
}