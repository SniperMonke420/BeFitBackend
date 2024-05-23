package com.example.BeFit.befit.service;

import com.example.BeFit.befit.model.Cwiczenie;
import com.example.BeFit.befit.model.Przepis;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RequiredArgsConstructor
@Service
public class FileService {

    @Value("${app.upload.dir:src/main/resources/Images}")
    private String uploadDir;

    public void loadPrzepisImage(Przepis przepis) {
        try {
            if (przepis.getImage() != null) {
                Path posterPath = Paths.get(przepis.getImagePath());
                przepis.setImage(Files.readAllBytes(posterPath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadCwiczeniaImage(Cwiczenie cwiczenie) {
        try {
            if (cwiczenie.getImage() != null) {
                Path posterPath = Paths.get(cwiczenie.getImagePath());
                cwiczenie.setImage(Files.readAllBytes(posterPath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String saveFile(MultipartFile file, String folderName) throws IOException {
        Path directoryPath = Paths.get(uploadDir, folderName);
        if (!Files.exists(directoryPath)) {
            Files.createDirectories(directoryPath);
        }
        Path filePath = directoryPath.resolve(file.getOriginalFilename());
        file.transferTo(filePath);
        return filePath.toString();
    }
}
