package com.tradewave.business;

import java.util.Objects;

public class Instrument {
    @Override
	public String toString() {
		return "Instrument [instrumentId=" + instrumentId + ", description=" + description + ", externalIdType="
				+ externalIdType + ", externalId=" + externalId + ", categoryId=" + categoryId + ", minQuantity="
				+ minQuantity + ", maxQuantity=" + maxQuantity + ", hashCode()=" + hashCode() + ", getInstrumentId()="
				+ getInstrumentId() + ", getDescription()=" + getDescription() + ", getExternalIdType()="
				+ getExternalIdType() + ", getExternalId()=" + getExternalId() + ", getCategoryId()=" + getCategoryId()
				+ ", getMinQuantity()=" + getMinQuantity() + ", getMaxQuantity()=" + getMaxQuantity() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoryId, description, externalId, externalIdType, instrumentId, maxQuantity,
				minQuantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instrument other = (Instrument) obj;
		return Objects.equals(categoryId, other.categoryId) && Objects.equals(description, other.description)
				&& Objects.equals(externalId, other.externalId) && Objects.equals(externalIdType, other.externalIdType)
				&& Objects.equals(instrumentId, other.instrumentId)
				&& Double.doubleToLongBits(maxQuantity) == Double.doubleToLongBits(other.maxQuantity)
				&& Double.doubleToLongBits(minQuantity) == Double.doubleToLongBits(other.minQuantity);
	}

	private String instrumentId;
    private String description;
    private String externalIdType;
    private String externalId;
    private String categoryId;
    private double minQuantity;
    private double maxQuantity;
    
    public Instrument() {}
    
    public Instrument(String instrumentId, String description, String externalIdType, String externalId, String categoryId, double minQuantity, double maxQuantity) {
        this.instrumentId = instrumentId;
        this.description = description;
        this.externalIdType = externalIdType;
        this.externalId = externalId;
        this.categoryId = categoryId;
        this.minQuantity = minQuantity;
        this.maxQuantity = maxQuantity;
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public String getDescription() {
        return description;
    }

    public String getExternalIdType() {
        return externalIdType;
    }

    public String getExternalId() {
        return externalId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public double getMinQuantity() {
        return minQuantity;
    }

    public double getMaxQuantity() {
        return maxQuantity;
    }
}

