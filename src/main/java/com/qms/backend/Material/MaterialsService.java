package com.qms.backend.Material;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;


@Service
public class MaterialsService {

    private static final Logger log = LoggerFactory.getLogger(MaterialsService.class);
    @Value("${file.upload-dir}")
    private String uploadDir;

    @Autowired
    private MaterialsRepository materialRepository;

    public void saveMaterial(MultipartFile file, MaterialType materialType) throws IOException {
        Path path = Paths.get("materialUpload");
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        Path filePath = path.resolve(file.getOriginalFilename());
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        Materials material = new Materials();
        material.setMaterialName(file.getOriginalFilename());
        material.setMaterialType(materialType);
        material.setLink(filePath.toString());

        materialRepository.save(material);
    }

    private int calculateReadTime(MultipartFile pdfFile) {
        // Dummy implementation, you can use a library like PDFBox to calculate read time
        return 5; // Assume 5 minutes for now
    }

    public List<Materials> getAllMaterials() {
        return materialRepository.findAll();
    }
}


