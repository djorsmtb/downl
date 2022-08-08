package ca.jors.sand.downl.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("demo")
public class FileController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping(value = "/image")
    public ResponseEntity<ByteArrayResource> getImage() throws IOException {
        // InputStream in = getClass().getResourceAsStream("./files/icon_stop.gif");

        ByteArrayResource resource = new ByteArrayResource(Files
                .readAllBytes(Path.of("/home/djors/work/projects/down/sand/files/icon_stop.gif")));

        return ResponseEntity.ok().contentType(MediaType.IMAGE_GIF)
                .contentLength(resource.contentLength())
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        ContentDisposition.inline().filename("whatever.gif").build().toString())
                .body(resource);


        /*
         * byte[] data = this.getClass().getClassLoader()
         * .getResourceAsStream("/home/djors/work/projects/down/sand/files/icon_stop.gif")
         * .readAllBytes(); return data;
         */ // return IOUtils.toByteArray(in);
    }
}
