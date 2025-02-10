package main;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Anna tehtaalle nimi: ");
        Scanner scanner = new Scanner(System.in);
        String factoryName = scanner.nextLine();
        Factory factory = new Factory(factoryName);

        boolean exit = false;

        while (!exit) {
            System.out.println("1) Lisää kone ");
            System.out.println("2) Listaa kaikki koneet ");
            System.out.println("0) Lopeta ohjelma" );

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Anna koneen tyyppi: ");
                    String type = scanner.nextLine();
                    System.out.println("Anna koneen malli: ");
                    String model = scanner.nextLine();
                    System.out.println("Anna työntekijän nimi: ");
                    String workerName = scanner.nextLine();
                    System.out.println("Anna työntekijän ammattinimike: ");
                    String workerRole = scanner.nextLine();

                    Worker worker = new Worker(workerName, workerRole);
                    Machine machine = new Machine(type, model, worker);
                    factory.addMachine(machine);

                    System.out.println("Kone lisätty!");
                    break;

                case 2:
                    System.out.println("Tehtaasta " + factory.getName() + " löytyy seuraavat koneet:");
                    ArrayList<Machine> machines = factory.getMachines();

                    for (Machine mach : machines) {
                        System.out.println(mach.getMachineDetails());
                        System.out.println();
                    }
                    break;

                case 0:
                    System.out.println("Kiitos ohjelman käytöstä. ");
                    exit = true;
                    break;

            
            }
        }

        scanner.close();
    }
}
