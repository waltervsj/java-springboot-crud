package com.walter.workshop.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.walter.workshop.entities.enums.DemandStatus;

@Entity
public class Demand implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment;
	private Integer demandStatus;
	
	@OneToOne(mappedBy = "demand", cascade = CascadeType.ALL)
	private Payment payment;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "id.demand")
	private Set<DemandItem> items = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public DemandStatus getDemandStatus() {
		return DemandStatus.valueOf(demandStatus);
	}

	public void setDemandStatus(DemandStatus demandStatus) {
		if (demandStatus != null)
			this.demandStatus = demandStatus.getCode();
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<DemandItem> getDemandItems() {
		return items;
	}

	public Demand() {
	}

	public Demand(Long id, Instant moment, DemandStatus demandStatus, User user) {
		this.id = id;
		this.moment = moment;
		this.setDemandStatus(demandStatus);
		this.user = user;
	}
	
	public Double getTotal() {
		Double total = 0.0;
		for(DemandItem item : this.getDemandItems()) {
			total += item.getSubTotal();
		}
		return total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Demand other = (Demand) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", moment=" + moment + ", user=" + "]";
	}

}
