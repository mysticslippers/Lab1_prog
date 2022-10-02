/*
Лабораторная работа №1
Вариант 311808
Группа P3118 Михайлов Дмитрий
 */

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Tasks {

    static void FillingFirstArray(short[] arr, short MaximumValue) {
        for (short i = 0; i < MaximumValue; i++) {
            if ((MaximumValue - i) % 2 != 0) {
                arr[i] = (short) (MaximumValue - i);
            }
        }
        for (short i = 0; i < (MaximumValue / 2); i++) {
            short tmp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = tmp;
        }
    }

    static void FillingSecondArray(float[] arr, short MaximumRange) {
        for (int i = 0; i < MaximumRange; i++) {
            arr[i] = (float) (Math.random() * (11.0 - (-15.0))) - 15;
        }
    }

    public static void main(String[] args) {
        final float Fraction1 = (float) (1.0 / 3);
        final float Fraction2 = (float) (2.0 / 3);
        final short MinimumValue = 11;
        final short MaximumValue = 17;

        short[] k = new short[MinimumValue]; //Объявление и заполнение 1-ого массива.
        Tasks.FillingFirstArray(k, MinimumValue);

        float[] x = new float[MaximumValue]; //Объявление и заполнение 2-ого массива.
        Tasks.FillingSecondArray(x, MaximumValue);

        float[][] d = new float[MinimumValue][MaximumValue];
        for (int i = 0; i < MinimumValue; i++) {
            for (int j = 0; j < MaximumValue; j++) {
                if (k[i] == 5) {
                    d[i][j] = (float) Math.pow(((Math.pow((0.5 * (x[j] + Fraction1)), x[j]) / (Math.cbrt(x[j]) - Math.PI))) / 3, 3);
                } else if (k[i] == 1 || k[i] == 9 || k[i] == 11 || k[i] == 15 || k[i] == 21) {
                    d[i][j] = (float) Math.asin(Math.pow(Math.E, Math.cbrt(Math.pow(-Math.sin(x[j]), 2))));
                } else {
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
                    answer = "0.00";
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
