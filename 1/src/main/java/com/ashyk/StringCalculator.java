package com.ashyk;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringCalculator {
    static int call = 0;

    public int Add(String numbers) throws Exception {
        call++;
        int sum = 0;
        Matcher m;
        ArrayList<String> delimeters = new ArrayList<String>();
        String nums[];

        if (numbers.substring(0, 2).equals("//")) {
            String inputs[] = numbers.split("\n", 2);
            Pattern p = Pattern.compile("\\[.+\\]");
            m = p.matcher(inputs[0]);
            while (m.find()) {
                System.out.println(m.group());
                delimeters.add(m.group().substring(1, m.group().length() - 1));
            }
            String splitter = ",|\n";
            for (String i : delimeters) {
                if (i.charAt(0) == '*') {
                    char z[] = i.toCharArray();
                    for (char j : z)
                        splitter += "|" + "\\" + j;
                } else
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
            else if (num > 1000)
                continue;
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
            int ans = sc.Add("//[***]\n3***4***5,1001\n");
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
