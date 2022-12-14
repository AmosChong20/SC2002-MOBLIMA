package control;

import boundary.MovieView;

/**
 * This class controls the display of the movies and their details and reviews.
 */
public class DisplayMovieControl implements MainControl {
    /**
     * Shows if user is Customer or Staff
     */
    private boolean isCustomer;
    /**
     * This constructor creates a new {@code MovieControl} object for the customer or staff
     * 
     * @param isCustomer the customer or staff that wants to view the movie details
     */
    public DisplayMovieControl(boolean isCustomer) {
        this.isCustomer = isCustomer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void begin() {
        MovieView.getAllMoviesView(isCustomer);
        NavigateControl.popOne();
    }
}
