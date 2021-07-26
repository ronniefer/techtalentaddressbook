package com.techtalentsouth.techtalentaddressbook.addressentry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddressEntryController {
	
    @Autowired
    private AddressEntryRepository addressEntryRepository;
    private static List<AddressEntry> entries = new ArrayList<>();
    
    @GetMapping(value="/")
    public String index(Model model) {
    	
    	entries.removeAll(entries);
    	
        for (AddressEntry entry : addressEntryRepository.findAll()) {
        	
        	entries.add(entry);
        }
        
    	model.addAttribute("entries", entries);
    	return "addressentry/index";
    }
    
    @GetMapping(value = "/addressentries/new")
    public String newAddressBook (AddressEntry addressEntry) {
    	
        return "addressentry/new";
    }
    
    @PostMapping(value = "/addressentries")
    public String addNewAddressEntry(AddressEntry addressEntry, Model model) {
    	
    	addressEntryRepository.save(addressEntry);
    	model.addAttribute("addressEntry", addressEntry);
    	return "addressentry/result";
    }
    
    @RequestMapping(value = "/addressentries/{id}", method = RequestMethod.GET)
    public String editEntryWithId(@PathVariable Long id, Model model) {
    	
        Optional<AddressEntry> entry = addressEntryRepository.findById(id);
        
        if (entry.isPresent()) {
        	AddressEntry actualEntry = entry.get();
            model.addAttribute("addressEntry", actualEntry);
        }
        
        return "addressentry/edit";
    }
    
	
    @RequestMapping(value = "/addressentries/update/{id}")
    public String updateExistingEntry(@PathVariable Long id, AddressEntry addressEntry, Model model) {
        Optional<AddressEntry> entry = addressEntryRepository.findById(id);
        if (entry.isPresent()) {
        	AddressEntry actualEntry = entry.get();
        	actualEntry.setFirstName(addressEntry.getFirstName());
        	actualEntry.setLastName(addressEntry.getLastName());
            actualEntry.setPhoneNumber(addressEntry.getPhoneNumber());
            actualEntry.setEmailAddress(addressEntry.getEmailAddress());
            addressEntryRepository.save(actualEntry);
            model.addAttribute("addressEntry", actualEntry);
        }
 
        return "addressentry/result";
    }
    
    @RequestMapping(value = "/addressentries/delete/{id}")
    public String deleteEntryWithId(@PathVariable Long id, Model model) {

    	Optional<AddressEntry> entry = addressEntryRepository.findById(id);
    	if (entry.isPresent()) {
    		addressEntryRepository.deleteById(id);
	        model.addAttribute("addressEntry", entry.get());
    	}
        return "addressentry/delete";

    }
    
}
