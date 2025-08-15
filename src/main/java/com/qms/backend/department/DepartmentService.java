package com.qms.backend.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Number getTotalCountDepartment() {
        return departmentRepository.count();
    }

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(int id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public Department createDepartment(Department userGroup) {
        return departmentRepository.save(userGroup);
    }

    public Department updateDepartment(Department userGroup) {
        return departmentRepository.save(userGroup);
    }

    public void deleteDepartment(int id) {
        departmentRepository.deleteById(id);
    }

}
