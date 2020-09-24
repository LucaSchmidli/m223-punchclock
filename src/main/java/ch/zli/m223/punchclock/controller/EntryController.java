
package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.service.EntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entries")
public class EntryController {
    private EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }
    /**
     *
     * Gibt alle Einträge zurück
     *
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Entry> getAllEntries() {
        return entryService.findAll();
    }
    /** Löscht einen Eintrag
     * @param id Die ID des Eintrages.
     *
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEntry(@PathVariable Long id){
        entryService.deleteEntry(id);
    }
    /** Updatet einen Eintrag
     * @param entryId Die ID des Eintrages.
     * @param entryDetails Die neuen Daten des Eintrages
     */
    @PutMapping("/{entryId}")
    public void  updateEmployee(@PathVariable Long entryId,@Valid @RequestBody Entry entryDetails)  {
        entryService.updateEntry(entryId,entryDetails);
    }
    /** Erstellt einen Eintrag
     * @param entry Der einzutragende Eintrag
     *
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entry createEntry(@Valid @RequestBody Entry entry) {
        return entryService.createEntry(entry);
    }
}