package com.h2.chuizone.member.model.vo;

public class Member {
	
	private int userNo;
	private String userId;
	private String userPw;
	private String nickName;
	private String email;
	private String address;
	private String phone;
	
	public Member() {

	}

	public Member(int userNo, String userId, String userPw, String nickName, String email, String address,
			String phone) {
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.nickName = nickName;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}
	
	/* 회원가입용 메소드 */
	public Member(String userId, String userPw, String nickName, String email, String address, String phone) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.nickName = nickName;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPw=" + userPw + ", nickName=" + nickName
				+ ", email=" + email + ", address=" + address + ", phone=" + phone + "]";
	}

}
