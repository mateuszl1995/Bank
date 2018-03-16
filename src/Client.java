public class Client {
    static int idSequence = 0;
    static int getIdSequence() {
        int id = idSequence;
        idSequence++;
        return id;
    }

    private int id;
    private String firstName;
    private String lastName;
    Client(String firstName, String lastName) {
        this.id = getIdSequence();
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public int getId() {
        return this.id;
    }
}
