/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faete.modelos.util;

import java.util.Scanner;

/**
 *
 * @author sticdev30
 */
public class Cifra {

    public static void main(String[] args) {
        ascii();

        int mod = 122;

        String texto = "dimmy";
        int tamDes = new Scanner(System.in).nextInt();
        for (int i = 0; i < texto.length(); i++) {
            int aux = (int) texto.charAt(i);
            int novo = 0;
            if ((aux + tamDes) > mod) {
                novo = ((aux + tamDes) % mod);
                novo += 96;
            } else {
                novo = (aux + tamDes) % mod;
            }
            char t = (char) novo;
            System.out.println(t);
        }

    }

    private static void ascii() {
        for (int i = 0; i < 200; i++) {
            System.out.println(i + " é " + (char) i);
        }
    }
}
