package me.ifmo;

public class Lab1{

    public static final int FIRST_ARRAY = 10;
    public static final int SECOND_ARRAY = 15;

    public static void fillFirstArray(short[] array){
        short tmp = 3;
        for(int i = 0; i < FIRST_ARRAY; i++){
            array[i] = tmp;
            tmp += 2;
        }
    }

    public static void fillSecondArray(double[] array){
        for(int i = 0; i < SECOND_ARRAY; i++){
            array[i] = (Math.random() * (10.0 - (-14.0))) - 14;
        }
    }

    public static void fillThirdArray(double[][] arrayThird, double[] arraySecond, short[] arrayFirst){
        for(int i = 0; i < FIRST_ARRAY; i++){
            for(int j = 0; j < SECOND_ARRAY; j++){
                switch(arrayFirst[i]){
                    case 3, 11, 13, 19, 21 -> arrayThird[i][j] = 0.25 * (Math.log(Math.abs(arraySecond[j])) - 1);
                    case 9 -> arrayThird[i][j] = Math.pow((Math.PI / (0.25 + Math.atan((1 / Math.pow(Math.E, Math.abs(arraySecond[j])))))) , 2);
                    default -> arrayThird[i][j] = Math.asin(1 / (Math.pow(Math.E, (Math.pow(Math.sqrt(Math.abs(arraySecond[j])) / 2, 2) + 1) / 4)));
                }
            }
        }
    }

    public static void main(String[] args){
        short[] l = new short[FIRST_ARRAY];
        double[] x = new double[SECOND_ARRAY];
        double[][] f = new double[FIRST_ARRAY][SECOND_ARRAY];
        fillFirstArray(l);
        fillSecondArray(x);
        fillThirdArray(f, x, l);

    }
}
