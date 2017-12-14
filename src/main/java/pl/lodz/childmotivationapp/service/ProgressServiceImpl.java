package pl.lodz.childmotivationapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.childmotivationapp.entity.Progress;
import pl.lodz.childmotivationapp.repository.ProgressRepository;

import java.util.List;

/**
 * Created by elawpio on 2017-12-14.
 */
@Service
public class ProgressServiceImpl implements ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    @Override
    public List<Progress> getAll() {
        return progressRepository.findAll();
    }

    @Override
    public Progress getProgress(long id) {
        return progressRepository.findById(id);
    }

    @Override
    public void addProgress(Progress task) {
        progressRepository.save(task);
    }

    @Override
    public void removeProgress(long id) {
        progressRepository.delete(progressRepository.findById(id));
    }

    @Override
    public void editProgress(long id) {

    }

}
