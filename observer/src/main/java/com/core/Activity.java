package com.core;

import java.util.HashSet;

public class Activity {

	private int id;
	private String description;
	private HashSet<Audio> audioGallery;
	
	public Activity() {
		this.id = 0;
		this.description = "";
	}
	
	public Activity(int id) {
		this.id = id;
		this.description = "";
	}
	
	public Activity(int id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
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
		Activity other = (Activity) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public void setAudioGallery(HashSet<Audio> audioGallery) {
		this.audioGallery = audioGallery;
	}

	public HashSet<Audio> getAudioGallery() {
		return audioGallery;
	}

}
