
package it.unimi.di.prog2.e05;

/** 
 * Classe Num che procura dei metodi di operazioni su interi.
 */
public class Num {
    /** . */
    public Num() {};

    /** 
     * Trova il Massimo Comune Divisore tra due numeri.
     * 
     * @param x numero int
     * @param y numero int
     * @return il MCD tra x e y
     */
    public static int gcd(int x, int y){
        while (y!=0){
            int temp = y;
            y = x%y;
            x = temp;
        }
        return x;
    }

    /**
     * Controlla se il numero messo come parametro è primo.
     * Un numero primo è un numero divisibile solo per se stesso e 1
     * 
     * @param n numero int
     * @return true se n è primo, false altrimenti
     */
    public static boolean isPrime(int n){
        for (int i=1;i<n/2;i++){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }

    /** 
     * Restituisce la somma di dei numeri in un array.
     * 
     * @param a[] array dei numeri da sommare
     * @return la somma dei numeri dentro a
     */
    public static int Sum(int[] a){
        int somma = 0;
        for (int n : a) {
            somma+=n;
        }
        return somma;
    }

}
