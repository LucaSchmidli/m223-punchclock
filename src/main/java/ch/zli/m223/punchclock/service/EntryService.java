package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.repository.EntryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntryService {
    private EntryRepository entryRepository;

    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public Entry createEntry(Entry entry) {
        return entryRepository.saveAndFlush(entry);
    }

    public void deleteEntry(Long id){
        entryRepository.deleteById(id);
    }

    public void updateEntry(Long entryId, Entry entryDetails){
     entryDetails.setId(entryId);
     entryRepository.saveAndFlush(entryDetails);
    }

    public List<Entry> findAll() {
        return entryRepository.findAll();
    }
}
