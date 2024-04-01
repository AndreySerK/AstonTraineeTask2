package org.example.repository.impl;

import org.example.model.University;
import org.example.repository.UniversityRepository;

import java.util.List;

public class UniversityRepositoryImpl implements UniversityRepository {
    @Override
    public University findById(Integer id) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public List<University> findAll() {
        return null;
    }

    @Override
    public void save(University university) {

    }
}
