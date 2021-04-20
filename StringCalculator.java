class StringCalculator {
    public int Add(String numbers) {
        int sum = 0;
        String nums[] = numbers.split(",");
        for (String num : nums) {
            if (num == "")
                continue;
            sum += Integer.parseInt(num);
        }
        return sum;
    }

    public static void main(String[] args) {
        StringCalculator sc = new StringCalculator();
        int ans = sc.Add("");
        System.out.println(ans);
    }
}
