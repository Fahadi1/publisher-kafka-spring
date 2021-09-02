package fr.eql.al35.wsrest.kafka.commandsmonitoring.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String reference;
	private LocalDateTime refCreationDate;
	private LocalDateTime refDeletionDate;
	private String description;
	private Double price;
	private Integer quantity; // stock
	private Pattern pattern;
	private ProductType productType; // pas de changement
	private Dimension dimension;
	private List<Photo> photos;

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", reference=" + reference + ", refCreationDate="
				+ refCreationDate + ", refDeletionDate=" + refDeletionDate + ", description=" + description + ", price="
				+ price + ", quantity=" + quantity + ", pattern=" + pattern + ", productType="
				+ productType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pattern == null) ? 0 : pattern.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((refCreationDate == null) ? 0 : refCreationDate.hashCode());
		result = prime * result + ((refDeletionDate == null) ? 0 : refDeletionDate.hashCode());
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
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
		Product other = (Product) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pattern == null) {
			if (other.pattern != null)
				return false;
		} else if (!pattern.equals(other.pattern))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (productType == null) {
			if (other.productType != null)
				return false;
		} else if (!productType.equals(other.productType))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (refCreationDate == null) {
			if (other.refCreationDate != null)
				return false;
		} else if (!refCreationDate.equals(other.refCreationDate))
			return false;
		if (refDeletionDate == null) {
			if (other.refDeletionDate != null)
				return false;
		} else if (!refDeletionDate.equals(other.refDeletionDate))
			return false;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		return true;
	}



}
