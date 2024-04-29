package test;

import main.Account;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
    Account account;

    @Before
    public void setup() {
        account = new Account(100000);
    }
    @Test
    public void testAccount() throws Exception {
        if(account==null){
            throw new Exception("계좌생성 실패");
        }
    }

    @Test
    public void testGetBalance() throws Exception{
        if(account.getBalance() != 100000){
            fail("getBalance() => " + account.getBalance());
        }
        account = new Account(10000);

        account = new Account(0);
        assertEquals("0원으로 계좌 생성 후 잔고 조회", 0, account.getBalance());
    }

    @Test
    public void testDeposit() throws Exception{
        account = new Account(10000);
        account.deposit(1000);
        assertEquals(11000,account.getBalance());
    }
    @Test
    public void testWithdraw() throws Exception{
        account = new Account(10000);
        account.withdraw(1000);
        assertEquals(9000, account.getBalance());
    }


}
