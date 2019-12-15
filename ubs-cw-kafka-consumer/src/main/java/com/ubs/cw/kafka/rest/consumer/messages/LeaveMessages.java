package com.ubs.cw.kafka.rest.consumer.messages;

import java.io.Serializable;

/**
 * The Class LeaveMessages.
 *
 * @author debashish.barik
 */
public class LeaveMessages implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** The message. */
	private final String message;

	/** The identifier. */
	private final int identifier;

	/**
	 * Instantiates a new leave messages.
	 *
	 * @param message    the message
	 * @param identifier the identifier
	 */
	public LeaveMessages(final String message, final int identifier) {
		super();
		this.message = message;
		this.identifier = identifier;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Gets the identifier.
	 *
	 * @return the identifier
	 */
	public int getIdentifier() {
		return identifier;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "LeaveMessages [message=" + message + ", identifier=" + identifier + "]";
	}

}
