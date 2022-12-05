package Entities;

public abstract class BlockAdminAccount extends BlockAccount{
    private boolean admin;

    public BlockAdminAccount(String login, String password, String twoFA, boolean admin){
        super(login, password, twoFA);
        this.admin = admin;
    }
    public BlockAdminAccount(){
        super("", "", "");
        this.admin = false;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
