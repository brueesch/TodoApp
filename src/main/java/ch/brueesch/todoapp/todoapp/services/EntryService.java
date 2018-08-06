package ch.brueesch.todoapp.todoapp.services;

import java.util.ArrayList;
import java.util.Comparator;

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
		return entries;
	}
}
