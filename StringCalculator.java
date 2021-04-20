class StringCalculator {
    public int Add(String numbers) {
        int sum = 0;
        String nums[] = numbers.split(",");
        for (int i = 0; i < Integer.min(nums.length, 3); i++) {
            if (nums[i] == "")
                continue;
            sum += Integer.parseInt(nums[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        StringCalculator sc = new StringCalculator();
        int ans = sc.Add("1,2,3");
        System.out.println(ans);
    }
}
