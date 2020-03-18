package com.debashish.springdrools.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exception {

	private String reportinDate;
	private String functionId;
	private String legalEntityId;
	private String status;

}
