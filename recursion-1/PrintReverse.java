class PrintReverse{
    public static void printReserve(String str) {
        helper(str, 0);
    }

    // to optimize the stack, make these methods as instance methods and have an instance varible of string, assign user input string to that variable and access that from the helper, instead of passing it in every recursive call
    public static void helper(String str, int index) {
        if (str == null || index >= str.length()) {
            return;
        }
        helper(str, index + 1);
        System.out.println(str.charAt(index));
    }
}