import java.util.HashMap;
import java.util.Map;

public enum Moves {
	UP(0), LEFT(1), DOWN(2), RIGHT(3), NONE(4);

	private static Map<Integer, Moves> movesMap = new HashMap<Integer, Moves>();

	private final int value;

	static {
		for (Moves move : Moves.values()) {
			movesMap.put(move.value, move);
		}
	}

	private Moves(int value) {
		this.value = value;
	}
	
	public static Moves valueOf(int move) {
		return movesMap.get(move);
		}
	}
