package movies;

public class ChildrenMovie extends Movie{

	public ChildrenMovie(final String title) {
		super(title);
	}

	@Override
	public double determineRentalAmount(final int daysRented) {
		double amount = 1.5;

		if (daysRented > 3) {
			amount += (daysRented - 3) * 1.5;
		}

		return amount;
	}

	@Override
	public int determineFrequentRenterPoints(final int daysRented) {
		return 1;
	}
}
