import java.io.Serializable;

public class DataValueObject implements Serializable{
    private static final long serialVersionUID = 1L;
    private String customer;
    private String business;
    transient  private String contractID;
    transient  private String passKeys;

    public String getCustomer() {
        return customer;
    }
    public void setCustomer( String customer){
        this.customer = customer;
    }
    public String getBusiness() {
        return business;
    }
    public void setBusiness( String business){
        this.business = business;
    }
    public String getContractID() {
        return contractID;
    }
    public void setContractID( String contractID){
        this.contractID = contractID;
    }
    public String getPassKeys() {
        return passKeys;
    }
    public void setPassKeys (String passKeys){
        this.passKeys = passKeys;
    }

    public String toString() {
        String value = "customer :" + customer + "\nbusiness : " + business + "\ncontractID : " + contractID + "\npassKeys :" + passKeys;
        return value;
    }
}
