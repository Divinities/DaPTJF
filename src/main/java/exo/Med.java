package exo;

import java.util.Scanner;

public class Med {

    public static void main(String[] args) {

        int num = selectop();

        operations(num);

    }

    private static int selectop() {
        Scanner input2 = new Scanner(System.in);
        System.out.println("1 add, 2 sub, 3 mul, 4 dev");
        int num = input2.nextInt();
        return num;
    }

    private static void operations(int num) {
        switch (num) {
        case 1:
            Addval();
            break;

        case 2:
            subval();
            break;

        case 3:
            mulval();
            break;

        case 4:
            devval();
            break;

        default:
        }
    }

    private static void devval() {
        Scanner input2 = new Scanner(System.in);
        int x;
        int y;
        System.out.println("Entrez la première valeur");
        x = input2.nextInt();
        System.out.println("Entrez la deuxième valeur");
        y = input2.nextInt();

        int result = x / y;
        System.out.println(result);

    }

    private static void mulval() {
        Scanner input2 = new Scanner(System.in);
        int x;
        int y;
        System.out.println("Entrez la première valeur");
        x = input2.nextInt();
        System.out.println("Entrez la deuxième valeur");
        y = input2.nextInt();

        int result = x * y;
        System.out.println(result);

    }

    private static void subval() {
        Scanner input2 = new Scanner(System.in);
        int x;
        int y;
        System.out.println("Entrez la première valeur");
        x = input2.nextInt();
        System.out.println("Entrez la deuxième valeur");
        y = input2.nextInt();

        int result = x - y;
        System.out.println(result);
    }

    private static void Addval() {
        Scanner input = new Scanner(System.in);

        int x;
        int y;
        System.out.println("Entrez la première valeur");
        x = input.nextInt();
        System.out.println("Entrez la deuxième valeur");
        y = input.nextInt();

        int result = x + y;
        System.out.println(result);
    }

}
