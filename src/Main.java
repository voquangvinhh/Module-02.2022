import Customer.CustomerManagement;
import Customer.CustomerManagementMenu;
import Customer.Phone;
import Ivoice.InvoiceManagement2;
import Ivoice.InvoiceManagementMenu2;
import Product.ProductManagement;
import Product.ProductManagementMenu;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        CustomerManagementMenu customerManagementMenu = new CustomerManagementMenu();
        ProductManagementMenu productManagementMenu = new ProductManagementMenu();
        InvoiceManagementMenu2 receiptManagementMenu = new InvoiceManagementMenu2();

        display();
        int choice = sc.nextInt();
        sc.nextLine();
        while (choice != 0) {
            switch (choice) {
                case 1 -> customerManagementMenu.Menu();
                case 2 -> productManagementMenu.Menu();
                case 3 -> receiptManagementMenu.menu();
                default -> System.out.println("Your choice not found!");
            }
            display();
            choice = sc.nextInt();
            sc.nextLine();
        }
    }
    private static void display(){
        System.out.println("Menu");
        System.out.println("1. Customer Menu");
        System.out.println("2. Product Menu");
        System.out.println("3. Invoice Menu");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");
    }

}