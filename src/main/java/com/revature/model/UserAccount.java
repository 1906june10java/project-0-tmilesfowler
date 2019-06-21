package com.revature.model;

public class UserAccount implements Comparable{

	long idNum = 1;
	String userName = "revature";
	String passWord = "p4ssw0rd";
	long balance;
	
	public UserAccount(long idNum, String userName, String passWord, long balance) {
		super();
		this.idNum = idNum;
		this.userName = userName;
		this.passWord = passWord;
		this.balance = balance;
	}

	public long getIdNum() {
		return idNum;
	}



	public void setIdNum(long idNum) {
		this.idNum = idNum;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassWord() {
		return passWord;
	}



	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}



	public long getBalance() {
		return balance;
	}



	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (balance ^ (balance >>> 32));
		result = prime * result + (int) (idNum ^ (idNum >>> 32));
		result = prime * result + ((passWord == null) ? 0 : passWord.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		UserAccount other = (UserAccount) obj;
		if (balance != other.balance)
			return false;
		if (idNum != other.idNum)
			return false;
		if (passWord == null) {
			if (other.passWord != null)
				return false;
		} else if (!passWord.equals(other.passWord))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserAccount [idNum=" + idNum + ", userName=" + userName + ", passWord=" + passWord + ", balance="
				+ balance + "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
