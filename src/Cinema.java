
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        cinema.showSeats();
        cinema.showTotalIncome();
    }
    public void showSeats() {
        System.out.println("Cinema:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == 0 && j == 0) System.out.print("  ");
                else if (i == 0) System.out.print(j + " ");
                else if (j == 0) System.out.print(i + " ");
                else System.out.print("S ");
            }
            System.out.println();
        }
    }
    public void showTotalIncome() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int rowSeats = scan.nextInt();
        int allSeats = rows * rowSeats;
        int income = 0;
        if (allSeats <= 60) {
            income = allSeats * 10;
        } else {
            int firstHalf = (rows / 2) * rowSeats;
            int secondHalf = allSeats - firstHalf;
            income =firstHalf * 10 + secondHalf * 8;
        }
        System.out.printf("Total income:%n$%d", income);
        scan.close();
    }
}