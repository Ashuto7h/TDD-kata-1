class StringCalculator {
    public int Add(String numbers) {
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
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == "")
                continue;
            sum += Integer.parseInt(nums[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        StringCalculator sc = new StringCalculator();
        int ans = sc.Add("//;-\n3-4;5,4\n5");
        System.out.println(ans);
    }
}
