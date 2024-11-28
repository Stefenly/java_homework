import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            // Enum for currency and conversion rates
            enum Currency {
                USD, EUR, INR
            }
                Scanner scanner = new Scanner(System.in);

                // Input: Source currency
                System.out.println("Enter the source currency (USD, EUR, INR): ");
                Currency from = Currency.valueOf(scanner.next().toUpperCase());

                // Input: Target currency
                System.out.println("Enter the target currency (USD, EUR, INR): ");
                Currency to = Currency.valueOf(scanner.next().toUpperCase());

                // Input: Amount
                System.out.println("Enter the amount to convert: ");
                double amount = scanner.nextDouble();

                // Conversion rate
                double rate = 1.0;
                switch (from) {
                    case USD:
                        switch (to) {
                            case EUR: rate = 0.85; break;
                            case INR: rate = 82.5; break;
                        }
                        break;
                    case EUR:
                        switch (to) {
                            case USD: rate = 1.18; break;
                            case INR: rate = 97.0; break;
                        }
                        break;
                    case INR:
                        switch (to) {
                            case USD: rate = 0.012; break;
                            case EUR: rate = 0.010; break;
                        }
                        break;
                }

                // Conversion result
                double convertedAmount = amount * rate;
                System.out.printf("Converted amount: %.2f %s%n", convertedAmount, to);

                scanner.close();
            }
        }
