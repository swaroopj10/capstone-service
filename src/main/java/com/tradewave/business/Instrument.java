package com.tradewave.business;

import java.util.Objects;

public class Instrument {
   
	private String instrumentId;
    private String instrumentDescription;
    private String externalIdType;
    private String externalId;
    private String categoryId;
    private double minQuantity;
    private double maxQuantity;
    
    public Instrument() {}
    
    public Instrument(String instrumentId, String instrumentDescription, String externalIdType, String externalId, String categoryId, double minQuantity, double maxQuantity) {
        this.instrumentId = instrumentId;
        this.instrumentDescription = instrumentDescription;
        this.externalIdType = externalIdType;
        this.externalId = externalId;
        this.categoryId = categoryId;
        this.minQuantity = minQuantity;
        this.maxQuantity = maxQuantity;
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public String getInstrumentDescription() {
        return instrumentDescription;
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

	@Override
	public int hashCode() {
		return Objects.hash(categoryId, externalId, externalIdType, instrumentDescription, instrumentId, maxQuantity,
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
		return Objects.equals(categoryId, other.categoryId) && Objects.equals(externalId, other.externalId)
				&& Objects.equals(externalIdType, other.externalIdType)
				&& Objects.equals(instrumentDescription, other.instrumentDescription)
				&& Objects.equals(instrumentId, other.instrumentId)
				&& Double.doubleToLongBits(maxQuantity) == Double.doubleToLongBits(other.maxQuantity)
				&& Double.doubleToLongBits(minQuantity) == Double.doubleToLongBits(other.minQuantity);
	}

	@Override
	public String toString() {
		return "Instrument [instrumentId=" + instrumentId + ", instrumentDescription=" + instrumentDescription
				+ ", externalIdType=" + externalIdType + ", externalId=" + externalId + ", categoryId=" + categoryId
				+ ", minQuantity=" + minQuantity + ", maxQuantity=" + maxQuantity + "]";
	}
}

