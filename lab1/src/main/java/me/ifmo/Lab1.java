package me.ifmo;

public class Lab1{

    public static final int FIRST_ARRAY = 10;
    public static final int SECOND_ARRAY = 15;

    public static short[] fillFirstArray(short[] array){
        short tmp = 3;
        for(int i = 0; i < FIRST_ARRAY; i++){
            array[i] = tmp;
            tmp += 2;
        }
        return array;
    }

    public static double[] fillSecondArray(double[] array){
        for(int i = 0; i < SECOND_ARRAY; i++){
            array[i] = (Math.random() * (10.0 - (-14.0))) - 14;
        }
        return array;
    }

    public static void main(String[] args){

    }
}
