package com.mini.banque;

import java.text.NumberFormat;

public class Utils {
    public static String chaineTableau(int[] tableau){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i<tableau.length ; i++){

            sb.append(tableau[i]);
            if ((tableau.length > 1) && (i < tableau.length -1))
                sb.append(",");

        }
        sb.append("]");
        return sb.toString();
    }
    public static void afficherTableau(int[] tableau){
        System.out.println(chaineTableau(tableau));
    }

    public static String chaineTableau(String[] tableau){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i<tableau.length ; i++){

            sb.append(tableau[i]);
            if ((tableau.length > 1) && (i < tableau.length -1))
                sb.append(",");

        }
        sb.append("]");
        return sb.toString();
    }

    public static void afficherTableau(String[] tableau){
        System.out.println(chaineTableau(tableau));
    }

    public static String formatterMontant(float mt){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(mt);
    }
}
