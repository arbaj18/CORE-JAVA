package custom_exception;

@SuppressWarnings("serial")
public class PublisherException extends Exception {
	public PublisherException(String errMsg) {
		super(errMsg);
	}
}
