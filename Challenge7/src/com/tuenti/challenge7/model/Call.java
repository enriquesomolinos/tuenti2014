package com.tuenti.challenge7.model;


/**
 * The Class Call.
 */
public class Call {

	/** The phone1. */
	private Long phone1;
	
	/** The phone2. */
	private Long phone2;

	/** The call id. */
	private Long callId;
	
	
	/**
	 * Instantiates a new call.
	 *
	 * @param phone1 the phone1
	 * @param phone2 the phone2
	 * @param callId the call id
	 */
	public Call(Long phone1, Long phone2, Long callId) {
		super();
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.callId = callId;
	}

	/**
	 * Gets the phone1.
	 *
	 * @return the phone1
	 */
	public Long getPhone1() {
		return phone1;
	}

	/**
	 * Sets the phone1.
	 *
	 * @param phone1 the new phone1
	 */
	public void setPhone1(Long phone1) {
		this.phone1 = phone1;
	}

	/**
	 * Gets the phone2.
	 *
	 * @return the phone2
	 */
	public Long getPhone2() {
		return phone2;
	}

	/**
	 * Sets the phone2.
	 *
	 * @param phone2 the new phone2
	 */
	public void setPhone2(Long phone2) {
		this.phone2 = phone2;
	}

	/**
	 * Gets the call id.
	 *
	 * @return the call id
	 */
	public Long getCallId() {
		return callId;
	}

	/**
	 * Sets the call id.
	 *
	 * @param callId the new call id
	 */
	public void setCallId(Long callId) {
		this.callId = callId;
	}

	/**
	 * Contains.
	 *
	 * @param phoneId the phone id
	 * @return true, if successful
	 */
	public boolean contains(Long phoneId){
		if(phone1.equals(phoneId) || phone2.equals(phoneId)){
			return true;
		}
		return false;
	}

	
}
