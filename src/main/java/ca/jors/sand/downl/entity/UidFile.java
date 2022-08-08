package ca.jors.sand.downl.entity;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UidFile {
   @Id 
   private UUID id; 
}
