package Entities;

import java.util.Objects;

public class BlockAccount {
    private String login;
    private String password;
    private String twoFA;

    public BlockAccount(String login, String password, String twoFA){
        this.login = login;
        this.password = password;
        this.twoFA = twoFA;
    }
    public BlockAccount(){
        this("", "", "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlockAccount that = (BlockAccount) o;
        return getLogin().equals(that.getLogin()) && getPassword().equals(that.getPassword()) && getTwoFA().equals(that.getTwoFA());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getTwoFA());
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String loginInput) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String passwordInput) {
        this.password = password;
    }
    public String getTwoFA() {
        return twoFA;
    }
    public void setTwoFA(String twoFAInput) {
        this.twoFA = twoFA;
    }
}
