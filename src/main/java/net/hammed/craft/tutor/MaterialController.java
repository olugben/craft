// package net.hammed.craft.tutor;

// public class TutorController {

// }
package net.hammed.craft.tutor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tutor/materials")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @PostMapping
    public ResponseEntity<Material> createMaterial(@RequestBody Material material) {
        Material savedMaterial = materialService.createMaterial(material.getTitle(), material.getDescription(),
                material.getFileUrl(), material.getId());
        return ResponseEntity.ok(savedMaterial);
    }

    @GetMapping("/viewalltutors")
    public List<Material> listAllTutors() {
        return materialService.getAllTutors();
    }

}
