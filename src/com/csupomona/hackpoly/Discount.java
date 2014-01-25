package com.csupomona.hackpoly;

public class Discount {
	private int upvotes;
	private int downvotes;
	private String establishment;
	private String[] address;
	private String description;
	
	public Discount(int up, int down, String est, String[] address, String desc){
		upvotes = up;
		downvotes = down;
		establishment = est;
		for (int i = 0; i < address.length; i++){
			this.address[i] = address[i];
		}
		description = desc;
	}
	
	public int getUpvotes() { return upvotes; }
	public int getDownvotes() { return downvotes; }
	public String getEstablishment() { return establishment; }
	public String getDescription() { return description; }
	public int getAddressLineCount() { return address.length; }
	public String getAddressLine(int l) { return address[l]; }
	

}
