import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LibraryManagement {

	public static Scanner scan = new Scanner(System.in);
	private static LibraryClass library = null;
	
	/**
	 * Main Class function
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome please enter the Library's name to get started : "); 
		String libraryName = scan.nextLine(); 
		String option = "";
		
		try {
			if(!libraryName.isEmpty()) {
				// create a new library instance
				library = new LibraryClass(); 
				library.setLibraryName(libraryName);
				
				scan.nextLine();
				//show Menu
				do {
					int opt=  mainMenu(); 
					if(opt == 1) {
						switch(UserManagementMenu()) {
							case 1: library.AddUser(scan); break;
							case 2: library.displayMembers(1); break;
							case 3: library.displayMembers(2); break;
							case 4: library.displayMembers(0); break;
							default : break; 
						}
					}else if(opt == 2){
						switch(BookManagment()) {
							case 1: library.AddBooks(scan); break;
							case 2: library.borrowBook(scan); break;
							case 3: library.returnBook(scan); break;
							case 4: library.displayBooks();; break; 
							default: break;
						}
					}else {
						System.exit(0);
					}
					
					System.out.println("\nDo you want to perform another task? (Yes/No)"); 
					option = scan.next(); 
				}while(option.equalsIgnoreCase("yes")); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		scan.close();;
	}

	/**
	 * Display Main menu options
	 * @return
	 */
	public static int mainMenu() {
		int retval = 0; 
		try {
			System.out.println("\n***********************MENU**************************\n");
			System.out.println("1-User Management"); 
			System.out.println("2-Book Management");
			System.out.println("3-Exit"); 
			System.out.println("Please select an option : "); 
			retval=  scan.nextInt();
		} catch (Exception e) {
			System.out.println("\nSorry! Incorrect input!!"); 
		}
		return retval;
	}
	
	/**
	 * Displays User Management options such as add member, staff, display a
	 * @return
	 */
	public static int UserManagementMenu() {
		int retval = 0; 
		try {
			System.out.println("\n***********************USER MANAGEMENT MENU**************************\n");
			System.out.println("1-Add Member"); 
			System.out.println("2-Display Member List"); 
			System.out.println("3-Display Staff List"); 
			System.out.println("4-Display ALL List"); 
			System.out.println("5-Exit");
			System.out.println("Please select an option : "); 
			retval= scan.nextInt();
		}catch (Exception e) {
			System.out.println("\nSorry! Incorrect input!!"); 
		}
		return retval;
	}
	
	/**
	 * Displays Book Management options such as add book, borrow or return
	 * @return
	 */
	public static int BookManagment() {
		int retval = 0; 
		try {
			System.out.println("\n***********************BOOK MANAGEMENT MENU**************************\n");
			System.out.println("1-Add Book"); 
			System.out.println("2-Borrow book");
			System.out.println("3-Return book");
			System.out.println("4-Display Books");
			System.out.println("5-Exit");
			System.out.println("Please select an option : "); 
			retval= scan.nextInt();
		}catch (Exception e) {
			System.out.println("\nSorry! Incorrect input!!"); 
		}
		return retval;
	}
	
	
}
