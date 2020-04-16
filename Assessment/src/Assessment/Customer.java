package Assessment;

import java.util.Date;

public class Customer {

	 private int cusid;
	 private String cusname;
	 private String email;
	 private String mobile;
	 private Date dob;
	 private Address address;
	public int getCusid() {
		return cusid;
	}
	public void setCusid(int cusid) {
		this.cusid = cusid;
	}
	public String getCusname() {
		return cusname;
	}
	public void setCusname(String cusname) {
		this.cusname = cusname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Customer(int cusid, String cusname, String email, String mobile, Date date, Address address) {
		super();
		this.cusid = cusid;
		this.cusname = cusname;
		this.email = email;
		this.mobile = mobile;
		this.dob = dob;
		this.address = address;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [cusid=" + cusid + ", cusname=" + cusname + ", email=" + email + ", mobile=" + mobile
				+ ", dob=" + dob + ", address=" + address + "]";
	}
	 
}
