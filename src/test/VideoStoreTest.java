import movies.ChildrenMovie;
import movies.NewlyReleasedMovie;
import movies.RegularMovie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VideoStoreTest {

	@Before
	public void setUp() {
		rentStatement = new RentStatement("Fred");
	}

	@Test
	public void testSingleNewReleaseMovieStatement() {
		rentStatement.addRental(new VideoStore(createNewReleasedMovie("New Release 1"), 3));

		rentStatement.createStatement();

		assertRentalPointsAndAmount(9.0, 2);
	}

	private void assertRentalPointsAndAmount(final double expected, final int expected2) {
		assertEquals(expected, rentStatement.getTotalRental(), 0.0001);
		assertEquals(expected2, rentStatement.getRentalPoints());
	}

	private NewlyReleasedMovie createNewReleasedMovie(final String title) {
		return new NewlyReleasedMovie(title);
	}

	@Test
	public void testDualNewReleaseMoviesStatement() {
		rentStatement.addRental(new VideoStore(createNewReleasedMovie("New Release 1"), 3));
		rentStatement.addRental(new VideoStore(createNewReleasedMovie("New Release 2"), 3));

		rentStatement.createStatement();

		assertRentalPointsAndAmount(18.0, 4);
	}

	@Test
	public void testSingleChildrenMovieStatement() {
		rentStatement.addRental(new VideoStore(new ChildrenMovie("Children Movie"), 3));

		rentStatement.createStatement();

		assertRentalPointsAndAmount(1.5, 1);
	}

	@Test
	public void testMultipleRegularStatementFormat() {
		rentStatement.addRental(new VideoStore(createRegularMovie("Regular1"), 1));
		rentStatement.addRental(new VideoStore(createRegularMovie("Regular2"), 2));
		rentStatement.addRental(new VideoStore(createRegularMovie("Regular3"), 3));

		assertEquals("Rental Record for Fred\n\t"
		             + "Regular1\t2.0\n\t"
		             + "Regular2\t2.0\n\t"
		             + "Regular3\t3.5\n"
		             + "You owed 7.5\n"
		             + "You earned 3 frequent renter points\n", rentStatement.createStatement());

	}

	private RegularMovie createRegularMovie(final String regular1) {
		return new RegularMovie(regular1);
	}

	private RentStatement rentStatement;
}