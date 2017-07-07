import movies.Movie;

public class VideoStore {
	private Movie movie;
	private int daysRented;

	public VideoStore(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	double determineAmount() {
		return getMovie().determineRentalAmount(getDaysRented());
	}

	int calculateRentalPoints() {
		return getMovie().determineFrequentRenterPoints(getDaysRented());
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public String getTitle() {
		return movie.getTitle();
	}
}