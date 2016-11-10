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
public class Cifra2 {

    static char[] vetor = {'a', 'b', 'c'};

    public static void main(String[] args) {
        String texto = "ca";
        int mod = 3;
        int tamDes = new Scanner(System.in).nextInt();
        for (int i = 0; i < texto.length(); i++) {
            char a = texto.charAt(i);
            for (int h = 0; h < vetor.length; h++) {
                if (vetor[h] == a) {
                    int pos = (h + tamDes) % mod;
                    System.out.println(vetor[pos]);
                    break;
                }
            }
        }
    }
}
