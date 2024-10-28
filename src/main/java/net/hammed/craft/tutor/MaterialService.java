package net.hammed.craft.tutor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.PostConstruct;
import net.hammed.craft.user.User;
import net.hammed.craft.user.UserRepository;

@Service
// public class MaterialService {
//     @Autowired
//     private TutorRepository repository;

//     public Material createMaterial(String name, String description) {
//         Material material = new Material();
//         material.setName(name);
//         material.setDescription(description);
//         return repository.save(material);
//     }
// }

public class MaterialService {

    @Autowired
    private TutorRepository tutorrepository;

    @Autowired
    private UserRepository userRepository; // Injecting UserRepository to fetch the tutor

    // public Material createMaterial(String title, String description, String fileUrl, Integer tutor_id) {
    //     // Find the tutor by ID
    //     User tutor = userRepository.findById(tutor_id)
    //             .orElseThrow(() -> new RuntimeException("Tutor not found with ID: " ));

    //     // Create new Material
    //     Material material = new Material();
    //     material.setTitle(title);
    //     material.setDescription(description);
    //     material.setFileUrl(fileUrl);
    //     material.setTutor(tutor); // Setting the tutor

    //     // Save the Material entity
    //     return tutorrepository.save(material);
    // }

    private final String uploadDir = "uploads/videos";
    @PostConstruct
    public void init(){
        File directory =new File(uploadDir);
        if(directory.mkdirs()){
            // log.info("Created upload directory");
        }
        else{
            // log.info("upload directory exists or could not be created ; {}", uploadDir);
        }
    }


public List<Material> UploadMaterials(List<MultipartFile> files, String title, String description, Integer tutor_id) throws IOException{
    List<Material> savedVideos =new ArrayList<>();


    for(MultipartFile file: files){
        String fileType =file.getContentType();
        if(fileType==null|| !fileType.startsWith("video/")){
            // log.warn("Invalid File type {}", fileType)
            continue;
        }
    }
return null;
}

    public  List<Material> getAllTutors() {
        
       return   tutorrepository.findAll();
      
      
    }
}