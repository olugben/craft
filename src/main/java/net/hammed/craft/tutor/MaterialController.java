
package net.hammed.craft.tutor;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController

@RequestMapping("/api/v1/tutor/materials")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @PostMapping("/")
    public ResponseEntity<List<Material>> createMaterial(
            @RequestParam("files") List<MultipartFile> files,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tutor_id") Integer tutorId,
            @RequestHeader("Authorization") String auth) {
            
        try {
            System.out.println(auth);
            List<Material> savedMaterials = materialService.UploadMaterials(files, title, description, tutorId);
            return ResponseEntity.ok(savedMaterials);
        } catch (IOException e) {

            Material errorMaterial = Material.builder()
                    .title("Error")
                    .description("Error uploading materials: " + e.getMessage())
                    .fileUrl(null)
                    .build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)

                    .body(Collections.singletonList(errorMaterial));
        } catch (IllegalArgumentException e) {
            Material errorMaterial = Material.builder()
                    .title("Invalid input")
                    .description("Invalid input: " + e.getMessage())
                    .fileUrl(null)
                    .build();
            return ResponseEntity.badRequest()
                    .body(Collections.singletonList(errorMaterial));
        }
    }

    @GetMapping("/viewalltutors")
    public List<Material> listAllTutors() {
        return materialService.getAllTutors();
    }

}
