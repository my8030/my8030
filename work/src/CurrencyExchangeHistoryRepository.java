import .CurrencyExchangeHistory;
        import .springframework.data.mendb.repository.MenRepository;

        import java.util.List;

/**
 * Repository for the {@link CurrencyExchangeHistory}
 *
 * Created by Mohamed Mekkawy.
 */
public interface CurrencyExchangeHistoryRepository extends MenRepository<CurrencyExchangeHistory, String>{

    @Override
    List<CurrencyExchangeHistory> findAll();

    List<CurrencyExchangeHistory> findByUserId(String userId);

}