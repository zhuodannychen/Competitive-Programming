import java.util.*;
public class prob09
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        if((a.equals("Scissors") && b.equals("Lizard")))
            System.out.println("SCISSORS WINS, Scissors decapitates Lizard");
        else if((b.equals("Scissors") && a.equals("Lizard")))
            System.out.println("LIZARD LOSES, Scissors decapitates Lizard");

        else if((a.equals("Scissors") && b.equals("Paper")))
            System.out.println("SCISSORS WINS, Scissors cuts Paper");
        else if((b.equals("Scissors") && a.equals("Paper")))
            System.out.println("PAPER LOSES, Scissors cuts Paper");

        else if((a.equals("Rock") && b.equals("Paper")))
            System.out.println("PAPER WINS, Paper covers Rock");
        else if((b.equals("Rock") && a.equals("Paper")))
            System.out.println("ROCK LOSES, Paper covers Rock");

        else if((a.equals("Rock") && b.equals("Lizard")))
            System.out.println("ROCK WINS, Rock crushes Lizard");
        else if((b.equals("Rock") && a.equals("Lizard")))
            System.out.println("LIZARD LOSES, Rock crushes Lizard");

        else if((a.equals("Spock") && b.equals("Lizard")))
            System.out.println("LIZARD WINS, Lizard poisons Spock");
        else if((b.equals("Spock") && a.equals("Lizard")))
            System.out.println("SPOCK LOSES, Lizard poisons Spock");

        else if((a.equals("Spock") && b.equals("Scissors")))
            System.out.println("SPOCK WINS, Spock smashes Scissors");
        else if((b.equals("Spock") && a.equals("Scissors")))
            System.out.println("SCISSORS LOSES, Spock smashes Scissors");

        else if((a.equals("Paper") && b.equals("Lizard")))
            System.out.println("LIZARD WINS, Lizard eats Paper");
        else if((b.equals("Paper") && a.equals("Lizard")))
            System.out.println("PAPER LOSES, Lizard eats Paper");

        else if((a.equals("Paper") && b.equals("Spock")))
            System.out.println("PAPER WINS, Paper disproves Spock");
        else if((b.equals("Paper") && a.equals("Spock")))
            System.out.println("SPOCK LOSES, Paper disproves Spock");

        else if((a.equals("Rock") && b.equals("Spock")))
            System.out.println("SPOCK WINS, Spock vaporizes Rock");
        else if((b.equals("Rock") && a.equals("Spock")))
            System.out.println("ROCK LOSES, Spock vaporizes Rock");

        else if((a.equals("Rock") && b.equals("Scissors")))
            System.out.println("ROCK WINS, Rock crushes Scissors");
        else if((b.equals("Rock") && a.equals("Scissors")))
            System.out.println("SCISSORS LOSES, Rock crushes Scissors");

        else
            System.out.println("TIE, " + a.toUpperCase() + " does not affect " + b.toUpperCase());
    }
}
