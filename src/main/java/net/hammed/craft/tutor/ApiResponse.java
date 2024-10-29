package net.hammed.craft.tutor;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ApiResponse {
    private String message;
    private List<Material> materials; // Optionally return materials as well

    public ApiResponse(String message, List<Material> materials) {
        this.message = message;
        this.materials = materials;
    }

    
}
