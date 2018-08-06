package ch.brueesch.todoapp.todoapp.types;


import java.time.LocalDate;

public class SnoozeEntryType {

	private int index;
	private LocalDate date;


	public int getIndex() {
		return index;
	}

	public SnoozeEntryType setIndex(int index) {
		this.index = index;
		return this;
	}

	public LocalDate getDate() {
		return date;
	}

	public SnoozeEntryType setDate(LocalDate date) {
		this.date = date;
		return this;
	}
}
