package pl.coderslab;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class TaskManager {

    public static void main (String [] args){
        MENU();
        Scanner scan = new Scanner(System.in);
        String operator = " ";

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
                System.out.println("Jestem w list");
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

    public static String [][] list (File file){
        String [][] list = new String[0][];
        list = Arrays.copyOf(list, list.length +1);
        return list;

    }

}
