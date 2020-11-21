package com.example.postbook;

public class Status {

	private boolean resultStatus;

	public Status() {
	}

	public Status(boolean resultStatus) {
		this.resultStatus = resultStatus;
	}

	public boolean isResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(boolean resultStatus) {
		this.resultStatus = resultStatus;
	}

	@Override
	public String toString() {
		return "Status [resultStatus=" + resultStatus + "]";
	}

}