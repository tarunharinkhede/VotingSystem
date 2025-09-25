import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VoterService voterService = new VoterService();
        VotingService votingService = new VotingService();

        while (true) {
            System.out.println("\n=== VoteTrack Backend ===");
            System.out.println("1. Register Voter");
            System.out.println("2. Cast Vote");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter Voter ID: ");
                String id = sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Age: ");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Gender: ");
                String gender = sc.nextLine();
                System.out.print("Enter Constituency: ");
                String consti = sc.nextLine();
                System.out.print("Enter Booth No: ");
                int booth = sc.nextInt();

                voterService.registerVoter(id, name, age, gender, consti, booth);

            } else if (choice == 2) {
                System.out.print("Enter Voter ID: ");
                String id = sc.nextLine();
                System.out.print("Enter Booth No: ");
                int booth = sc.nextInt();
                System.out.print("Enter Election Year: ");
                int year = sc.nextInt();

                votingService.castVote(id, booth, year);

            } else {
                System.out.println("Exiting...");
                break;
            }
        }
        sc.close();
    }
}

