import java.util.Comparator;

public class HeuristicComparator implements Comparator<Node> {

	@Override
	public int compare(Node node1, Node node2) {
		return node1.getF() - node2.getF();
	}

}
