
import java.util.Scanner;

public class Cinema {

    private int rows;
    private int rowSeats;
    private int allSeats;

    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        cinema.showSeats();
        cinema.book();
    }

    public void showSeats() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        rows = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        rowSeats = scan.nextInt();
        allSeats = rows * rowSeats;
        System.out.println("\nCinema:");
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= rowSeats; j++) {
                if (i == 0 && j == 0) System.out.print("  ");
                else if (i == 0) System.out.print(j + " ");
                else if (j == 0) System.out.print(i + " ");
                else System.out.print("S ");
            }
            System.out.println();
        }
    }

    public void showBookedSeat(int n, int m) {
        System.out.println("\nCinema:");
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= rowSeats; j++) {
                if (i == 0 && j == 0) System.out.print("  ");
                else if (i == 0) System.out.print(j + " ");
                else if (j == 0) System.out.print(i + " ");
                else if (i == n && j == m) System.out.print("B ");
                else System.out.print("S ");
            }
            System.out.println();
        }
    }

    public void showTotalIncome() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        rows = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        rowSeats = scan.nextInt();
        allSeats = rows * rowSeats;
        int income = 0;
        if (allSeats <= 60) {
            income = allSeats * 10;
        } else {
            int firstHalf = (rows / 2) * rowSeats;
            int secondHalf = allSeats - firstHalf;
            income = firstHalf * 10 + secondHalf * 8;
        }
        System.out.printf("Total income:%n$%d", income);
        scan.close();
    }

    public int seatPrice(int n, int m) {
        int price = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (allSeats <= 60) {
                    price = 10;
                } else {
                    if (n <= rows / 2) {
                        price = 10;
                    } else {
                        price = 8;
                    }
                }
            }
        }
        return price;
    }

    public void book() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nEnter a row number:");
        int row = scan.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seat = scan.nextInt();
        int price = seatPrice(row, seat);
        System.out.println("Ticket price: $" + price);
        showBookedSeat(row, seat);
    }
}