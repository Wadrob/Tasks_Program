package pl.coderslab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class TaskManager {

    public static void main (String [] args){
        MENU();
        File file = new File("tasks.csv");
        Scanner scan = new Scanner(System.in);
        String operator = " ";
        String [][] arr = list(file);

        while (!operator.equals("quit")){
            String nextLine = scan.nextLine();

            if (nextLine.equals("add")){
                System.out.println("Jestem w add");
                System.out.println(" ");
                MENU();
            }
            else if (nextLine.equals("remove")){
                System.out.println("Jestem w remove");
                System.out.println(" ");
                MENU();

            }
            else if (nextLine.equals("list")){
                System.out.println("list");
                READINGLIST(arr);
                System.out.println(" ");
                MENU();

            }
            else if (nextLine.equals("quit")){
                System.out.println(ConsoleColors.RED +"Bye,bye");
                break;
            }
            else {
                System.out.println("Nieprawidłowa komenda");
                System.out.println(" ");
                MENU();

            }

        }
    }

    public static void MENU () {
        System.out.println(ConsoleColors.BLUE + "Please select an option:");
        System.out.println(ConsoleColors.RESET + "add");
        System.out.println("remove");
        System.out.println("list");
        System.out.println("quit");
    }

    public static String [][] list (File file) {
        String [][] list = new String[0][];
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String add = scan.nextLine();
                list = Arrays.copyOf(list, list.length+1);
                list[list.length-1] = add.split(",");
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return list;

    }

    public static void READINGLIST(String [][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j <arr[i].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println(" ");
        }
    }

}
