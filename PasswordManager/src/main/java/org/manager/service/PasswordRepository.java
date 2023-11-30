package org.manager.service;

import org.manager.models.PasswordInfo;

import java.util.List;
import java.util.Optional;

public interface PasswordRepository {
    List<PasswordInfo> findAll();
    Optional<PasswordInfo> findById(Long id);
    List<PasswordInfo> findByEmail(String email);
    List<PasswordInfo> findByPassword(String password);
    void update(PasswordInfo element);
    void save(PasswordInfo element);
    void delete(Long id);
}
