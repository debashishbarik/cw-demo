package com.debashish.springdrools.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RawData {
	private String reportinDate;
	private String functionId;
	private String legalEntityId;
	private String icFlag;
	private String totalCurrentAmount;
	private String totalVarianceAmount;
	private String percentageOfAmount;
	private String l4Id;
	private String l3Id;
	private String status;

	public enum Status {
		COMPLETE, INCOMPLETE
	}
}
