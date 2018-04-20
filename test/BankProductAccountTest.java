import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class BankProductAccountTest {
    BankProductAccount account;
    Interest interest;
    Client client;

    @Test
    public void testFirstForExcerciseJunitAndMockito() {
        interest = mock(InterestZero.class);
        account = new BankProductAccount(103, interest);
        when(interest.calculateInterest(account)).thenReturn(30.0f);


        assertNotNull(account);
        assertEquals(2, 2);
        // assertTrue(2 > 2);
        float x = interest.calculateInterest(account);
        assertEquals(x, 29.0f);
    }


}
