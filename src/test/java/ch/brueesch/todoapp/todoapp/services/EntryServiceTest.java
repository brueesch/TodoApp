package ch.brueesch.todoapp.todoapp.services;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.tomcat.jni.Local;
import org.junit.Test;

import ch.brueesch.todoapp.todoapp.model.Entry;
import ch.brueesch.todoapp.todoapp.util.Priority;

public class EntryServiceTest {

	@Test
	public void addEntryTest() {
		EntryService entryService = new EntryService();
		Entry entry = new Entry().setDescription("Test").setPriority(Priority.HIGH);
		entryService.addEntry(entry);
		ArrayList<Entry> entries = entryService.getAllEntries();
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

	@Test
	public void getAllEntriesForTodayTest() {
		EntryService entryService = new EntryService();
		entryService.addEntry(new Entry().setDescription("Test").setPriority(Priority.HIGH).setDate(LocalDate.now()));
		entryService.addEntry(new Entry().setDescription("Test").setPriority(Priority.HIGH).setDate(LocalDate.now().plusDays(2)));
		entryService.addEntry(new Entry().setDescription("Test").setPriority(Priority.HIGH).setDate(LocalDate.now().minusDays(2)));

		ArrayList<Entry> entries = entryService.getAllEntriesForToday();

		assertEquals(2, entries.size());
		assertEquals(LocalDate.now(), entries.get(0).getDate());
		assertEquals(LocalDate.now().minusDays(2), entries.get(1).getDate());

		entries = entryService.getAllEntries();
		assertEquals(3, entries.size());

	}

	@Test
	public void setNewDateTest() {
		EntryService entryService = new EntryService();
		entryService.addEntry(new Entry().setDescription("Test").setPriority(Priority.HIGH).setDate(LocalDate.now()));
		entryService.addEntry(new Entry().setDescription("Test").setPriority(Priority.HIGH).setDate(LocalDate.now().plusDays(2)));

		entryService.setNewDate(1, LocalDate.now().plusDays(3));
		ArrayList<Entry> entries = entryService.getAllEntries();

		assertEquals(2, entries.size());
		assertEquals(LocalDate.now(), entries.get(0).getDate());
		assertEquals(LocalDate.now().plusDays(3), entries.get(1).getDate());

	}

	@Test
	public void deleteEntry() {
		EntryService entryService = new EntryService();
		entryService.addEntry(new Entry().setDescription("Test").setPriority(Priority.HIGH).setDate(LocalDate.now()));

		ArrayList<Entry> allEntries = entryService.getAllEntries();
		assertEquals(1, allEntries.size());

		entryService.removeEntry(0);

		allEntries = entryService.getAllEntries();
		assertEquals(0, allEntries.size());
	}


}