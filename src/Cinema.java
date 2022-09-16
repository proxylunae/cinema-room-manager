import java.util.Scanner;

public class Cinema {
    private final Scanner SCANNER = new Scanner(System.in);
    private String[][] room;
    private int rows;
    private int rowSeats;
    private int allSeats;
    private int soldTickets = 0;
    private int currentIncome = 0;

    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        cinema.showMenu();
    }

    public void showSeats() {
        System.out.println("\nCinema:");
        for (String[] strings : room) {
            for (String string : strings) {
                System.out.print(string + "\t");
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
        showMenu();
    }

    public int calculateTotalIncome() {
        int income;
        if (allSeats <= 60) {
            income = allSeats * 10;
        } else {
            int firstHalf = (rows / 2) * rowSeats;
            int secondHalf = allSeats - firstHalf;
            income = firstHalf * 10 + secondHalf * 8;
        }
        return income;
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
        int row = SCANNER.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seat = SCANNER.nextInt();
        if (row > rows || seat > rowSeats) {
            System.out.println("\nWrong input!");
            buyTicket();
            return;
        }
        if (room[row][seat].equals("B")) {
            System.out.println("That ticket has already been purchased!");
            buyTicket();
            return;
        }
        int price = seatPrice(row, seat);
        System.out.println("Ticket price: $" + price);
        room[row][seat] = "B";
        soldTickets++;
        currentIncome += price;
        showMenu();
    }

    public void initRoom() {
        System.out.println("Enter the number of rows:");
        rows = SCANNER.nextInt();
        System.out.println("Enter the number of seats in each row:");
        rowSeats = SCANNER.nextInt();
        allSeats = rows * rowSeats;
        room = new String[rows + 1][rowSeats + 1];
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < rowSeats + 1; j++) {
                if (i == 0 && j == 0) {
                    room[i][j] = " ";
                } else if (i == 0) {
                    room[i][j] = String.valueOf(j);
                } else if (j == 0) {
                    room[i][j] = String.valueOf(i);
                } else {
                    room[i][j] = "S";
                }
            }
        }
        currentIncome = 0;
        soldTickets = 0;
        showMenu();
    }

    public void showMenu() {
        System.out.print("""
                \n1. Create new room
                2. Buy a ticket
                3. Statistics
                4. Show the seats
                5. Cancel ticket
                0. Exit
                """);
        int option = SCANNER.nextInt();
        switch (option) {
            case (1):
                initRoom();
                break;
            case (2):
                buyTicket();
                break;
            case (3):
                showStats();
                break;
            case (4):
                showSeats();
                break;
            case (5):
                cancelTicket();
                break;
            case (0):
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    public void showStats() {
        double percent = (double) soldTickets / ((double) allSeats / 100);
        System.out.printf("%nNumber of purchased tickets: %d%n" +
                "Percentage: %.2f%%%n" +
                "Current income: $%d%n" +
                "Total income: $%d%n", soldTickets, percent, currentIncome, calculateTotalIncome());
        showMenu();
    }

    public void cancelTicket() {
        System.out.println("Enter a row number:");
        int row = SCANNER.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seat = SCANNER.nextInt();
        room[row][seat] = "S";
        int price = seatPrice(row, seat);
        currentIncome -= price;
        soldTickets -= 1;
        System.out.println("Your ticket was canceled successfully");
        showMenu();
    }
}
