import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SeatBooking {
    public static int[][] seats = new int[6][6];

    public static boolean checkSeatAvalablity(char row, int n, ArrayList<Integer> seatNumbers){
        row = Character.toUpperCase(row);
        int i = (int)row - 65; // Subtract 65 for ASCII conversion
        Collections.sort(seatNumbers);
        for(int j : seatNumbers){
            if(seats[i][j - 1] == 1)
                return false;
        }
        return true;
    }

    public static void bookSeats(char row, int n, ArrayList<Integer> seatNumbers){
        int i = (int)Character.toUpperCase(row) - 65; // Subtract 65 for ASCII conversion
        Collections.sort(seatNumbers);
        for(int j : seatNumbers)
            seats[i][j - 1] = 1;
        System.out.println("Successfully Booked " + n + " Seats\n");
    }

    public static void showAvailableSeats(){
        for(int[] seat : seats){
            for(int j : seat)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static int calculateCost(char seatRow, int n){
        int cost = 0;
        seatRow =  Character.toUpperCase(seatRow);
        int[] prices = {200, 100, 75, 50, 40, 30};
        int index = seatRow - 'A';
        cost += prices[index] * n;
        return cost;
    }

    public static void main(String[] args) {
        System.out.println("\n\n--------------WELCOME ----------------");
        System.out.println("-----TO THE SEAT BOOKING SYSTEM-------\n\n");

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\nBook Your Seats");
            System.out.println("Avalable Seats(0-Available, 1-Booked)\n");
            showAvailableSeats();

            System.out.println("\nEnter a Particular Row from A to F (or Q to quit): ");
            String input = sc.next();

            if(input.equalsIgnoreCase("Q")) {
                System.out.println("Thank you for using our service. Goodbye!");
                break; // exit the loop
            }

            char seatRow = input.charAt(0);

            System.out.println("Enter Total Number of Seats(Less then 7): ");
            int n = sc.nextInt();

            ArrayList<Integer> seatNumbers = new ArrayList<>();
            System.out.println("Select " + n + " from available seats in row-" + seatRow);
            for(int i = 0; i < n; i++){
                int seatNumber = sc.nextInt();
                seatNumbers.add(seatNumber);
            }

            if(checkSeatAvalablity(seatRow, n, seatNumbers)) {
                bookSeats(seatRow, n, seatNumbers);
                System.out.println("Your Bookings Confirm");
                showAvailableSeats();
                int totalcost = calculateCost(seatRow, n);
                System.out.println("Total Cost of " + n + " seats in " + seatRow + "-row is: " + totalcost + "\n");
            }
            else
                System.out.println("Selected Seats are already Booked!! THANK YOU");
        }
    }
}
