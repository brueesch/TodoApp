package ch.brueesch.todoapp.todoapp.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
	public String addEntry(@RequestBody @ModelAttribute(value = "entry") Entry entry) {
		if (entry.getDate() == null) {
			entry.setDate(LocalDate.now());
		}
		entryService.addEntry(entry);
		return "redirect:/";
	}

	@RequestMapping(value = "/getAllEntries", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Entry>> getAllEntries() {
		return ResponseEntity.ok(entryService.getAllEntries());
	}

	@RequestMapping(value = "/snoozeEntry", method = RequestMethod.POST)
	public String snoozeEntry(@RequestParam("index") int index, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		entryService.setNewDate(index, date);
		return "redirect:/";
	}

	@RequestMapping(value = "/removeEntry", method = RequestMethod.POST)
	public String removeEntry(@RequestBody @RequestParam("index") int index) {
		entryService.removeEntry(index);
		return "redirect:/";
	}
}
