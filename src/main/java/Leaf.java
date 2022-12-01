import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = true)
public class Leaf extends Node {
    public Leaf(String character, double probability) {
        super(probability, character);
    }
}