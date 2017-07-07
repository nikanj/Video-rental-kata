import java.util.ArrayList;
import java.util.List;

public class RentStatement {

	private double totalAmount = 0;
	private int frequentRenterPoints = 0;
	private String name;
	private List<VideoStore> videoStores = new ArrayList<>();

	public RentStatement(String name) {
		this.name = name;
	}

	public void addRental(VideoStore videoStore) {
		videoStores.add(videoStore);
	}

	public String createStatement() {
		String statement = createStatementHeader();
		statement += createStatementBody();
		statement += createStatementFooter();

		return statement;
	}

	private String createStatementHeader() {
		return "Rental Record for " + name + "\n";
	}

	private String createStatementBody() {
		String statementDetail = "";

		for (VideoStore videoStore : videoStores) {
			statementDetail += calculateAmountAndRentalPoints(videoStore);
		}

		return statementDetail;
	}

	private String calculateAmountAndRentalPoints(final VideoStore videoStore) {
		double thisAmount = videoStore.determineAmount();
		frequentRenterPoints += videoStore.calculateRentalPoints();
		String statementDetail = "\t" + videoStore.getTitle() + "\t" + thisAmount + "\n";
		totalAmount += thisAmount;

		return statementDetail;
	}

	private String createStatementFooter() {
		return "You owed " + totalAmount + "\nYou earned " + frequentRenterPoints + " frequent renter points\n";
	}

	public double getTotalRental() {
		return totalAmount;
	}

	public int getRentalPoints() {
		return frequentRenterPoints;
	}
}