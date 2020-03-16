import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class RaceResults {
	private HashMap<String, TimeDuration> results = new HashMap<>();

	public static void main(String[] args) {
		RaceResults rs = new RaceResults();
		rs.onNewResult("Alan MALONGA", new TimeDuration(1000));
		rs.onNewResult("code java", new TimeDuration(800));
		rs.printResults();

	}

	public void onNewResult(String tagNumber, TimeDuration resultTime) {
		results.put(tagNumber, resultTime);
	}

	public void printResults() {
		TimeDuration TimeMin = Collections.min(results.values(), (a, b) -> a.getSeconds() - b.getSeconds());
		int nbWinners = (int) results.entrySet().stream().filter(a -> a.getValue().equals(TimeMin)).count();

		String affichage = nbWinners > 1 ? "Nous avons " + nbWinners + " gagnants :\n" : "le(s) gagnant(s) est/sont ";
		System.out.print(affichage);
		for (Entry<String, TimeDuration> entry : results.entrySet()) {

			if (entry.getValue().equals(TimeMin)) {
				System.out.println(entry.getKey() + " avec un résultat de " + entry.getValue());
			}
		}
		System.out.println("The results of other participants : ");
		results.entrySet().stream().filter(a -> !a.getValue().equals(TimeMin))
				.sorted((t1, t2) -> t1.getValue().getSeconds() - t2.getValue().getSeconds())
				.forEach(System.out::println);
	}

}
