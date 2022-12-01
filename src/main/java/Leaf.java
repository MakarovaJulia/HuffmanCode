import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = true)
public class Leaf extends Node {

    private final String character;

    public Leaf(String character, double probability) {
        super(probability);
        this.character = character;
    }

}