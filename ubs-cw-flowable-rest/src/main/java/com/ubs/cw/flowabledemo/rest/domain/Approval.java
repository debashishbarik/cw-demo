package com.ubs.cw.flowabledemo.rest.domain;

/**
 * The Approval Entity.
 *
 * @author debashish.barik
 */
public class Approval {

	/** The id. */
	private String id;

	/** The status. */
	private boolean approved;

	/**
	 * Instantiates a new approval.
	 */
	public Approval() {
		// Empty constructor needed for JPA
	}

	/**
	 * Instantiates a new approval.
	 *
	 * @param status the status
	 */
	public Approval(final boolean status) {
		super();
		this.approved = status;
	}

	/**
	 * Instantiates a new approval.
	 *
	 * @param id     the id
	 * @param status the status
	 */
	public Approval(final String id, final boolean status) {
		super();
		this.id = id;
		this.approved = status;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(final String id) {
		this.id = id;
	}

	/**
	 * Checks if is approved.
	 *
	 * @return true, if is approved
	 */
	public boolean isApproved() {
		return approved;
	}

	/**
	 * Sets the approved.
	 *
	 * @param approved the new approved
	 */
	public void setApproved(final boolean approved) {
		this.approved = approved;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (approved ? 1231 : 1237);
		return result;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Approval other = (Approval) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (approved != other.approved) {
			return false;
		}
		return true;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Approval [id=" + id + ", approved=" + approved + "]";
	}

}
