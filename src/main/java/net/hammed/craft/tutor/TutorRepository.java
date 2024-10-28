// package net.hammed.craft.tutor;

// public class TutorRepository {

// }


package net.hammed.craft.tutor;



import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Material, Integer> {



    // Optional<Material> findByEmail(String email);

}