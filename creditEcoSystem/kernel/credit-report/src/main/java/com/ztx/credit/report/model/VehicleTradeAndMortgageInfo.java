package com.ztx.credit.report.model;

/**
 * 车辆交易和抵押记录
 * 
 * @author xucy
 *
 */
public class VehicleTradeAndMortgageInfo {
	private String serial;
	private String vehicleNo;
	private String engineNo;
	private String brand;
	private String vehicleType;
	private String useAttribute;
	private String status;
	private String isMortgage;
	private String updateTime;

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getUseAttribute() {
		return useAttribute;
	}

	public void setUseAttribute(String useAttribute) {
		this.useAttribute = useAttribute;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsMortgage() {
		return isMortgage;
	}

	public void setIsMortgage(String isMortgage) {
		this.isMortgage = isMortgage;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "VehicleTradeAndMortgageInfo [serial=" + serial + ", vehicleNo="
				+ vehicleNo + ", engineNo=" + engineNo + ", brand=" + brand
				+ ", vehicleType=" + vehicleType + ", useAttribute="
				+ useAttribute + ", status=" + status + ", isMortgage="
				+ isMortgage + ", updateTime=" + updateTime + "]";
	}

}
