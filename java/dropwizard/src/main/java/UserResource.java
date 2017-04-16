import com.codahale.metrics.annotation.Timed;
import lombok.Setter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by tim on 17.04.2017.
 */
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    @Setter
    private UserDataSource dataSource;

    @GET
    @Timed
    public List<User> getUsers() {
        return dataSource.getUsers();
    }

    @GET
    @Path("/{userId}")
    @Timed
    public User getUserById(@PathParam("userId") int userId) {
        return dataSource.getUserById(userId);
    }

}
