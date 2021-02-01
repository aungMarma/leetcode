class PascalTriangle {
    // [1]
    // [1, 1]
    // [1, 2, 1]
    // [1, 3, 3, 1]
    // [1, 4, 6, 4, 1]
    public static int pascalTriangleValue(int row, int column) {
        // first column of each row is 1
        if (column == 1) {
            return 1;
        }
        // last column of each is 1
        // last column is 2nd for 2nd row, 3rd for 3rd row
        if (row == column) {
            return 1; 
        }

        return pascalTriangleValue(row - 1, column - 1) + pascalTriangleValue(row - 1, column);
    }

    public static void main(String[] args) {
        System.out.println(pascalTriangleValue(3, 2));
        System.out.println(pascalTriangleValue(5, 2));
        System.out.println(pascalTriangleValue(5, 3));
    }
}