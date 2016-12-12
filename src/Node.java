import java.util.List;

public class Node {

	private int f, g, heuristic;
	private int xPosition, yPosition;
	private int pre;
	private List<Integer> tileList;

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getHeuristic() {
		return heuristic;
	}

	public void setHeuristic(int heuristic) {
		this.heuristic = heuristic;
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public int getPre() {
		return pre;
	}

	public void setPre(int pre) {
		this.pre = pre;
	}

	public List<Integer> getTileList() {
		return tileList;
	}

	public void setList(List<Integer> tileList) {
		this.tileList = tileList;
	}

	@Override
	public String toString() {
		return "Node [f=" + f + ", g=" + g + ", heuristic=" + heuristic + ", xPosition=" + xPosition + ", yPoitions=" + yPosition + ", pre=" + pre
				+ ", list=" + tileList + "]";
	}
}
