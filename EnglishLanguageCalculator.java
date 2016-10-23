import java.util.Scanner;

public class EnglishLanguageCalculator {

	// Checks array "arr" for element "item". Returns true or false. 
	public static boolean contains(String[] arr, String item) {
		for (String n : arr) {
			if (item.equals(n)) { return true; 
			}
		}
		return false;
	}

	// Receives user input of two integers and an operator, performs calculation, and outputs the description of the calculation in plain english.
	public static void main(String[] args) {
		Boolean again = true;
		Scanner sc = new Scanner(System.in);

		while (again) { 
			String[] userInput = new String[4];
			String[] acceptableIntegers = new String[] { "0","1","2","3","4","5","6","7","8","9" };
			String[] acceptableOperators = new String[] { "+","-","*","/","^" };
			String[] numberStrings = new String[] { "zero","one","two","three","four","five","six","seven","eight","nine"};

			// Collects and stores user inputs in the array "userInputs". The user is warned if their input is invalid, and that iteration of the loop is repeated.
			for (int i=1; i<=3; i++) {
				if (i==1) { 
					System.out.printf("Please enter a positive single digit integer for your first number: ");
				} else if (i==2) { 
					System.out.printf("Please enter a positive single digit integer for your second number: ");
				} else if (i==3) { 	
					System.out.printf("Please enter an operator (+, -, /, *, ^): ");	
				}

				userInput[i] = sc.nextLine();
				if (i<=2) {
					if (!contains(acceptableIntegers, userInput[i])) {
						System.out.println("Invalid Number");
						i--;
					}
				} else {
					if (!contains(acceptableOperators, userInput[i])) {
						System.out.println("Invalid Operator");
						i--;
					}
				}
			}

			if (userInput[2].equals("0") && userInput[3].equals("/")) { // Prevents division by zero.
				System.out.println("Division by zero is not allowed");			
			} else { 
				int userInt1 = Integer.parseInt(userInput[1]); // Converts string inputs to int.
				int userInt2 = Integer.parseInt(userInput[2]); 
				String userNum1 = "";
				String userNum2 = "";
				String userOperator = "";
				for (int i=0; i<10; i++) { // Matches the integer values to the appropriate english names and stores that name in userNum1 or userNum2.   
					if (userInt1 == i) {  
						userNum1 = numberStrings[i];  
						userNum1 = userNum1.substring(0, 1).toUpperCase() + userNum1.substring(1); // Capitalizes the first letter of the first word.
					}
					if (userInt2 == i) {
					userNum2 = numberStrings[i];  
					}	
				}
				// Printing the description of the calculation.
				if (userInput[3].equals("+")) { System.out.println(userNum1 + " plus " +  userNum2 + " equals " + (userInt1 + userInt2));
				} else if (userInput[3].equals("-")) { System.out.println(userNum1 + " minus " +  userNum2 + " equals " + (userInt1 - userInt2));
				} else if (userInput[3].equals("*")) { System.out.println(userNum1 + " multiplied by " +  userNum2 + " equals " + (userInt1 * userInt2));	
				} else if (userInput[3].equals("/")) {
					if ((userInt1 % userInt2) == 0) { System.out.println(userNum1 + " divided by " +  userNum2 + " equals " + (userInt1) / userInt2);
					} else { System.out.println(userNum1 + " divided by " +  userNum2 + " equals " + (double) (1.0*userInt1) / userInt2);
				}
				} else if (userInput[3].equals("^")) { System.out.println(userNum1 + " to the exponent of " +  userNum2 + " equals " + (int) Math.pow(userInt1, userInt2));	
				}
			}

			Boolean validYesNo = true;
		 	while (validYesNo) { // Asks the user if they would like to run the program again until one of "y","yes","n","no" is entered.
				System.out.printf("Would you like to continue? (Y/N): ");
				String yesNoInput = sc.nextLine();		
				if (yesNoInput.equalsIgnoreCase("y") || yesNoInput.equalsIgnoreCase("yes") || yesNoInput.equalsIgnoreCase("n") || yesNoInput.equalsIgnoreCase("no")) {
					validYesNo = false;	
					if (yesNoInput.equalsIgnoreCase("n") || yesNoInput.equalsIgnoreCase("no")) {
						again = false;
				
					}
				
				} 

			}

		}

	}

}