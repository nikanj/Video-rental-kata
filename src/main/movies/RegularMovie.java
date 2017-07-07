package movies;

public class RegularMovie extends Movie {
	public RegularMovie(String title) {
		super(title);
	}

	public double determineRentalAmount(int daysRented) {
		double thisAmount = 2;

		if (daysRented > 2) {
			int extraDays = daysRented - 2;
			thisAmount += extraDays * 1.5;
		}

		return thisAmount;
	}

	public int determineFrequentRenterPoints(int daysRented) {
		return 1;
	}
}