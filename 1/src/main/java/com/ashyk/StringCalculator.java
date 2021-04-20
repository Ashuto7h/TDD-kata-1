package com.ashyk;

import java.util.ArrayList;

class StringCalculator {
    static int call = 0;

    public int Add(String numbers) throws Exception {
        call++;
        int sum = 0;
        char delimiters[];
        String nums[];
        if (numbers.substring(0, 2).equals("//")) {
            String inputs[] = numbers.split("\n", 2);
            delimiters = inputs[0].substring(2).toCharArray();
            String splitter = ",|\n";
            for (char i : delimiters) {
                splitter += "|" + i;
            }
            nums = inputs[1].split(splitter);
        } else {
            nums = numbers.split(",|\n");
        }
        ArrayList<Integer> negetives = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == "")
                continue;
            int num = Integer.parseInt(nums[i]);

            if (num < 0)
                negetives.add(num);
            else
                sum += num;
        }
        if (!negetives.isEmpty()) {
            String msg = "negatives not allowed : ";
            for (int i : negetives)
                msg += i + " ";
            throw new Exception(msg);
        }
        return sum;
    }

    public int getCalledCount() {
        return call;
    }

    public static void main(String[] args) {
        StringCalculator sc = new StringCalculator();
        try {
            int ans = sc.Add("//;\n3,4;5,-4\n-5");
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}