/*
Лабораторная работа №1
Вариант 311808
Группа P3118 Михайлов Дмитрий
 */

public class Lab1 {
    public static void main(String[] args){
        //Объявление констант
        final float Fraction1 = (float) (1.0 / 3); //Дроби
        final float Fraction2 = (float) (2.0 / 3);
        final short MaximumRange = 17;
        final short MinimumRange = 11;

        short[] k = {21, 19, 17, 15, 13, 11, 9, 7, 5, 3, 1}; //Заполнение массива для задания №1

        float[] x = new float[MaximumRange]; //Заполнение массива для задания №2
        for(int i = 0; i < MaximumRange; i++){
            x[i] = (float) (Math.random() * (11 - (-15))) - 15;
        }

        float[][] d = new float[MinimumRange][MaximumRange]; //Заполнение массива для задания №3
        for(int i = 0; i < MinimumRange; i++){
            for(int j = 0; j < MaximumRange; j++){
                if(k[i] == 5){
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

        for(int i = 0; i < MinimumRange; i++){ //Вывод 1-ого массива
            System.out.print(" " + k[i] + " ");
        }
        System.out.println();

        for(int i = 0; i < MaximumRange; i++){ //Выовд 2-ого массива
            System.out.print(" " + x[i] + " ");
        }
        System.out.println();

        for(int i = 0; i < MinimumRange; i++){ //Вывод конечного массива
            for(int j = 0; j < MaximumRange; j++){
                String answer = String.format("%.2f", d[i][j]);
                System.out.print(" " + answer + " ");
            }
            System.out.println();
        }
    }
}
