package boundary;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

import entity.*;

/**
 * This class edits the movie listings
 */
@SuppressWarnings("resource")
public class MovieEditView {
    /**
     * This method displays the add movie view
     */
    public static void addMovie() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the title of the movie: ");
            String title = sc.nextLine();
            for (Movie movie : DatabaseManager.getDataBase().getMovieList()) {
                String movieTitle = movie.getTitle();
                if (title.equals(movieTitle)) {
                    System.out.println("The movie is already existed!");
                    return;
                }
            }
            System.out.println("Enter the synopsis of the movie: ");
            String synopsis = sc.nextLine();
            System.out.println("Enter the director of the movie: ");
            String director = sc.nextLine();

            // change to array list?
            System.out.print("Enter the number of casts: ");
            String[] castNames = new String[sc.nextInt()];
            sc.nextLine();
            for (int i = 0; i < castNames.length; i++) {
                System.out.println("Enter the name of cast " + (i + 1) + ": ");
                castNames[i] = sc.nextLine();
            }

            System.out.println("Enter the duration of the movie in minutes: ");
            int durationMovie = sc.nextInt();
            Duration duration = Duration.ofMinutes(durationMovie);

            // waiting for MenuView to be done
            MovieRating movieRating = MenuView.getItemName("Release rating: ", MovieRating.values());
            MovieType movieType = MenuView.getItemName("Movie type: ", MovieType.values());
            ShowStatus showStatus = MenuView.getItemName("Show status: ", ShowStatus.values());

            Movie movie = new Movie(title, synopsis, director, castNames, showStatus, movieRating, movieType, duration);
            DatabaseManager.getDataBase().getMovieList().add(movie);

        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }

    /**
     * This method displays the remove movie view
     */
    public static void removeMovie() {
        ArrayList<Movie> movieList = DatabaseManager.getDataBase().getMovieList();
        Movie movie = MenuView.getItemName("Select a movie to remove: ", movieList);
        movie.setShowStatus(ShowStatus.END_OF_SHOWING);
    }

    /**
     * This method displays the update movie view
     */
    public static void updateMovie() {
        ArrayList<Movie> movieList = DatabaseManager.getDataBase().getMovieList();
        Movie movie = MenuView.getItemName("Select a movie to update: ", movieList);

        int option = MenuView.getMenuOption(
                "What do you want to update?",
                "Title",
                "Synopsis",
                "Director",
                "Cast",
                "Duration",
                "Movie rating",
                "Movie type",
                "Show status");

        Scanner sc = new Scanner(System.in);

        try {
            switch (option) {
                case 1:
                    System.out.println("Enter the new title: ");
                    movie.setTitle(sc.nextLine());
                    break;
                case 2:
                    System.out.println("Enter the new synopsis: ");
                    movie.setSynopsis(sc.nextLine());
                    break;
                case 3:
                    System.out.println("Enter the new director: ");
                    movie.setDirector(sc.nextLine());
                    break;
                case 4:
                    System.out.println("Enter the number of casts: ");
                    String[] castNames = new String[sc.nextInt()];
                    sc.nextLine();
                    for (int i = 0; i < castNames.length; i++) {
                        System.out.println("Enter the name of cast " + (i + 1) + ": ");
                        castNames[i] = sc.nextLine();
                    }
                    movie.setCast(castNames);
                    break;
                case 5:
                    System.out.println("Enter the new duration in minutes: ");
                    int durationMovie = sc.nextInt();
                    Duration duration = Duration.ofMinutes(durationMovie);
                    movie.setDuration(duration);
                    break;
                case 6:
                    movie.setMovieRating(MenuView.getItemName("Release rating: ", MovieRating.values()));
                    break;
                case 7:
                    movie.setMovieType(MenuView.getItemName("Movie type: ", MovieType.values()));
                    break;
                case 8:
                    movie.setShowStatus(MenuView.getItemName("Show status: ", ShowStatus.values()));
                    break;
            }

        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }
}
