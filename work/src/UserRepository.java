import .User;
        import .springframework.data.mendb.repository.MenRepository;

        import java.util.List;

/**
 * Repository for the {@link User} Document
 *
 * Created by Mohamed Mekkawy.
 */
public interface UserRepository extends MenRepository<User, String> {

    @Override
    List<User> findAll();

    User findByUserName(String userName);

}