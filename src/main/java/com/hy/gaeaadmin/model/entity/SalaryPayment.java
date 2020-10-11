/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hy.gaeaadmin.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ndry93
 */
@Entity
@Table(name = "salary_payment")
@NamedQueries({
    @NamedQuery(name = "SalaryPayment.findAll", query = "SELECT s FROM SalaryPayment s")})
public class SalaryPayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "salary_pay_id")
    private Integer salaryPayId;
    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    @Column(name = "payment_amt")
    private Long paymentAmt;
    @Size(max = 200)
    @Column(name = "description")
    private String description;
    @Size(max = 100)
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Size(max = 100)
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "updated_date")
    private Integer updatedDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enable")
    private int enable;
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    @ManyToOne(optional = false)
    private Employee employee;

    public SalaryPayment() {
    }

    public SalaryPayment(Integer salaryPayId) {
        this.salaryPayId = salaryPayId;
    }

    public SalaryPayment(Integer salaryPayId, int enable) {
        this.salaryPayId = salaryPayId;
        this.enable = enable;
    }

    public Integer getSalaryPayId() {
        return salaryPayId;
    }

    public void setSalaryPayId(Integer salaryPayId) {
        this.salaryPayId = salaryPayId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Long getPaymentAmt() {
        return paymentAmt;
    }

    public void setPaymentAmt(Long paymentAmt) {
        this.paymentAmt = paymentAmt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Integer updatedDate) {
        this.updatedDate = updatedDate;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salaryPayId != null ? salaryPayId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalaryPayment)) {
            return false;
        }
        SalaryPayment other = (SalaryPayment) object;
        if ((this.salaryPayId == null && other.salaryPayId != null) || (this.salaryPayId != null && !this.salaryPayId.equals(other.salaryPayId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hy.gaeaadmin.model.entity.SalaryPayment[ salaryPayId=" + salaryPayId + " ]";
    }
    
}
