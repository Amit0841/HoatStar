package com.masai.Dto;

import java.util.Objects;

import jakarta.validation.constraints.NotBlank;

public class Content implements Comparable {
	
	private int contentId;
	@NotBlank
	private String title;
	@NotBlank
	private String description;
	@NotBlank
	private String category;
	@NotBlank
	private String duration;
	
	public Content() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Content(int contentId, @NotBlank String title, @NotBlank String description, @NotBlank String category,
			@NotBlank String duration) {
		super();
		this.contentId = contentId;
		this.title = title;
		this.description = description;
		this.category = category;
		this.duration = duration;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Content [contentId=" + contentId + ", title=" + title + ", description=" + description + ", category="
				+ category + ", duration=" + duration + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, contentId, description, duration, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Content other = (Content) obj;
		return Objects.equals(category, other.category) && contentId == other.contentId
				&& Objects.equals(description, other.description) && Objects.equals(duration, other.duration)
				&& Objects.equals(title, other.title);
	}

	@Override
	public int compareTo(Object o) {
		
		return 1;
	}
	
}
