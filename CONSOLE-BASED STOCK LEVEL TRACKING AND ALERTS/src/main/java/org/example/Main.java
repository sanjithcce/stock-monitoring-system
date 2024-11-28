package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStock Level Monitoring System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Stock");
            System.out.println("3. View Product");
            System.out.println("4. View All Products");
            System.out.println("5. Remove Product");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    String productId = scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter initial quantity: ");
                    int quantity = scanner.nextInt();
                    manager.addProduct(productId, productName, quantity);
                    break;

                case 2:
                    System.out.print("Enter product ID to update: ");
                    productId = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    quantity = scanner.nextInt();
                    manager.updateStock(productId, quantity);
                    break;

                case 3:
                    System.out.print("Enter product ID to view: ");
                    productId = scanner.nextLine();
                    manager.viewProduct(productId);
                    break;

                case 4:
                    manager.viewAllProducts();
                    break;

                case 5:
                    System.out.print("Enter product ID to remove: ");
                    productId = scanner.nextLine();
                    manager.removeProduct(productId);
                    break;

                case 6:
                    System.out.println("Exiting system...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
