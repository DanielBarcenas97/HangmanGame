package com.example.hangmangame.data.model;

import com.google.gson.annotations.SerializedName;

public class ResponseHangman{

	@SerializedName("category")
	private String category;

	@SerializedName("word")
	private String word;

	public String getCategory(){
		return category;
	}

	public String getWord(){
		return word;
	}
}