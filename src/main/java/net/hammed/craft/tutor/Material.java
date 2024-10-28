package net.hammed.craft.tutor;

import java.time.LocalDateTime;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.hammed.craft.user.User;


@Builder
@Data
@Entity
@Table(name = "materials")
@NoArgsConstructor
@AllArgsConstructor

public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    
    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    private User tutor;
    
    private String title;
    private String description;
    private String fileUrl;
    
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and Setters
}
