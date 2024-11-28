import java.util.Scanner;
public class currency_Convertor {
    // constance vale
    private static final double USD_to_KHR = 4029.84 , USD_t0_THB = 34.40 , USD_to_VND = 25373.00,
            THB_to_KHR = 116.50 , THB_to_VND = 736.00 , THB_to_USD = 0.029,
            VND_To_USD = 0.000039 , VND_t0_THB = 0.0014 , VND_t0_KHR = 0.16,
            KHR_to_VND = 6.32 , KHR_to_USD = 0.00025 , KHR_to_THB = 0.0086;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // enumeration
        enum Currency{
            USD , KHR , VND , THB
        }

        int choice;

        // initialize
        double rate = 1.0;

        do {
            System.out.println("================<[Currency Convertor]>===============");
            System.out.println(" [1]. Enter the source currency [USD] [KHR] [VND] [THB]: ");
            System.out.println(" [0]. Exit program!");
            System.out.println("=====================================================");
            System.out.print("=> Please Choose One Option: ");
            choice = scanner.nextInt();

            System.out.print("=> Enter the source currency [USD] [KHR] [VND] [THB]: ");
            Currency from = Currency.valueOf(scanner.next().toUpperCase());

            System.out.print("=> Enter Currency you want to change to " + ((from==Currency.USD)?"[KHR] [VND] [THB]: ":(from==Currency.KHR)?"[USD] [VND] [THB]: ":(from==Currency.THB)?"[USD] [KHR] [VND]: ":(from==Currency.VND)?"[USD] [KHR] [THB]: ":"Invalid Option!!"));
            Currency to = Currency.valueOf(scanner.next().toUpperCase());

            System.out.print("=> Enter your amount to convert: ");
            double amount = scanner.nextDouble();

            switch (choice){
                case 1:
                    // Enhance switch
                    rate = switch (from) {
                        case KHR -> switch (to) {
                            case THB -> KHR_to_THB;
                            case VND -> KHR_to_VND;
                            case USD -> KHR_to_USD;
                            default -> rate;
                        };
                        case THB -> switch (to) {
                            case KHR -> THB_to_KHR;
                            case VND -> THB_to_VND;
                            case USD -> THB_to_USD;
                            default -> rate;
                        };
                        case VND -> switch (to) {
                            case KHR -> VND_t0_KHR;
                            case THB -> VND_t0_THB;
                            case USD -> VND_To_USD;
                            default -> rate;
                        };
                        case USD -> switch (to) {
                            case KHR -> USD_to_KHR;
                            case THB -> USD_t0_THB;
                            case VND -> USD_to_VND;
                            default -> rate;
                        };
                    };
                    break;
                case 0:
                    System.exit(0);
                    break;
            }

            double amountConvert = rate * amount;
            System.out.println("=> Your amount = " + String.format("%.2f",amountConvert) + to + "\n");
        } while (true);
    }
}
