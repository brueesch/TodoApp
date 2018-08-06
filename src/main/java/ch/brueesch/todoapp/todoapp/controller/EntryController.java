package ch.brueesch.todoapp.todoapp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import ch.brueesch.todoapp.todoapp.model.Entry;
import ch.brueesch.todoapp.todoapp.services.EntryService;

@Component
@RequestMapping("/api")
public class EntryController {

	private EntryService entryService;

	@Autowired
	public EntryController(EntryService entryService) {
		this.entryService = entryService;
	}

	@RequestMapping(value="/addEntry", method = RequestMethod.POST)
	public ResponseEntity<String> addEntry(@RequestBody Entry entry) {
		entryService.addEntry(entry);
		return ResponseEntity.ok("Everything is okay!");
	}

	@RequestMapping(value="/getAllEntries", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Entry>> getAllEntries() {
		return ResponseEntity.ok(entryService.getAllEntries());
	}
}
