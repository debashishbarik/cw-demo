package com.ubs.wcat.ms.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class EmployeeReport {
    private String id;                                
    private String line3;
    private String line4;
    private String name;
    private String role;
    private String address;
    private String desc;
    private BigDecimal amountUSD;

    public EmployeeReport() {
    }
    public boolean checkL3Similarity(EmployeeReport employeeReport) {
        return StringUtils.equals(this.getId(),employeeReport.getId()) &&
                StringUtils.equals(this.getName(),employeeReport.getName()) &&
                StringUtils.equals(this.getRole(),employeeReport.getRole()) &&
                StringUtils.equals(this.getAddress(),employeeReport.getAddress()) &&
                StringUtils.equals(this.getDesc(),employeeReport.getDesc()) &&
                StringUtils.equals(this.getLine3(),employeeReport.getLine3())&&
                StringUtils.isBlank(this.getLine4()) && StringUtils.isBlank(employeeReport.getLine4());
    }
    public boolean checkL4Similarity(EmployeeReport employeeReport) {
        return StringUtils.equals(this.getId(),employeeReport.getId()) &&
                StringUtils.equals(this.getName(),employeeReport.getName()) &&
                StringUtils.equals(this.getRole(),employeeReport.getRole()) &&
                StringUtils.equals(this.getAddress(),employeeReport.getAddress()) &&
                StringUtils.equals(this.getDesc(),employeeReport.getDesc()) &&
                StringUtils.equals(this.getLine3(),employeeReport.getLine3())&&
                StringUtils.equals(this.getLine4(),employeeReport.getLine4());
    }

}
