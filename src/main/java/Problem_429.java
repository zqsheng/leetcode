import java.util.Arrays;
import java.util.List;

public class Problem_429 {

    public static void main(String[] args) {
        Node n2 = new Node(2);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n3 = new Node(3, Arrays.asList(n5,n6));
        Node n1 = new Node(1,Arrays.asList(n3,n2,n4));

    }
    public List<List<Integer>> levelOrder(Node root) {

        return null;
    }
}
