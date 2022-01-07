package stream;

import java.io.Serializable;

public class Address implements Serializable {

	private String mobile;
	private String address;
	
	public Address() {
		super();
	}

	public Address(String mobile, String address) {
		super();
		this.mobile = mobile;
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
