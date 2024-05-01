package TCPWork.Operations;

public class RemoveCardOperation extends TCPWork.Operations.CardOperation {
    private String serialNumber;

    public RemoveCardOperation(){}

    public RemoveCardOperation (String serialNumber){
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber(){
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber){
        this.serialNumber = serialNumber;
    }
}
