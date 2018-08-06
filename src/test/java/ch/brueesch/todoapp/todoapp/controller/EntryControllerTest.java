package ch.brueesch.todoapp.todoapp.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import ch.brueesch.todoapp.todoapp.model.Entry;
import ch.brueesch.todoapp.todoapp.services.EntryService;
import ch.brueesch.todoapp.todoapp.util.Priority;

public class EntryControllerTest {

	private EntryService entryService;
	private EntryController entryController;

	@Before
	public void setUp() {
		entryService = new EntryService();
		entryController = new EntryController(entryService);
	}

	@Test
	public void addEntryTest() {
		Entry entry = new Entry().setDescription("Test Entry").setPriority(Priority.HIGH);
		ResponseEntity<String> result = entryController.addEntry(entry);
		assertEquals(ResponseEntity.ok("Everything is okay!"), result);
		assertEquals(1, entryService.getAllEntries().size());
	}

	@Test
	public void getAllEntriesTest() {
		ResponseEntity<ArrayList<Entry>> entries =  entryController.getAllEntries();
		assertNotNull(entries.getBody());
	}

}