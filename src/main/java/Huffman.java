import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

public class Huffman {

    private Node root;
    private final String[] text;

    private final String[] alphabet;
    private Map<String, Double> charProbabilities;
    private final Map<String, String> huffmanCodes;


    public Huffman(String[] alphabet, String[] text, List<Double> probabilities) {
        this.alphabet = alphabet;
        this.text = text;
        fillCharProbabilitiesMap(probabilities);
        huffmanCodes = new HashMap<>();
    }

    private void fillCharProbabilitiesMap(List<Double> probabilities) {
        int index = 0;
        charProbabilities = new HashMap<>();
        for (String character : alphabet) {
            charProbabilities.put(character, probabilities.get(index));
            index++;
        }
    }


    public String encode() {
        Queue<Node> queue = new PriorityQueue<>();
        charProbabilities.forEach((character, probability) ->
                queue.add(new Leaf(character, probability))
        );
        // Добавляем новые узлы и удаляем из очереди элементы с наименьшими вероятностями
        while (queue.size() > 1) {
            queue.add(new Node(queue.poll(), requireNonNull(queue.poll())));
        }
        generateHuffmanCodes(root = queue.poll(), "");
        return getEncodedText();
    }

    // Рекурсивно добавляем коды
    private void generateHuffmanCodes(Node node, String code) {
        if (node instanceof Leaf leaf) {
            huffmanCodes.put(leaf.getCharacter(), code);
            return;
        }
        generateHuffmanCodes(node.getLeftNode(), code.concat("0"));
        generateHuffmanCodes(node.getRightNode(), code.concat("1"));
    }

    private String getEncodedText() {
        StringBuilder sb = new StringBuilder();
        for (String character : text) {
            sb.append(huffmanCodes.get(character));
        }
        return sb.toString();
    }

    public void printCodes() {
        huffmanCodes.forEach((character, code) ->
                System.out.println(character + ": " + code)
        );
    }
}
