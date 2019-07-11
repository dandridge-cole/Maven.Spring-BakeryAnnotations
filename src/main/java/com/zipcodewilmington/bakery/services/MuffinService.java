package com.zipcodewilmington.bakery.services;

import com.zipcodewilmington.bakery.models.Muffin;
import com.zipcodewilmington.bakery.repositories.MuffinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MuffinService {

    @Autowired
    private MuffinRepository repository;

    public MuffinService(MuffinRepository repository) {
        this.repository = repository;
    }

    public Iterable<Muffin> index() {
        return repository.findAll();
    }

    public Muffin show(Long id) {
        return repository.findById(id).get();
    }

    public Muffin create(Muffin baker) {
        return repository.save(baker);
    }

    public Muffin update(Long id, Muffin newMuffinData) {
        Muffin originalMuffin = repository.findById(id).get();
        originalMuffin.setFlavor(newMuffinData.getFlavor());
        return repository.save(originalMuffin);
    }

    public Boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}
