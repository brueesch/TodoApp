package ch.brueesch.todoapp.todoapp.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import ch.brueesch.todoapp.todoapp.model.Entry;

@Component
public class EntryService {

	private ArrayList<Entry> entries = new ArrayList<>();

	public void addEntry(Entry entry) {
		entries.add(entry);
	}

	public ArrayList<Entry> getAllEntries() {
		entries.sort(Comparator.comparing(Entry::getPriority));
		entries.sort(Comparator.comparing(Entry::getDate));
		return entries;
	}

	public void setNewDate(int index, LocalDate date) {
		entries.get(index).setDate(date);
	}

	public void removeEntry(int i) {
		entries.remove(i);
	}
}
