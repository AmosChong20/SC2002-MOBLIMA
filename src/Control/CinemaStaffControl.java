package control;

import entity.CinemaStaff;
import view.CinemaStaffLoginView; // Need to implement
import view.MenuView; // Need to implement

/**
 * Controls the main menu and login for the cinema staff
 */
public class CinemaStaffControl implements MainControl {
    /**
     * Cinema staff that is currently logged in
     */
    private CinemaStaff cinemaStaff;

    /**
     * {@inheritDoc}
     */
    @Override
    public void begin() {
        while (this.cinemaStaff == null) {
            int choice = MenuView.getMenuOption(
                    "Please select an option:",
                    "Login",
                    "Exit"
            );

            switch (choice) {
                case 1:
                    this.cinemaStaff = CinemaStaffLoginView.loginCinemaStaff();
                    break;

                case 2:
                    NavigateControl.popOne();
                    return;
            }
        }

        showMenu();
    }

    /**
     * Controls main menu display for the cinema staff
     */
    private void showMenu() {
        int choice = MenuView.getMenuOption(
                "Please select an option:",
                "List Top 5 Movies",
                "Modify Ticket Pricing Scheme",
                "Modify Movie Listings",
                "Modify Cinema Showtimes",

                "Exit"
        );

        switch (choice) {
            case 1:
                NavigateControl.load(new TopMoviesController());
                break;

            case 2:
                NavigateControl.load(new PricingSchemeEditController());
                break;

            case 3:
                NavigateControl.load(new MovieEditController());
                break;

            case 4:
                NavigateControl.load(new ShowTimeEditController());
                break;

            case 5:
                NavigateControl.popOne();
                break;
        }
    }
}