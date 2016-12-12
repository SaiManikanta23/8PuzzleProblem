public class TraversedPath {

	private Integer pathNumber;
	private Moves move;
	private Node node;

	public TraversedPath(Moves move, Node node) {
		this.move = move;
		this.node = node;
	}

	public Integer getPathNumber() {
		return pathNumber;
	}

	public void setPathNumber(Integer pathno) {
		this.pathNumber = pathno;
	}

	public Moves getMove() {
		return move;
	}

	public void setMove(Moves move) {
		this.move = move;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

}
