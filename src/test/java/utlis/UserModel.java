package utlis;

public class UserModel {
    private String email;
    private String password;
    private String name;
    private String phone_number;
    private String nid;
    private String role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void UserModel(String email, String password){
        this.email= email;
        this.password = password;
    }
    public void UserModel(String name, String email, String password, String phone_number, String nid, String role){
        this.name=name;
        this.email=email;
        this.password=password;
        this.phone_number=phone_number;
        this.nid=nid;
        this.role=role;
    }
    private String form_account;
    private  String to_account;
    private String amount;

    public String getForm_account() {
        return form_account;
    }

    public void setForm_account(String form_account) {
        this.form_account = form_account;
    }

    public String getTo_account() {
        return to_account;
    }

    public void setTo_account(String to_account) {
        this.to_account = to_account;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void userModel(String form_account, String to_account, String amount){
        this.form_account = form_account;
        this.to_account = to_account;
        this.amount = amount;
    }

    public void UserModel(){

    }

}
