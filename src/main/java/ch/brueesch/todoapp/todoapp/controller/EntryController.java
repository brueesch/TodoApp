package ch.brueesch.todoapp.todoapp.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import ch.brueesch.todoapp.todoapp.model.Entry;
import ch.brueesch.todoapp.todoapp.services.EntryService;
import ch.brueesch.todoapp.todoapp.types.SnoozeEntryType;

@Component
@RequestMapping("/api")
public class EntryController {

	private EntryService entryService;

	@Autowired
	public EntryController(EntryService entryService) {
		this.entryService = entryService;
	}

	@RequestMapping(value = "/addEntry", method = RequestMethod.POST)
	public ResponseEntity<String> addEntry(@RequestBody Entry entry) {
		if (entry.getDate() == null) {
			entry.setDate(LocalDate.now());
		}
		entryService.addEntry(entry);
		return ResponseEntity.ok("Everything is okay!");
	}

	@RequestMapping(value = "/getAllEntries", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Entry>> getAllEntries() {
		return ResponseEntity.ok(entryService.getAllEntries());
	}

	@RequestMapping(value = "/getAllEntriesForToday", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Entry>> getAllEntriesForToday() {
		return ResponseEntity.ok(entryService.getAllEntriesForToday());
	}

	@RequestMapping(value = "/snoozeEntry", method = RequestMethod.POST)
	public ResponseEntity<String> snoozeEntry(@RequestBody SnoozeEntryType snoozeEntryType) {
		entryService.setNewDate(snoozeEntryType.getIndex(), snoozeEntryType.getDate());
		return ResponseEntity.ok("Everything is okay!");
	}

	@RequestMapping(value = "/removeEntry", method = RequestMethod.POST)
	public ResponseEntity<String> removeEntry(@RequestBody int index) {
		entryService.removeEntry(index);
		return ResponseEntity.ok("Everything is okay!");
	}
}
