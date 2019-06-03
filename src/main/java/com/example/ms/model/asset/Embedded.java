package com.example.ms.model.asset;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Embedded {
	private List<Assets> assets;

	public List<Assets> getAssets() {
		return assets;
	}

	@JsonDeserialize(contentAs = Assets.class)
	public void setAssets(List<Assets> assets) {
		this.assets = assets;
	}

	@Override
	public String toString() {
		return "ClassPojo [assets = " + assets + "]";
	}
}
