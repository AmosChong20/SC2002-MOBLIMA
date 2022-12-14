package entity;
/**
 * This enumeration shows the different seat types
 */
public enum SeatType implements ItemName {
    /**
     * The seat type is normal
     */
    NORMAL("Normal"),
    /**
     * The seat type is wheelchair
     */
    WHEELCHAIR("Wheelchair"),
    /**
     * The seat type is couple
     */
    COUPLE("Couple");

    /**
     * The name of the seat type
     */
    private String name;

    /**
     * This constructor creates a {@code SeatType} object with the given label
     * 
     * @param name the seat type
     */
    private SeatType(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String nameToString() {
        return this.name;
    }
}
