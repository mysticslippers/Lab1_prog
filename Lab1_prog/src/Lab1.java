/*
Лабораторная работа №1
Вариант 311808
Группа P3118 Михайлов Дмитрий
 */

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Lab1{
    final static float Fraction1 = (float) (1.0 / 3);
    final static float Fraction2 = (float) (2.0 / 3);
    final static short MinimumValue = 11;
    final static short MaximumValue = 17;
    static void FillingFirstArray(short[] arr, short MaximumValue) {
        short tmp = 21;
        while(tmp != 0){
            if(tmp % 2 != 0){
                arr[MaximumValue - ((tmp + 1) / 2)] = tmp;
            }
            tmp--;
        }
    }

    static void FillingSecondArray(float[] arr, short MaximumRange) {
        for (int i = 0; i < MaximumRange; i++) {
            arr[i] = (float) (Math.random() * (11.0 - (-15.0))) - 15;
        }
    }

    public static void main(String[] args) {


        short[] k = new short[MinimumValue]; //Объявление и заполнение 1-ого массива.
        FillingFirstArray(k, MinimumValue);

        float[] x = new float[MaximumValue]; //Объявление и заполнение 2-ого массива.
        FillingSecondArray(x, MaximumValue);

        float[][] d = new float[MinimumValue][MaximumValue];
        for (int i = 0; i < MinimumValue; i++) {
            for (int j = 0; j < MaximumValue; j++) {
                if (k[i] == 5) {
                    d[i][j] = (float) Math.pow(((Math.pow((0.5 * (x[j] + Fraction1)), x[j]) / (Math.cbrt(x[j]) - Math.PI))) / 3, 3);
                }
                else if(k[i] == 1 || k[i] == 9 || k[i] == 11 || k[i] == 15 || k[i] == 21){
                    d[i][j] = (float) Math.asin(Math.pow(Math.E, Math.cbrt(Math.pow(-Math.sin(x[j]), 2))));
                }
                else{
                    d[i][j] = (float) Math.asin(Math.pow(Math.E, Math.cbrt(-Math.abs(Math.pow(Fraction2 * (3 + Math.cbrt(x[j])), Math.exp(Math.abs(x[j])))))));
                }
            }
        }
        System.out.println("Выввод первого массива!");
        for (int i = 0; i < MinimumValue; i++) { //Вывод 1-ого массива
            System.out.print(" " + k[i] + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("Вывод второго массива!");
        for (int i = 0; i < MaximumValue; i++) { //Выовд 2-ого массива
            System.out.print(" " + x[i] + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("Вывод третьего массива!");
        for (int i = 0; i < MinimumValue; i++) {  //Вывод 3-его массива
            for (int j = 0; j < MaximumValue; j++) {
                String answer = String.valueOf(d[i][j]);
                if(answer.equals("NaN")){ //Если надо заменить NaN-ы на что-нибудь.
                    answer = "NaN" + " ";
                }
                else{
                    answer = String.valueOf(BigDecimal.valueOf(d[i][j]).setScale(2, RoundingMode.DOWN));
                    if(answer.length() > 5){
                        answer = "0.00";
                    }
                }
                System.out.print(answer + "\t");
            }
            System.out.println();
        }
    }
}