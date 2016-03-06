package com.Brahmalingeshwara.kanajartemple;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utills {
	   // Number to word convertion
    static String string;
    static String st1[] = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
                    "Eight", "Nine", };
    static String st2[] = { "hundred", "thousand", "lakh", "crore" };
    static String st3[] = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
                    "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Ninteen", };
    static String st4[] = { "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy",
                    "Eighty", "Ninty" };

    public static String converttoword(int number) {
  

    

  
            int n = 1;
            int word;
            string = "";
            while (number != 0) {
                    switch (n) {
                    case 1:
                            word = number % 100;
                            pass(word);
                            if (number > 100 && number % 100 != 0) {
                                    show("and ");
                            }
                            number /= 100;
                            break;

                    case 2:
                            word = number % 10;
                            if (word != 0) {
                                    show(" ");
                                    show(st2[0]);
                                    show(" ");
                                    pass(word);
                            }
                            number /= 10;
                            break;

                    case 3:
                            word = number % 100;
                            if (word != 0) {
                                    show(" ");
                                    show(st2[1]);
                                    show(" ");
                                    pass(word);
                            }
                            number /= 100;
                            break;

                    case 4:
                            word = number % 100;
                            if (word != 0) {
                                    show(" ");
                                    show(st2[2]);
                                    show(" ");
                                    pass(word);
                            }
                            number /= 100;
                            break;

                    case 5:
                            word = number % 100;
                            if (word != 0) {
                                    show(" ");
                                    show(st2[3]);
                                    show(" ");
                                    pass(word);
                            }
                            number /= 100;
                            break;

                    }
                    n++;
            }
            return string;
    }

    public static void pass(int number) {
            int word, q;
            if (number < 10) {
                    show(st1[number]);
            }
            if (number > 9 && number < 20) {
                    show(st3[number - 10]);
            }
            if (number > 19) {
                    word = number % 10;
                    if (word == 0) {
                            q = number / 10;
                            show(st4[q - 2]);
                    } else {
                            q = number / 10;
                            show(st1[word]);
                            show(" ");
                            show(st4[q - 2]);
                    }
            }
    }

    public static void show(String s) {
            String st;
            st = string;
            string = s;
            string += st;
    }

    public static String replaceWhiteSpace(String data)
    {
    	return data.trim().replaceAll("\\s+", " ");
    }
    
    
  

}
