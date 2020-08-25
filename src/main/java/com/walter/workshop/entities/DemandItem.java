package com.walter.workshop.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walter.workshop.entities.pk.DemandItemPK;

@Entity
public class DemandItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DemandItemPK id;
	private Integer quantity;
	private Double price;

	@JsonIgnore
	public Demand getDemand() {
		return id.getDemand();
	}

	public void setDemand(Demand demand) {
		this.id.setDemand(demand);
	}

	public Product getProduct() {
		return id.getProduct();
	}

	public void setProduct(Product product) {
		this.id.setProduct(product);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public DemandItem() {
	}

	public DemandItem(Demand demand, Product product, Integer quantity, Double price) {
		this.id = new DemandItemPK();
		this.id.setDemand(demand);
		this.id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}
	
	public Double getSubTotal() {
		return price * quantity;
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
		DemandItem other = (DemandItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
