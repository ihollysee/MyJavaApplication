package org.test.concurrentTEST;

public class Contact  {
	private int id;
	private String name;
	private String phone;
	private String detail;
	private String sex;
	private boolean load = false;
	private boolean b;
	

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public boolean isLoad() {
		return load;
	}

	public void setLoad(boolean load) {
		this.load = load;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

public static void main(String[] args) {
	Contact c=new Contact();
	System.out.println(c.b);
}
}
