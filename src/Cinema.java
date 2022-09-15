import java.util.Scanner;

public class Cinema {
    private final Scanner scan = new Scanner(System.in);
    private char[][] room;
    private int rows;
    private int rowSeats;
    private int allSeats;

    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        cinema.initRoom();
        cinema.showMenu();
    }

    public void showSeats() {
        System.out.println("\nCinema:");
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                System.out.print(room[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        showMenu();
    }

    public void showTotalIncome() {
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

    public void buyTicket() {
        System.out.println("\nEnter a row number:");
        int row = scan.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seat = scan.nextInt();
        int price = seatPrice(row, seat);
        System.out.println("Ticket price: $" + price);
        room[row][seat] = 'B';
        showMenu();
    }

    public void initRoom() {
        System.out.println("Enter the number of rows:");
        rows = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        rowSeats = scan.nextInt();
        allSeats = rows * rowSeats;
        room = new char[rows + 1][rowSeats + 1];
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < rowSeats + 1; j++) {
                if (i == 0 && j == 0) {
                    room[i][j] = ' ';
                } else if (i == 0) {
                    room[i][j] = (char) (j + 48);
                } else if (j == 0) {
                    room[i][j] = (char) (i + 48);
                } else {
                    room[i][j] = 'S';
                }
            }
        }
    }

    public void showMenu() {
        System.out.println("""
                1. Show the seats
                2. Buy a ticket
                0. Exit
                """);
        int option = scan.nextInt();
        switch (option) {
            case (1):
                showSeats();
                break;
            case (2):
                buyTicket();
                break;
            case (0):
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}