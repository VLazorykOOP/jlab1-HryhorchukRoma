import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lab  Java");
        System.out.println("Enter task: ");
        String inptask = scanner.nextLine();
        int task = Integer.parseInt(inptask);
        if(task==1){
            System.out.println("Enter specific: ");
            String inpspec = scanner.nextLine();
            int spec = Integer.parseInt(inpspec);
            if(spec==1){
                System.out.print("Enter m: ");
                double m = scanner.nextDouble();
                System.out.print("Enter n: ");
                double n = scanner.nextDouble();
                if (n != m) {
                    double res = ((n + 1.0) / (n * n * m + 2.0)) + ((m + n) / (m - n)) + (n * n * n);
                    DecimalFormat df = new DecimalFormat("#.##");
                    System.out.println("Result: " + df.format(res));
                } else {
                    System.out.println("Wrong meaning");
                }
                scanner.close();
            }
            else if (spec==2) {
                System.out.print("Enter m: ");
                int m = scanner.nextInt();
                System.out.print("Enter n: ");
                int n = scanner.nextInt();
                if (n != m) {
                    int mInt = (int) m;
                    int nInt = (int) n;
                    double res = ((nInt + 1.0) / (nInt * nInt * nInt + 2.0)) + ((mInt + nInt) / (mInt - nInt)) + (nInt * nInt * nInt);
                    DecimalFormat df = new DecimalFormat("#.##");
                    System.out.println("Result: " + df.format(res));
                } else {
                    System.out.println("Wrong meaning");
                }
                scanner.close();
            }
            else if(spec==3){
                System.out.print("Enter m: ");
                double m = scanner.nextDouble();
                System.out.print("Enter n: ");
                double n = scanner.nextDouble();
                if (n != m) {
                    double mDouble = (double) m;
                    double nDouble = (double) n;
                    double resd = ((nDouble + 1.0) / (nDouble * nDouble * mDouble + 2.0)) + ((mDouble + nDouble) / (mDouble - nDouble)) + (nDouble * nDouble * nDouble);
                    int res=(int) resd;
                    DecimalFormat df = new DecimalFormat("#.##");
                    System.out.println("Result: " + df.format(res));
                } else {
                    System.out.println("Wrong meaning");
                }
            }
        }
        else if (task==2){
            System.out.print("Введіть довжину масиву A: ");
            int n = scanner.nextInt();
            int[] A = new int[n];
            System.out.println("Введіть елементи масиву A:");
            for (int i = 0; i < n; i++) {
                A[i] = scanner.nextInt();
            }
            int[] B = new int[n];
            int bSize = 0;
            for (int i = 0; i < n; i++) {
                boolean isDuplicate = false;
                for (int j = 0; j < bSize; j++) {
                    if (A[i] == B[j]) {
                        isDuplicate = true;
                        break;
                    }
                }
                if (!isDuplicate) {
                    B[bSize] = A[i];
                    bSize++;
                }
            }
            System.out.println("Масив B з унікальними значеннями: " + Arrays.toString(Arrays.copyOf(B, bSize)));
            scanner.close();
        }
        else if (task==3){
            System.out.print("Введіть розмірність матриці (n): ");
            int n = scanner.nextInt();
            if (n <= 0 || n > 20) {
                System.out.println("Розмірність матриці повинна бути в межах від 1 до 20.");
                return;
            }
            double[][] matrix = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print("Введіть елемент матриці A[" + i + "][" + j + "]: ");
                    matrix[i][j] = scanner.nextDouble();
                }
            }
            double maxElement = matrix[0][0];
            int maxRow = 0;
            int maxCol = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] > maxElement) {
                        maxElement = matrix[i][j];
                        maxRow = i;
                        maxCol = j;
                    }
                }
            }
            if (maxRow != 0) {
                double[] temp = matrix[0];
                matrix[0] = matrix[maxRow];
                matrix[maxRow] = temp;
            }
            if (maxCol != 0) {
                for (int i = 0; i < n; i++) {
                    double temp = matrix[i][0];
                    matrix[i][0] = matrix[i][maxCol];
                    matrix[i][maxCol] = temp;
                }
            }
            System.out.println("Матриця після перестановки:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%.0f\t", matrix[i][j]);
                }
                System.out.println();
            }
            scanner.close();
        }
        else if(task==4){
            System.out.print("Введіть текст: ");
            String inputText = scanner.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(inputText, " .,!?;:()");
            while (tokenizer.hasMoreTokens()) {
                String word = tokenizer.nextToken();
                if (isSymmetric(word)) {
                    System.out.println("Симетричне слово: " + word);
                }
            }
            scanner.close();
        }
        else {
            System.out.println("Wrong meaning");
            scanner.close();
        }
    }
    public static boolean isSymmetric(String word) {
        int length = word.length();
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
