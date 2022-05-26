package javaOPP;

public class Topic_06_Getter_Setter {
	private String personName;
	private int personAge;
	private int personPhone;
	private float personBankAccountAmount;

	public void setPersonName(String personName) {
		if (personName == null || personName.isBlank() || personName.isEmpty()) {
			throw new IllegalArgumentException("Nhập tên không hợp lệ");
		} else {
			this.personName = personName;
		}
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonAge(int personAge) {
		if (personAge < 18 && personAge > 200) {
			throw new IllegalArgumentException("Nhập tuổi không hợp lệ");
		} else {
			this.personAge = personAge;
		}

	}
	public int getPersonAge() {
		return personAge;

	}

	public int getPersonPhone() {
		return personPhone;
	}

	public void setPersonPhone(int personPhone) {
		if(!String.valueOf(personPhone).startsWith("0")) {
			throw new IllegalArgumentException("Số điện thoại bắt đầu bằng : 09 - 03 - 013");
		}else if(personPhone < 10 || personPhone > 11) {
			throw new IllegalArgumentException("Số điện thoại  phải từ 10-11 số");
			
		}
		this.personPhone = personPhone;
	}

	public float getPersonBankAccountAmount() {
		return personBankAccountAmount;
	}

	public void setPersonBankAccountAmount(float personBankAccountAmount) {
		this.personBankAccountAmount = personBankAccountAmount;
	}
	
}
