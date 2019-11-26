import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        new Main().reverse("numbers.txt","digits.txt");


    }
    private void reverse (String pathFrom, String passTo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(pathFrom));
             PrintWriter writer = new PrintWriter(passTo)) {
            String line;
            ArrayList<Integer> numbers = new ArrayList<>();
            while ((line=reader.readLine())!=null ) {

                if (line.length()>0) {
                            int [] array = findNumbers(line);
                            for (int value : array) {
                                numbers.add(value);
                            }
                        }
            }
            for (int i=numbers.size()-1;i>=0;i--) {
                writer.printf("%-9d : %4d\n",numbers.get(i),sumOfDigits(numbers.get(i)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int [] findNumbers(String s) {
        String [] arr = s.trim().replaceAll("\\s+"," ").split(" ");
        int [] numbers = new int [arr.length];
        for (int i=0;i<arr.length;i++) {
            numbers[i] = Integer.parseInt(arr[i]);
        }
        return numbers;
    }

    private int  sumOfDigits (int number) {
        int sum = 0;
        int n=10;
        int num;

        if (number<0) {
            num = number*-1;
        }
        else {
            num = number;
        }
        sum+=num%n;
        while ((num/n)>0){
            sum+=num/n%10;
            n*=10;
        }
        return sum;
    }
}
