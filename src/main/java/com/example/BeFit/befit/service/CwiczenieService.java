package com.example.BeFit.befit.service;

import com.example.BeFit.befit.model.Cwiczenie;
import com.example.BeFit.befit.repository.CwiczenieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CwiczenieService {
    private final CwiczenieRepository cwiczenieRepository;
    private final ObjectMapper objectMapper;

    private final FileService fileService;

    @Transactional(readOnly = true)
    public ResponseEntity<List<Cwiczenie>> findAllCwiczenia(){
        List<Cwiczenie> cwiczenia = cwiczenieRepository.findAll();
        if(cwiczenia.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cwiczenia);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Cwiczenie> findCwiczenieById(Long id){
        return cwiczenieRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Transactional
    public ResponseEntity<Cwiczenie> createCwiczenie(String cwiczenieJson, MultipartFile image) throws IOException {
        Cwiczenie cwiczenie = objectMapper.readValue(cwiczenieJson, Cwiczenie.class);
        if (!image.isEmpty()) {
            String imagePath = fileService.saveFile(image, "cwiczenia");
            cwiczenie.setImagePath(imagePath);
        }
        return ResponseEntity.ok(cwiczenieRepository.save(cwiczenie));
    }

    @Transactional
    public ResponseEntity<Void> deleteCwiczenie(Long id){
        if (cwiczenieRepository.existsById(id)) {
            cwiczenieRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    public ResponseEntity<Cwiczenie> updateCwiczenie(Long id, String updatedCwiczenie, MultipartFile image) throws IOException {
        Cwiczenie cwiczenie = cwiczenieRepository.findById(id).orElse(null);
        if(cwiczenie != null){
            Cwiczenie cwiczenieDetails = objectMapper.readValue(updatedCwiczenie, Cwiczenie.class);
                updateCwiczenieDetails(cwiczenie, cwiczenieDetails);
            if (!image.isEmpty()) {
                String imagePath = fileService.saveFile(image, "cwiczenia");
                cwiczenie.setImagePath(imagePath);
            }
            return ResponseEntity.ok(cwiczenieRepository.save(cwiczenie));
        }
        return null;
    }

    private void updateCwiczenieDetails(Cwiczenie cwiczenie, Cwiczenie cwiczenieDetails){
        cwiczenie.setLink(cwiczenieDetails.getLink());
        cwiczenie.setKategoria(cwiczenieDetails.getKategoria());
        cwiczenie.setImagePath(cwiczenieDetails.getImagePath());
    }
}
