package org.manager.service;

import org.manager.models.PasswordInfo;

import java.util.List;

public interface PasswordService {
   void addKey();
   void watchAllPasses();
   List<PasswordInfo> findSite(String site);
   List<PasswordInfo> findEmail(String email);
   List<PasswordInfo> findPass(String pass);
}
