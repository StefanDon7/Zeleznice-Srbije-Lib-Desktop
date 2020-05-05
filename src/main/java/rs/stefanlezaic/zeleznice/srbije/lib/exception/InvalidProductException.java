package rs.stefanlezaic.zeleznice.srbije.lib.exception;

public class InvalidProductException extends Exception {

    private String customMessage;

    public InvalidProductException(String message) {
        super(message);
    }

    public InvalidProductException(String message, String customMessage) {
        super(message);
        this.customMessage = customMessage;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }

}
