import javax.xml.transform.Source;
import java.util.Scanner;

public class Code {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal : ");
        int principal = scanner.nextInt();
        System.out.print("Annual Interest Rate : ");
        double annualRate = scanner.nextDouble();
        System.out.print("Period (Years) : ");
        int years = scanner.nextInt();

        double monthlyRate = annualRate / 100 / 12;
        int numberOfPayments = years * 12;

        double mortgage = principal *
                (monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments)) /
                (Math.pow(1 + monthlyRate, numberOfPayments) - 1);

        System.out.printf("Mortgage: $%.2f", mortgage);
    }
}
