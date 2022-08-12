package ca.jors.sand.downl.entity;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UidFile {
   @Id
   private UUID id;

   @NonNull
   private String name;

   @NonNull
   private String mediaType;
}
