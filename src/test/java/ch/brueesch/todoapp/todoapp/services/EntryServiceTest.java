package ch.brueesch.todoapp.todoapp.services;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ch.brueesch.todoapp.todoapp.model.Entry;
import ch.brueesch.todoapp.todoapp.util.Priority;

public class EntryServiceTest {

	@Test
	public void addEntryTest() {
		EntryService entryService = new EntryService();
		Entry entry = new Entry().setDescription("Test").setPriority(Priority.HIGH);
		entryService.addEntry(entry);
		ArrayList<Entry> entries =  entryService.getAllEntries();
		assertEquals(1, entries.size());
	}

	@Test
	public void getAllEntriesTest() {
		EntryService entryService = new EntryService();
		entryService.addEntry(new Entry().setDescription("Test1").setPriority(Priority.HIGH));
		entryService.addEntry(new Entry().setDescription("Test2").setPriority(Priority.LOW));
		entryService.addEntry(new Entry().setDescription("Test3").setPriority(Priority.HIGH));

		ArrayList<Entry> entries = entryService.getAllEntries();

		assertEquals(Priority.HIGH, entries.get(0).getPriority());
		assertEquals(Priority.HIGH, entries.get(1).getPriority());
		assertEquals(Priority.LOW, entries.get(2).getPriority());

	}
}