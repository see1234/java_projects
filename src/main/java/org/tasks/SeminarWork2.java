package org.tasks;

import java.util.Scanner;

public class SeminarWork2 {


    public SeminarWork2() {
        Task1();
    }

    public void Task1() {
        Scanner sc = new Scanner(System.in);
        var leng = sc.nextInt();
        if (leng % 2 == 0) {
            StringBuilder res = new StringBuilder();
            while(leng > 0) {
                    res.append("c1c2");
                leng--;
            }
            System.out.println(res.toString());

        }

    }
}
