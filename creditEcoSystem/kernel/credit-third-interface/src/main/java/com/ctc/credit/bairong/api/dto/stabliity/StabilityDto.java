package com.ctc.credit.bairong.api.dto.stabliity;
/**
 * 百融:稳定性评估dto
 * @author danggang
 *
 */
public class StabilityDto {

	/** 流水账单**/
	private String swiftNumber;
	
	/** 百融该key值数量**/
	private IdDto id;
	
	private CellDto cell;
	
	/** 百融该key值数量**/
	private MailDto mail;
	
	/** 百融该key值数量**/
	private NameDto name;
	
	/** 百融该key值数量**/
	private TelDto tel;
	
	/** 百融该key值数量**/
	private AddrDto addr;

	public String getSwiftNumber() {
		return swiftNumber;
	}

	public void setSwiftNumber(String swiftNumber) {
		this.swiftNumber = swiftNumber;
	}

	public IdDto getId() {
		return id;
	}

	public void setId(IdDto id) {
		this.id = id;
	}

	public CellDto getCell() {
		return cell;
	}

	public void setCell(CellDto cell) {
		this.cell = cell;
	}

	public MailDto getMail() {
		return mail;
	}

	public void setMail(MailDto mail) {
		this.mail = mail;
	}

	public NameDto getName() {
		return name;
	}

	public void setName(NameDto name) {
		this.name = name;
	}

	public TelDto getTel() {
		return tel;
	}

	public void setTel(TelDto tel) {
		this.tel = tel;
	}

	public AddrDto getAddr() {
		return addr;
	}

	public void setAddr(AddrDto addr) {
		this.addr = addr;
	}

	
}
