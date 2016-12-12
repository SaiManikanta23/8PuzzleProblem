import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProblemSolution {

	static Integer widthOfPuzzle = 3;
	static Integer tileCount = 9;

	/* Up, Left, Down, Right of a node movement */
	static int distance[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
	static int findChild = 0;

	public static void main(String[] args) {
		String fileName = "input.txt";
		List<Integer> list = populateInput(fileName);
		System.out.println(list);
		if (!isSolvableState(list)) {
			System.out.println("It is a non solvable input!!");
			return;
		}

		Node node = new Node();
		node.setList(list);
		node.setG(0);

		node.setHeuristic(getHeuristic(list));
		node.setF(node.getHeuristic() + node.getG());
		int xPosition = getIndexOf0(list) / widthOfPuzzle;
		int yPosition = getIndexOf0(list) % widthOfPuzzle;
		node.setxPosition(xPosition);
		node.setyPosition(yPosition);
		node.setPre(4);

		Result result = new Result();
		result.setF(0);
		result.setNode(node);

		recursiveBestFirstSearch(node, Integer.MAX_VALUE, result);

	}

	private static Result recursiveBestFirstSearch(Node node, int f, Result result) {

		Result tempResult = new Result();

		TraversedPath path = new TraversedPath(Moves.valueOf(node.getPre()), node);
		tempResult.addTraversedPath(node.getG(), path);
		ArrayList<Node> childNodes = new ArrayList<Node>();

		if (node.getHeuristic() == 0) {
			tempResult.setF(f);
			tempResult.setNode(node);
			printTraversedPath(node);
			return tempResult;
		}

		for (int i = 0; i < 4; i++) {
			if (Math.abs(i - node.getPre()) == 2)
				continue;
			Node stat = createChildrenNode(node, distance[i][0], distance[i][1], i);
			if (findChild == 0)
				continue;
			childNodes.add(stat);
		}

		if (childNodes.size() == 0) {
			tempResult.setF(node.getF());
			tempResult.setNode(null);
			return tempResult;
		}

		while (true) {
			int nextBest = 0;
			Collections.sort(childNodes, new HeuristicComparator());
			Node bestNode = childNodes.get(0);
			if (bestNode.getF() > f) {
				tempResult.setF(bestNode.getF());
				tempResult.setNode(null);
				return tempResult;
			}
			if (childNodes.size() > 1)
				nextBest = childNodes.get(1).getF();
			else
				nextBest = Integer.MAX_VALUE;

			f = f < nextBest ? f : nextBest;
			tempResult = recursiveBestFirstSearch(bestNode, f, result);
			childNodes.get(0).setF(tempResult.getF());
			f = tempResult.getF();
			if (tempResult.getNode() != null)
				return tempResult;

		}
	}

	private static void printTraversedPath(Node node) {
		
		boolean printFlag = false;
		if(1<= node.getG())
		{
			System.out.println("------------------------------------------------");
			System.out.println("Sequence of Steps:");
		}
		for (int i = 1; i <= node.getG(); i++) {
			List resultTiles = Result.getTraversedPath().get(i).getNode().getTileList();
			System.out.println(Result.getTraversedPath().get(i).getMove());
			int z=0;
			System.out.println();
			for (int j = 0; j < 3; j++) {
				System.out.print(resultTiles.get(z) + "\t");
				System.out.print(resultTiles.get(z+1) + "\t");
				System.out.print(resultTiles.get(z+2) + "\n");
				z=z+3;
			}
			printFlag = true;
			System.out.println();
			System.out.println("------------------------------------------------");
		}
		if(!printFlag)
		{
			System.out.println("This is a solved input");
		}

	}

	private static Node createChildrenNode(Node parentNode, int xPosition, int yPosition, int pre) {

		int newX = parentNode.getxPosition();
		int newY = parentNode.getyPosition();

		Node childNode = new Node();

		if ((newX + xPosition) < 0 || (newY + yPosition) < 0 || (newX + xPosition) > (widthOfPuzzle - 1)
				|| (newY + yPosition) > (widthOfPuzzle - 1)) {
			findChild = 0;
			return childNode;

		}

		int nextEmptyTile = (newX + xPosition) * widthOfPuzzle + (newY + yPosition);

		List<Integer> list = new ArrayList<Integer>(parentNode.getTileList());
		int temp = list.get(nextEmptyTile);
		list.set(nextEmptyTile, 0);
		list.set(widthOfPuzzle * newX + newY, temp);

		childNode.setList(list);
		childNode.setxPosition(newX + xPosition);
		childNode.setyPosition(newY + yPosition);
		childNode.setG(parentNode.getG() + 1);
		childNode.setHeuristic(getHeuristic(list));
		childNode.setPre(pre);

		int maxfValue = (parentNode.getF()) > (childNode.getG() + childNode.getHeuristic()) ? parentNode.getF() : (childNode
				.getG() + childNode.getHeuristic());
		childNode.setF(maxfValue);
		findChild = 1;
		return childNode;
	}

	private static Integer getIndexOf0(List<Integer> lst) {
		for (int i = 0; i < lst.size(); i++) {
			if (lst.get(i) == 0) {
				return i;
			}
		}
		return 0;
	}

	private static Integer getHeuristic(List<Integer> list) {
		int manhattanDistance = 0;
		for (int i = 0; i < widthOfPuzzle; i++) {
			for (int j = 0; j < widthOfPuzzle; j++) {
				int pos = i * widthOfPuzzle + j;
				int val = list.get(pos);
				if (val == 0)
					continue;
				manhattanDistance = manhattanDistance + Math.abs((val / widthOfPuzzle) - i)
						+ Math.abs((val % widthOfPuzzle) - j);
			}
		}
		return manhattanDistance;
	}

	private static Boolean isSolvableState(List<Integer> lst) {
		Boolean isSolvable = true;
		int inversions = 0;
		for (int i = 0; i < lst.size(); i++) {
			for (int j = i; j < lst.size(); j++) {
				if ((lst.get(j) != 0) && lst.get(i) > lst.get(j)) {
					inversions++;
				}
			}
		}
		if (inversions % 2 != 0)
			isSolvable = false;
		return isSolvable;
	}

	private static List<Integer> populateInput(String fileName) {
		BufferedReader bufferedReader = null;
		List<Integer> tileList = new ArrayList<Integer>();
		try {
			InputStream stream = ProblemSolution.class.getResourceAsStream(fileName);
			String sCurrentLine;
			bufferedReader = new BufferedReader(new InputStreamReader(stream));
			while ((sCurrentLine = bufferedReader.readLine()) != null) {
				String[] line = sCurrentLine.split("\t");
				for (int i = 0; i < line.length; i++) {
					tileList.add(Integer.parseInt(line[i]));
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null)
					bufferedReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return tileList;
	}

}
