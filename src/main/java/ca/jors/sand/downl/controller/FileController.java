package ca.jors.sand.downl.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ca.jors.sand.downl.repositories.UidFileRepository;

@RestController()
@RequestMapping("demo")
public class FileController {

        UidFileRepository uidFileRepository;

        public FileController(UidFileRepository uidFileRepository) {
                this.uidFileRepository = uidFileRepository;
        }

        @GetMapping("/new")
        public void newFile(){

        }

        @GetMapping("/ping")
        public String ping() {
                return "pong";
        }

        @GetMapping(value = "/image/{id}")
        public ResponseEntity<ByteArrayResource> getImage(@PathVariable String id)
                        throws IOException {
                try {
                        ByteArrayResource resource = new ByteArrayResource(
                                        Files.readAllBytes(Path.of("files", id)));
                        return ResponseEntity.ok().contentType(MediaType.IMAGE_GIF)
                                        .contentLength(resource.contentLength())
                                        .header(HttpHeaders.CONTENT_DISPOSITION,
                                                        ContentDisposition.inline()
                                                                        .filename("whatever.gif")
                                                                        .build().toString())
                                        .body(resource);
                } catch (Exception e) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
                }

        }


        @GetMapping(value = "/pdf")
        public ResponseEntity<ByteArrayResource> getPdf() throws IOException {
                ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(
                                Path.of("/home/djors/work/projects/down/sand/files/sample.pdf")));

                return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/pdf"))
                                .contentLength(resource.contentLength())
                                .header(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.inline()
                                                .filename("sample.pdf").build().toString())
                                .body(resource);
        }
}
