import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        // Split string s into substrings
        String[] strings = s.split(" ");

        String [] arab = {"1","2","3","4","5","6","7","8","9","10"};
        String [] rome = {
                "I","II","III","IV","V","VI","VII","VIII","IX","X",
                "XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX",
                "XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX",
                "XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL",
                "XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L",
                "LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX","LX",
                "LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX",
                "LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX",
                "LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC",
                "XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C"
        };

        boolean roman1 = false;
        boolean arabic1 = false;
        boolean roman2 = false;
        boolean arabic2 = false;

        int a = 0;
        int b = 0;

        // Checking first number if arabic or roman form.
        try{
            for (int i = 0; i < 10; i++){
                if (strings[0].equals(rome[i]) && strings.length == 3){
                    try {
                        a = Integer.parseInt(arab[i]);
                    } catch (Exception e) {
                        System.out.println("Mistake.");
                    }
                    roman1 = true;
                } else if (strings[0].equals(arab[i]) && strings.length == 3){
                    arabic1 = true;
                } else if (strings.length != 3){
                    System.out.println("Format exception.");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Mistake.");
        }


        // Checking second number if arabic or roman form.
        try{
            for (int i = 0; i < 10; i++){
                if (strings[2].equals(rome[i]) && strings.length == 3){
                    try {
                        b = Integer.parseInt(arab[i]);
                    } catch (Exception e) {
                        System.out.println("Mistake.");
                    }
                    roman2 = true;
                } else if (strings[2].equals(arab[i]) && strings.length == 3){
                    arabic2 = true;
                } else if (strings.length != 3) {
                    System.out.println("Format exception.");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Mistake.");
        }


        // Algorithm if both numbers are arabic.
        if (arabic1 && arabic2){
            try {
                a = Integer.parseInt(strings[0]);
                b = Integer.parseInt(strings[2]);
            } catch (Exception e) {
                System.out.println("Only integer type!");
            }

            Calculator calculator = new Calculator(a, b);
            switch (strings[1]){
                case ("+"):
                    System.out.println("Result of sum: " + calculator.sum());
                    break;
                case ("-"):
                    System.out.println("Result of dec: " + calculator.dec());
                    break;
                case ("*"):
                    System.out.println("Result of multi: " + calculator.multi());
                    break;
                case ("/"):
                    System.out.println("Result of div: " + calculator.div());
                    break;
                default:
                    System.out.println("Something went wrong.");
                    break;
            }
        }

        // Algorithm if both numbers are roman.
        if (roman1 && roman2) {
            Calculator calculator = new Calculator(a, b);
            switch (strings[1]){
                case ("+"):
                    System.out.println(rome[calculator.sum() - 1]);
                    break;
                case ("-"):
                    if (calculator.dec() > 0) {
                        System.out.println(rome[calculator.dec() - 1]);
                    } else {
                        System.out.println("There are only positive values in roman system.");
                    }
                    break;
                case ("*"):
                    System.out.println(rome[calculator.multi() - 1]);
                    break;
                case ("/"):
                    System.out.println(rome[calculator.div() - 1]);
                    break;
                default:
                    System.out.println("Something went wrong.");
                    break;
            }
        }
    }
}