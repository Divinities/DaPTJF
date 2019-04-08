package exo;

import java.util.Scanner;

/** Jeux random.
 * @author house
 */
public class Jeux {

    /** Declaration constante mini du random.*/
    private static final int MIN = 0;
    /** Declaration constante max du random.*/
    private static final int MAX = 1000;

    /** Point de départ de l'appli.
     * @param args parametre a entrer en ligne de commande.
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        int x = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
        int y;
        System.out.println("Veuillez Entrer la valeur de y");
        y = input.nextInt();
        int i = 0;
        while (y != x) {
            i++;
            if (y < x) {
                System.out.println("Plus");
            }

            else {
                System.out.println("Moins");
            }
            y = input.nextInt();

        }
        System.out.println("Bravo");
        System.out.println("Vous avez utlisé " + i + " coups");
    }

}
