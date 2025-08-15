package com.qms.backend.passwordSetting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordSettingRepository extends JpaRepository<PasswordSetting,Integer> {
}
