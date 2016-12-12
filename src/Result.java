import java.util.ArrayList;
import java.util.List;

public class Result {
	private int f;
	private Node node;
	private static List<TraversedPath> traversedPath = new ArrayList<TraversedPath>();

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public static List<TraversedPath> getTraversedPath() {
		return traversedPath;
	}

	public static void setTraversedPath(List<TraversedPath> path) {
		Result.traversedPath = path;
	}

	public void addTraversedPath(int i, TraversedPath pat) {
		Result.traversedPath.add(i, pat);
	}

	public void removeTraversedPath(int g) {
		Result.traversedPath.remove(g);
	}
}
