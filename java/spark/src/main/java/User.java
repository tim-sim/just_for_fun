import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by tim on 15.04.2017.
 */
@Builder
@Getter
@Setter
public class User {
    private int id;
    private String username;
    private String email;
}
