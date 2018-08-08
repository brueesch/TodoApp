package ch.brueesch.todoapp.todoapp.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ch.brueesch.todoapp.todoapp.util.Priority;

public class Entry {

	private String description;
	private Priority priority;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate date;

	public String getDescription() {
		return description;
	}

	public Entry setDescription(String description) {
		this.description = description;
		return this;
	}

	public Priority getPriority() {
		return priority;
	}

	public Entry setPriority(Priority priority) {
		this.priority = priority;
		return this;
	}

	public LocalDate getDate() {
		return date;
	}

	public Entry setDate(LocalDate date) {
		this.date = date;
		return this;
	}

	@JsonIgnore
	public boolean isTodayOrBefore() {
		LocalDate today = LocalDate.now();
		return date.isBefore(today) || date.isEqual(today);
	}
}
