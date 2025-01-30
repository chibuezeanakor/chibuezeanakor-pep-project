package Service;

import Model.Account;
import DAO.AccountDAO;;

public class AccountService {
    AccountDAO accountDAO;

    public AccountService(){
        accountDAO = new AccountDAO();
    }

    public AccountService(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    public Account addAccount(Account account){
        try {
            return this.accountDAO.registerAccount(account);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Account accountLogin(String username, String password){
        try {
            return this.accountDAO.accountLogin(username, password);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean isExistingUsername(String username) {
        try {
            return this.accountDAO.isExistingUsername(username);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean doesAccountExist(int id) {
        try {
            return this.accountDAO.doesAccountExist(id);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
