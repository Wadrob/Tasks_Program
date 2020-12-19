package pl.coderslab;

import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TaskManager {

    public static void main (String [] args){
        MENU();
        File file = new File("tasks.csv");
        Scanner scan = new Scanner(System.in);
        String operator = " ";
        String [][] arr = LIST(file);

        while (!operator.equals("quit")){
            String nextLine = scan.nextLine();

            if (nextLine.equals("add")){
                System.out.println(" ");
                arr = ADDINGTOLIST(arr);
                System.out.println(" ");
                MENU();
            }
            else if (nextLine.equals("remove")){
                System.out.println(" ");
                arr = REMOVEFROMLIST(arr);
                System.out.println(" ");
                MENU();

            }
            else if (nextLine.equals("list")){
                System.out.println(" ");
                System.out.println("list");
                READINGLIST(arr);
                System.out.println(" ");
                MENU();

            }
            else if (nextLine.equals("quit")){
                System.out.println(ConsoleColors.RED +"Bye,bye");

                try (FileWriter fileWriter = new FileWriter(file)){
                    for (int i = 0; i < arr.length; i++) {
                        String added = Arrays.toString(arr[i]);
                        fileWriter.append(added +"\n");
                    }
                }
                catch (IOException e){
                    e.printStackTrace();
                }

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

    public static String [][] LIST (File file) {
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
            System.out.println("Brak pliku");
        }
        return list;

    }

    public static void READINGLIST(String [][] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(i + ". ");
            for (int j = 0; j <arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static String [][] ADDINGTOLIST (String [][] arr){
        arr = Arrays.copyOf(arr, arr.length +1);
        arr [arr.length-1] = new String [3];
        Scanner scan = new Scanner(System.in);

        System.out.println("Please add task description");
        String answearone = scan.nextLine();
        arr[arr.length-1][0] = answearone;

        System.out.println("Please add task due date");
        String answeartwo = scan.nextLine();
        arr[arr.length-1][1] = answeartwo;

        System.out.println("Is your tast is important: true/false");
        String answearthree = scan.nextLine();
        arr[arr.length-1][2] = answearthree;

        return arr;
    }

    public static String [][] REMOVEFROMLIST (String [][] arr){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please select number to remove");
        String operator = " ";

        while (!operator.equals("quit")){
                try {
                    String nextLine = scan.nextLine();
                    int i = Integer.parseInt(nextLine);
                    if (i < 0){
                        System.out.println("Incorrect argument passed. Please give numver greater or equal 0");
                    }
                    else if (i >= arr.length){
                        System.out.println("Incorrect argument passed. Please give number lesser then " + arr.length);
                    }
                    else {
                        arr = ArrayUtils.remove(arr, i);
                        return arr;
                    }
                }
                catch (NumberFormatException e){
                    System.out.println("Wrong number format, please try again");

                }
            }
        return arr;


    }



}
