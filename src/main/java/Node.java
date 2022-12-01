import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Node implements Comparable<Node> {

    private final double probability;
    private final String character;
    private Node leftNode;
    private Node rightNode;

    public Node(Node leftNode, Node rightNode) {
        this.character = leftNode.getCharacter() + rightNode.getCharacter();
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.probability = leftNode.getProbability() + rightNode.getProbability();
    }

    @Override
    public int compareTo(Node node) {
        return Double.compare(probability, node.getProbability());
    }

    public int compareChars(Node node) {
        return node.getCharacter().compareTo(character);
    }

    @Override
    public String toString(){
        return this.probability + " " + this.character;
    }
}