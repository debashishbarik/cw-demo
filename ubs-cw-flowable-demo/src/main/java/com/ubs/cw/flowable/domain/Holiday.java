package com.ubs.cw.flowable.domain;

/**
 * The Class Holiday Entity.
 *
 * @author debashish.barik
 */
public class Holiday {

	/** The id. */
	private String id;

	/** The employee. */
	private String employee;

	/** The nr of holidays. */
	private String nrOfHolidays;

	/** The description. */
	private String description;

	/**
	 * Instantiates a new holiday.
	 */
	public Holiday() {
		// Empty constructor needed for JPA
	}

	/**
	 * Instantiates a new holiday.
	 *
	 * @param employee     the employee
	 * @param nrOfHolidays the nr of holidays
	 * @param description  the description
	 */
	public Holiday(final String employee, final String nrOfHolidays, final String description) {
		super();
		this.employee = employee;
		this.nrOfHolidays = nrOfHolidays;
		this.description = description;
	}

	/**
	 * Instantiates a new holiday.
	 *
	 * @param id           the id
	 * @param employee     the employee
	 * @param nrOfHolidays the nr of holidays
	 * @param description  the description
	 */
	public Holiday(final String id, final String employee, final String nrOfHolidays, final String description) {
		super();
		this.id = id;
		this.employee = employee;
		this.nrOfHolidays = nrOfHolidays;
		this.description = description;
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
	 * Gets the employee.
	 *
	 * @return the employee
	 */
	public String getEmployee() {
		return employee;
	}

	/**
	 * Sets the employee.
	 *
	 * @param employee the new employee
	 */
	public void setEmployee(final String employee) {
		this.employee = employee;
	}

	/**
	 * Gets the nr of holidays.
	 *
	 * @return the nr of holidays
	 */
	public String getNrOfHolidays() {
		return nrOfHolidays;
	}

	/**
	 * Sets the nr of holidays.
	 *
	 * @param nrOfHolidays the new nr of holidays
	 */
	public void setNrOfHolidays(final String nrOfHolidays) {
		this.nrOfHolidays = nrOfHolidays;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(final String description) {
		this.description = description;
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
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nrOfHolidays == null) ? 0 : nrOfHolidays.hashCode());
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
		final Holiday other = (Holiday) obj;
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (employee == null) {
			if (other.employee != null) {
				return false;
			}
		} else if (!employee.equals(other.employee)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (nrOfHolidays == null) {
			if (other.nrOfHolidays != null) {
				return false;
			}
		} else if (!nrOfHolidays.equals(other.nrOfHolidays)) {
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
		return "Holiday [id=" + id + ", employee=" + employee + ", nrOfHolidays=" + nrOfHolidays + ", description="
				+ description + "]";
	}

}
