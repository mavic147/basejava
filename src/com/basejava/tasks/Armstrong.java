package com.basejava.tasks;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Armstrong {
    static TreeSet<Long> result = new TreeSet<>();
    static long[][] powers = new long[10][10];

    static {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                powers[i][j] = (long) Math.pow(i, j);
            }
        }
    }

    public static boolean isCheckNeeded(long num) {
        if (num % 10 == 0) {
            return true;
        }
        long buff = num;
        long prevDigit;
        long currentDigit;
        while (buff != 0) {
            currentDigit = buff % 10;
            prevDigit = (buff / 10) % 10;
            if (currentDigit < prevDigit) {
                return false;
            }
            buff /= 10;
        }
        return true;
    }

    public static long getArmstrong(long num) {
        int m = Long.toString(num).length();
        long res = 0;
        long buff = num;
        while (buff != 0) {
            res += powers[(int) (buff % 10)][m];
            buff /= 10;
        }
        return res;
    }

    public static boolean isArmstrong(long num) {
        return getArmstrong(num) == num;
    }

    public static long[] toArray(Set<Long> res) {
        long[] buff = new long[res.size()];
        int index = 0;
        for (Long l : res) {
            buff[index] = l;
            index++;
        }
        return buff;
    }

    public static long[] getNumbers(long N) {
        long num = 0; //исправить на 0
        int m = 1; //количество цифр в числе
        int nextRank = 10;
        while (num < N) {
            if (isCheckNeeded(num)) {
                long res = getArmstrong(num);
                if (isArmstrong(res) && res < N) {
                    result.add(res);
                }
            }
            num++;
            if (num >= nextRank) {
                nextRank *= 10;
                m += 1;
            }
        }
        return toArray(result);
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a));

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a));
    }
}
