package ch.brueesch.todoapp.todoapp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.brueesch.todoapp.todoapp.model.Entry;
import ch.brueesch.todoapp.todoapp.services.EntryService;

@Controller
public class HomeController {

	private EntryService entryService;

	@Autowired
	public HomeController(EntryService entryService) {
		this.entryService = entryService;
	}

	@RequestMapping("/")
	public String welcome(Model model, Map<String, Object> model2) {
		model2.put("messages", entryService.getAllEntries());
		model2.put("todaystasks", entryService.getAllEntriesForToday());

		Entry entry = new Entry();
		model.addAttribute(entry);

		return "welcome";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}


}
