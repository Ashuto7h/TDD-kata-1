class StringCalculator {
    public int Add(String numbers) {
        int sum = 0;
        String nums[] = numbers.split(",|\n");
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == "")
                continue;
            sum += Integer.parseInt(nums[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        StringCalculator sc = new StringCalculator();
        int ans = sc.Add("1,2\n3,4");
        System.out.println(ans);
    }
}
