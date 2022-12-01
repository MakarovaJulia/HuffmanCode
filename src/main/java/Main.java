import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        String[] word = scanner.nextLine().split(" ");
        System.out.println(Arrays.toString(word));

        String[] alphabet = scanner.nextLine().split(" ");
        System.out.println(Arrays.toString(alphabet));

        List<Double> probabilities = new ArrayList<>();

        for (int i = 0; i < alphabet.length; i++){
            probabilities.add(scanner.nextDouble());
        }

        Huffman huffman = new Huffman(alphabet, word, probabilities);

        String encodedText = huffman.encode();
        System.out.println(encodedText);

        huffman.printCodes();
    }
}
