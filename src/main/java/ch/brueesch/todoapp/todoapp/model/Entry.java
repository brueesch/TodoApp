package ch.brueesch.todoapp.todoapp.model;

import ch.brueesch.todoapp.todoapp.util.Priority;

public class Entry {

	private String description;
	private Priority priority;

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
}
