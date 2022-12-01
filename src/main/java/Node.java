import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Node implements Comparable<Node> {

    private final double probability;
    private Node leftNode;
    private Node rightNode;

    public Node(Node leftNode, Node rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.probability = leftNode.getProbability() + rightNode.getProbability();
    }

    @Override
    public int compareTo(Node node) {
        return Double.compare(probability, node.getProbability());
    }
}