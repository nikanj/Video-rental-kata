package movies;

public class NewlyReleasedMovie extends Movie {

	public NewlyReleasedMovie(final String title) {
		super(title);
	}

	@Override
	public double determineRentalAmount(final int daysRented) {
		return daysRented * 3;
	}

	@Override
	public int determineFrequentRenterPoints(final int daysRented) {

		if (daysRented > 1) {
			return 2;
		}

		return 1;
	}
}
