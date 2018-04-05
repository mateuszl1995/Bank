import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BankProductAccountTest {
    BankProductAccount account;
    Interest interest;
    Client client;

    @Test
    public void testConstructor() {
        interest = new InterestZero();
        account = new BankProductAccount(103, interest);
        assertNotNull(account);
    }


}
