package api;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("api/v3/user"))
@RequiredArgsConstructor
@CrossOrigin
@Tag(name = "User api", description = "API for User crud methods")
public class OrderApi {
}
