package learn.foraging.models;

/**A person who searches for and harvests wild plants and fungi. Sustainable Foraging tracks a forager's first name,
    last name, and state.
 *
 */
public class Forager {

    private String id;
    private String firstName;
    private String lastName;
    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {this.id = id;}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
