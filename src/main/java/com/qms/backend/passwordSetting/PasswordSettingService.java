package com.qms.backend.passwordSetting;

import com.qms.backend.userGroup.UserGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordSettingService {

    @Autowired
    private PasswordSettingRepository passwordSettingRepository;

    public List<PasswordSetting> getAllPasswordSetting() {
        return passwordSettingRepository.findAll();
    }

    public PasswordSetting getPasswordSettingById(int id) {
        return passwordSettingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Password not found"));
    }

    public PasswordSetting createpasswordSetting(PasswordSetting passwordSetting) {
        return passwordSettingRepository.save(passwordSetting);
    }

    public PasswordSetting updatePasswordSetting(PasswordSetting passwordSetting) {
        return passwordSettingRepository.save(passwordSetting);
    }

}
