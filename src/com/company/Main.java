package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Меню
        while (true) {
            String[] line = sc.nextLine().trim().split(" ");
            switch (line[0]) {
                case "task1":
                    task1(line);
                    break;
                case "task2":
                    task2(line);
                    break;
                case "task3":
                    task3(line);
                    break;
                case "task4":
                    task4(line);
                    break;
                case "task5":
                    task5(line);
                    break;
                case "task6":
                    task6(line);
                    break;
                case "task7":
                    task7(line);
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Ошибка. Доступные команды:\n" +
                            "task1 [text],\n" +
                            "task2 [n1 n2...],\n" +
                            "task3 [string word text],\n" +
                            "task4 [text],\n" +
                            "task5 [string],\n" +
                            "task6 [n],\n" +
                            "task7 [char1 char2...].");
            }
        }
    }

    static void task1(String[] args) {
        //Определяем среднюю длину
        int middle = 0;
        for (int i = 1; i < args.length; i++) {
            middle += args[i].length();
        }
        middle = (middle / (args.length - 1));

        //Ищем нужные строки
        for (int i = 1; i < args.length; i++) {
            if (args[i].length() > middle)
                System.out.printf("\nДлина: %s, Строка: %s", args[i].length(), args[i]);
        }
    }

    static void task2(String[] args) {
        //Создаём массив
        double[] array = new double[args.length];
        for (int i = 1; i < args.length; i++) {
            array[i - 1] = Double.valueOf(args[i]);
        }

        //Ищем минимальный элемент
        double min = array[0];
        for (double numb : array) {
            if (numb < min) min = numb;
        }

        //Ищем сумму нужных элементов
        double summ = 0;
        int firstIndex = -1;
        int lastIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                firstIndex = i;
                break;
            }
        }
        for (int i = array.length - 1; i > -1; i--) {
            if (array[i] > 0) {
                lastIndex = i;
                break;
            }
        }
        if ((firstIndex == -1) || (lastIndex == -1) || (lastIndex - firstIndex < 2)) return;
        for (int i = firstIndex + 1; i < lastIndex; i++)
            summ += array[i];

        System.out.printf("\nМинимальный: %s, сумма элементов между первым и последним положительным: %s", min, summ);
    }

    static void task3(String[] args) {
        //Достаём текст из аргументов
        StringBuilder text = new StringBuilder();
        for (int i = 3; i < args.length; i++) {
            text.append(args[i]).append(" ");
        }
        String subStr = args[1];
        String word = args[2];

        //Вставляем слова в указанные места
        int index = text.indexOf(subStr);
        while (true) {
            text.insert(index+1,' '+word);
            index=index+word.length();
            while (text.charAt(index + 1) != ' ') {
                index = text.indexOf(subStr, index+1);
                if (index == -1) {
                    System.out.println("Результат: " + text.toString());
                    return;
                }
            }
        }
    }

    static void task4(String[] args) {
        StringBuilder res=new StringBuilder();
        res.append(' ');
        for (int i=1;i<args.length;i++){
            if ((args[i].charAt(0)==args[i].charAt(args[i].length()-1)) &&
                    (res.indexOf(' '+args[i]+' ')==-1))
                res.append(args[i]).append(' ');
        }
        System.out.println("Результат: "+res.toString().trim());
    }

    static void task5(String[] args) {
        StringBuilder res=new StringBuilder();
        for (int i=1;i<args[1].length();i+=2){
            res.append(args[1].charAt(i));
        }
        System.out.println("Результат: "+res.toString());
    }

    static void task6(String[] args){
        int n = Integer.valueOf(args[1]);

        StringBuilder template;

        for (int i = (n/2+n%2);i>0;i--)
        {
            template = new StringBuilder();
            for (int j=0;j<n;j++){
                if ((j==i-1)||(j==n-i)) template.append('*');
                else {
                    if (i==1)
                    template.append('*');
                    else
                    template.append(' ');
                }}
            System.out.println(template);
        }
    }

    static void task7(String[] args){
        StringBuilder res = new StringBuilder();
        for (int i=1;i<args.length;i++){
            res.append(args[i].charAt(0));
        }

        char buffer;
        for(int i=1; i < args.length; i++){
            for(int j=1; j < (args.length-i); j++){
                if(res.charAt(j-1) > res.charAt(j)){
                    buffer = res.charAt(j-1);
                    res.setCharAt(j-1,res.charAt(j));
                    res.setCharAt(j,buffer);
                }

            }
        }

        for (char c:res.toString().toCharArray())
        {
            System.out.print(c+" ");
        }
    }
}
