package ch.brueesch.todoapp.todoapp.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import ch.brueesch.todoapp.todoapp.model.Entry;
import ch.brueesch.todoapp.todoapp.services.EntryService;
import ch.brueesch.todoapp.todoapp.util.Priority;

@Component
public class StartUpConfig {

	private EntryService entryService;

	@Autowired
	public StartUpConfig(EntryService entryService) {
		this.entryService = entryService;
	}

	@EventListener
	public void load (ApplicationReadyEvent event) {
		entryService.addEntry(new Entry().setDate(LocalDate.now()).setPriority(Priority.LOW).setDescription("Example Task"));
	}

}
