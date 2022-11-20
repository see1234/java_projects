package org.tasks;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SeminarWork1 {

   public SeminarWork1() {
       Task5();
   }
   public void Task1() {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        System.out.println("Привет" + ", " + name);
        scan.close();
    }
   public void Task2() {
       Scanner scan = new Scanner(System.in);
       String name = scan.nextLine();
       int TimeinHour = LocalDateTime.now().getHour();
       String dayWelcome = "";
       if(TimeinHour >= 5 && TimeinHour < 12)
       {
           dayWelcome = "Доброе утро";
       }
       else if(TimeinHour >= 12 && TimeinHour < 18)
       {
           dayWelcome = "Добрый день";
       }
       else if(TimeinHour >= 18 && TimeinHour < 23)
       {
           dayWelcome = "Добрый вечер";
       }
       else
       {
           dayWelcome = "Доброй ночи";
       }
       System.out.println(dayWelcome + ", " + name + "!");
       scan.close();
   }
    public void Task3() {
        int[] arr = new int[] {1,1,1,1,1,0,1,1,1, 0};
        int count = 0;
        int max = 0;
        for(int i : arr) {
            if(i == 1) {
                count++;
                if(count > max) {
                    max = count;
                }
            }
            else {
                count=0;
            }
        }

        System.out.print(max);
    }
    public void Task4() {
        int[] arr = new int[] {2,3,3,2,2,2};
        int val = 3;
        int i = 0;
        int size = 0;
        while(size <= arr.length) {
            for (int j : arr) {

                if (i + 1 < arr.length) {
                    if (val == arr[i]) {
                        int c = arr[i + 1];
                        arr[i + 1] = arr[i];
                        arr[i] = c;

                    }
                    i++;
                    //arr[i - 1] = arr[i];

                }

                //arr[arr.length-1] = j;


            }

            i=0;
            size+=1;
        }



        for(int g : arr) {
            System.out.print(" " + g);
        }
    }
    public String getPrefix(String[] arr) {
       String prefix = arr[0].split("")[0];
       boolean b = false;
       int i = 0;
       for(String text : arr) {
           if(prefix != text.split("")[0]) {
               return prefix;
           }
           else {
               prefix+=arr[0].split("")[i+1];
               System.out.print("f");
           }
           i+=1;
       }
       return "";
    }
    public void Task5() {
       String[] arr = new String[] {"sadfsadf", "sadfasdf", "sad"};
       String long_prefix = "";

       System.out.println(getPrefix(arr));
    }
}
