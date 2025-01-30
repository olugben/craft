package net.hammed.craft.tutor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import net.hammed.craft.user.User;
import net.hammed.craft.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service

public class MaterialService {
    private static final Logger logger = LoggerFactory.getLogger(MaterialService.class);
  
    @Autowired
    private TutorRepository tutorrepository;

    @Autowired
    private UserRepository userRepository; // Injecting UserRepository to fetch the tutor

    private final String uploadDir = "C:/code-x/craft";

    @PostConstruct
    public void init() {
        File directory = new File(uploadDir);
        if (directory.mkdirs()) {
            logger.info("Created upload directory");
        } else {
            logger.info("upload directory exists or could not be created ; {}", uploadDir);
        }
    }

    public List<Material> UploadMaterials(List<MultipartFile> files, String title, String description, Integer tutor_id)
            throws IOException {
        List<Material> savedVideos = new ArrayList<>();

        User tutor = userRepository.findById(tutor_id)
                .orElseThrow(() -> new RuntimeException("Tutor not found with ID: "));

        for (MultipartFile file : files) {
            String fileType = file.getContentType();
            if (fileType == null || !fileType.startsWith("video/")) {
                throw new IllegalArgumentException("Each file must be a video");
            }
            String filePath = uploadDir + File.separator + file.getOriginalFilename();
            file.transferTo(new File(filePath));

            Material material = new Material();
            logger.info(material.getDescription());

            material.setTitle(title);
            material.setDescription(description);
            material.setFileUrl(filePath);
            material.setTutor(tutor); // Setting the tutor
            savedVideos.add(material);
        }

        return tutorrepository.saveAll(savedVideos);
    }

    public List<Material> getAllTutors() {

        return tutorrepository.findAll();

    }
}