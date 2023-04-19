/** Main program
 *  containing user options and methods for each option that can be selected
 */

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

public class Program {
    static BinarySearchTree bst = new BinarySearchTree();
    static Scanner scanner = new Scanner(System.in);

    /** Option 1 
     *  Find the profile description for an existing account
     */

    public static void profileDescription() {
        System.out.print("Enter the account name: ");
        String username = scanner.next();

        try {
            bst.fetch(username).displayDescription();
        }
        catch (Exception e) {
            System.out.println("This account does not exist.");
        }

        System.out.println("\n");
        menu();   
    }


    /** Option 2 
     * List all accounts 
     */

    public static void listAccount() {
        System.out.print("The accounts are: " + "\n");

        bst.inOrder(); 
        
        System.out.println("\n");
        menu();       
    }


    /** Option 3 
     * Create an account
     */

    public static void createAccount() {
        System.out.print("Enter account name: ");
        String username = scanner.next();

        System.out.print("Enter profile description: ");
        scanner.nextLine();

        String description = scanner.nextLine();

        Account account = new Account(username, description);

        if (username.isEmpty() || description.isEmpty()) {
            System.out.println("Error, this account was not created.");
        }
        else {
            bst.insert(account);
            System.out.println("Account created.");
        }

        System.out.println("\n");
        menu();
    }

   
    /** Option 4 
     * Delete an account 
     */

    public static void deleteAccount() {
        System.out.print("Enter account to be deleted: ");
        String username = scanner.next();
    
        if (username.isEmpty()) {
            System.out.println("Error, no account was deleted.");
        } 
        else {
            try {
                bst.delete(username);
                System.out.println("Account deleted.");
            } 
            catch (Exception e) {
                System.out.println("This account does not exist.");
            }
        }

        System.out.println();
        menu();
    }
   

    /** Option 5 
     * Display all posts from a single account
     */

    public static void displayPosts() {
        System.out.print("Enter account name: ");
        String username = scanner.next();
    
        if (username.isEmpty()) {
            System.out.println("No posts yet!");
        } 
        else {
            try {
                bst.fetch(username).displayPosts();
            } 
            catch (Exception e) {
                System.out.println("This account does not exist.");
            }
        }

        System.out.println();
        menu();
    }


    /** Option 6 
     * Add a new post to account
     */

    public static void addPost() {
    
        System.out.print("Enter the account name: ");
        String username = scanner.next();
    
        System.out.print("Enter a post title: ");
        String title = scanner.next();
    
        System.out.print("Enter a file name: ");
        String fileName = scanner.next();
    
        if (username.isEmpty() || title.isEmpty() || fileName.isEmpty()) {
            System.out.println("Error, post was not added.");
        } 
        else {
            try {
                bst.fetch(username).addPost(title, fileName, 0);
                System.out.println("Post uploaded.");
            } 
            catch (Exception e) {
                System.out.println("This account does not exist.");
            }
        }

        System.out.println();
        menu();
    }

    
    /** Option 7 
     * Load a file of actions from disk and process it
     */

    public static void loadFile() {
        String textFile = "dataset.txt";
        
        try (BufferedReader buffer = new BufferedReader(new FileReader(textFile))) {
            String line;
            while ((line = buffer.readLine()) != null) {
                String type = line.substring(0, line.indexOf(" "));
    
                if (type.equals("Create")) {

                    String data = line.substring(line.indexOf(" ") + 1);
                    String username = data.substring(0, data.indexOf(" "));
                    String description = data.substring(data.indexOf(" ") + 1);
    
                    Account account = new Account(username, description);
                    bst.insert(account);
                } 
                else if (type.equals("Add")) {

                    String data = line.substring(line.indexOf(" ") + 1);

                    String username = data.substring(0, data.indexOf(" "));
                    data = data.substring(data.indexOf(" ") + 1);

                    String fileName = data.substring(0, data.indexOf(" "));
                    data = data.substring(data.indexOf(" ") + 1);

                    String likes = data.substring(0, data.indexOf(" "));

                    String title = data.substring(data.indexOf(" ") + 1);
    
                    try {
                        bst.fetch(username).addPost(title, fileName, Integer.parseInt(likes));
                    } 
                    catch (Exception e) {}

                }
            }
            System.out.println("File loaded.");
        
        } 
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n");
        
    }

    /** Option 8 
     * Exit
     * Exit procedure to stop prompting for user input
     */

    public static void exit() {
        System.out.println("Bye!\n");

        System.exit(0);
    }

    
    /**  menu class containing user options and the program's visual interface
     */

    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        int option = 0;
        // Load the initial dataset
        loadFile();
    
        while (option != 8) {
            System.out.println("Choose an action from the menu:\n");
            System.out.println("1. Find the profile description for a given account");
            System.out.println("2. List all accounts");
            System.out.println("3. Create an account");
            System.out.println("4. Delete an account");
            System.out.println("5. Display all posts for a single account");
            System.out.println("6. Add a new post for an account");
            System.out.println("7. Load a file of actions from disk and process this");
            System.out.println("8. Quit\n");
            System.out.print("Enter your choice: ");
    
            try {
                option = Integer.parseInt(scanner.nextLine());
                System.out.println();
                
                /** Functions called with user's selected choice */
                switch (option) {
                    case 1:
                        profileDescription();
                        break;
                    case 2:
                        listAccount();
                        break;
                    case 3:
                        createAccount();
                        break;
                    case 4:
                        deleteAccount();
                        break;
                    case 5:
                        displayPosts();
                        break;
                    case 6:
                        addPost();
                        break;
                    case 7:
                        loadFile();
                        break;
                    case 8:
                        exit();
                        break;
                    default:
                        System.out.println("Invalid option selected.\n");
                        break;
                }

            } 
            
            /** Action taken when invalid number (not 1-8) is chosen by the user */
            catch (NumberFormatException e) {
                System.out.println("Invalid option selected.\n");
            }
        }

        /** Loop terminated when option 8 chosen */
        scanner.close();
    }
    

    public static void main(String[] args)  {
        menu();
    }
}