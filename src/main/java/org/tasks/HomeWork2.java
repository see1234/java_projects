package org.tasks;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.*;

public class HomeWork2 {
    Logger logger;


    public HomeWork2() {
        try {
            LogManager.getLogManager().readConfiguration(HomeWork2.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger = Logger.getLogger(HomeWork2.class.getName());
        logger.setLevel(Level.INFO);




        Task1();


    }
    public void Task1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("select * from students where ");
        StringBuilder input = new StringBuilder().append(sc.next());
        if(input == null) {
            System.out.println("error null");
            return;
        }
        Object obj = null;
        try {
            obj = new JSONParser().parse("{\"students\": [{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"},{\"name\":\"Ivanov3\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}]}");
            //я не знал как можно без students
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        StringBuilder res = new StringBuilder();
        JSONObject jo = (JSONObject) obj;
        JSONArray memberArr = (JSONArray) jo.get("students");
        Iterator membersItr = memberArr.iterator();
        while (membersItr.hasNext()) {
            JSONObject jsobj = (JSONObject) membersItr.next();
            String param = jsobj.get(input.toString()).toString().replace(" ","");
            if(!param.equals("null")) {

                res.append(param + "\n");
            }

        }
        System.out.println(res);

    }
    public void Task2() {
        int[] numbers = { 423, 534, 634, 23412, 5342324, 53241 };
        int temp;
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    temp = numbers[j + 1];
                    logger.log(Level.INFO,Arrays.toString(numbers));
                    numbers[j + 1] = numbers[j];

                    logger.log(Level.INFO,"Заменяем: " + numbers[j + 1] + " на " + numbers[j]);
                    numbers[j] = temp;
                    logger.log(Level.INFO,Arrays.toString(numbers));
                    logger.log(Level.INFO,"Заменяем: " + numbers[j] + " на " + temp);
                    logger.log(Level.INFO,Arrays.toString(numbers));
                }
            }
        }
    }
    public void Task3() {

        Object obj = null;
        try {
            obj = new JSONParser().parse("{\"students\": [{\"фамилия\":\"иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},\n" +
                    "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"информатика\"},\n" +
                    "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]}");
            //кодировка хз какую ставить, по этому "и" маленькие
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        StringBuilder res = new StringBuilder();
        JSONObject jo = (JSONObject) obj;
        JSONArray memberArr = (JSONArray) jo.get("students");
        Iterator membersItr = memberArr.iterator();

        while (membersItr.hasNext()) {
            JSONObject jsobj = (JSONObject) membersItr.next();

            res.append((("Студент [фамилия] получил [оценка] по предмету [предмет].".replace("[предмет]",jsobj.get("предмет").toString()).replace("[оценка]",jsobj.get("оценка").toString()).replace("[фамилия]",jsobj.get("фамилия").toString()

                             ))) + "\n");
        }
        System.out.println(res);
    }
    public void Task4() {

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число #1: ");
        int num1 = scan.nextInt();
        System.out.print("Введите число #2: ");
        int num2 = scan.nextInt();
        System.out.print("Введите операцию: ");
        String op = scan.next();
        switch (op) {
            case "*":
                System.out.println("Ответ: " + (num1 * num2));
                logger.log(Level.INFO,"Ответ: " + (num1 * num2));
                break;
            case "/":
                System.out.println("Ответ: " + (num1 / num2));
                logger.log(Level.INFO,"Ответ: " + (num1 / num2));
                break;
            case "+":
                System.out.println("Ответ: " + (num1 + num2));
                logger.log(Level.INFO,"Ответ: " + (num1 + num2));
                break;
            case "-":
                System.out.println("Ответ: " + (num1 - num2));
                logger.log(Level.INFO,"Ответ: " + (num1 - num2));
                break;
        }
    }
}
