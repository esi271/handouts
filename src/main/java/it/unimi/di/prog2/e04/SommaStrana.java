/*

Copyright 2024 Massimo Santini

This file is part of "Programmazione 2 @ UniMI" teaching material.

This is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This material is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this file.  If not, see <https://www.gnu.org/licenses/>.

 */
package it.unimi.di.prog2.e04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Vedi <a
 * href="https://github.com/mapio/labprog/blob/master/esercizi/somma_strana/Testo.md">testo</a>,
 * ma leggendo gli addendi dal flusso di ingresso.
 */
public class SommaStrana {

    /**
     * .
     */
    private SommaStrana() {
    }

    // Per memorizzare un elenco di interi si può usare list<Integer>, grazie
    // all'boxing automatico https://dev.java/learn/numbers-strings/autoboxing/
    // se la lista è stata dichiarata come
    //
    // List<Integer> interi = new ArrayList<>();
    //
    // sono legittime espressioni del tipo
    //
    // interi.add(3);
    // int y = interi.get(0);
    //
    // dove vengono messi e prelevati dalla lista degli int, non degli Integer.
    /**
     * 
     * Il metodo restituisce la somma "strana" di due numeri dati in standard input.
     * Per somma strana intendiamo una somma che prende l'unità del riporto della somma delle 2 cifre e la si viene sottrata da 9.
     * 
     * @param args non usato
     */
    public static void main(String[] args) {
        List<String> operandi = new ArrayList<>();

        try (Scanner s = new Scanner(System.in)) {
            while (s.hasNext()) {
                operandi.add(s.nextLine());
            }
        }

        String a, b;
        a = operandi.get(0);
        b = operandi.get(1);
        int maxLen = Math.max(a.length(), b.length());

        a = String.format("%" + maxLen + "s", a).replace(' ', '0');
        b = String.format("%" + maxLen + "s", b).replace(' ', '0');

        StringBuilder risultato = new StringBuilder();
        int riporto = 0;

        for (int i = maxLen-1;i>=0;i--){
            int cifra_a = a.charAt(i) - '0';
            int cifra_b = b.charAt(i) - '0';

            int somma = cifra_a + cifra_b + riporto;

            if (somma >= 10){
                risultato.append(9-(somma%10));
                riporto = somma / 10;
            } else {
                risultato.append(somma % 10);
                riporto = 0;
            }

        }

        if (riporto>0){
            risultato.append(riporto);
        }

        System.out.println(risultato.reverse().toString());

    }

}
