package pl.lodz.childmotivationapp.service;

import pl.lodz.childmotivationapp.entity.Progress;

import java.util.List;

/**
 * Created by elawpio on 2017-12-14.
 */
public interface ProgressService {
    List<Progress> getAll();
    Progress getProgress(long id);
    void addProgress(Progress task);
    void removeProgress(long id);
    void editProgress(long id);
}
