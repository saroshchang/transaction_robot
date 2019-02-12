package tw.org.ktrade.robot.exception;


import tw.org.ktrade.robot.constant.ResponseErrorCode;

public class ETCException extends Exception {
	
	private static final long serialVersionUID = 4016143147857375621L;
    
    private int errorCode;

    public ETCException(){}
    
    public ETCException(ResponseErrorCode code) {
    	super(code.getCode().toString());
        errorCode = code.getCode();
    }

	public int getErrorCode() {
		return errorCode;
	}

	
}
