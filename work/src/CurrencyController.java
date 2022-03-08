import.AbstractController;
        import .CurrencyExchange;
        import .Currency;
        import .CurrencyExchangeHistory;
        import .CurrencyExchangeHistoryService;
        import .CurrencyService;
        import .slf4j.Logger;
        import .slf4j.LoggerFactory;
        import .springframework.beans.factory.annotation.Autowired;
        import .springframework.cache.annotation.Cacheable;
        import .springframework.http.HttpStatus;
        import .springframework.stereotype.Controller;
        import .springframework.web.bind.annotation.*;
        import .CurrencyExchangeService;

import java.util.Date;
        import java.util.List;

/**
 * REST service for currency exchange services.
 *
 * Created by Mohamed Mekkawy.
 */
@Controller
@RequestMapping("currency")
public class CurrencyController extends AbstractController {

    private final Logger logger = LoggerFactory.getLogger(CurrencyController.class);

    @Autowired
    private CurrencyExchangeService currencyExchangeService;

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private CurrencyExchangeHistoryService currencyExchangeHistoryService;

    /**
     * Get list of currencies
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "list")
    @Cacheable
    public List<Currency> getCurrencies() {
        logger.debug("getCurrencies()");

        List<Currency> result = currencyService.getCurrencies();

        return result;
    }

    /**
     * Get exchange rate
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "exchange")
    public CurrencyExchange getCurrencyExchange(@RequestParam(value = "currencyLeft") String currencyLeft,
                                                @RequestParam(value = "currencyRight") String currencyRight,
                                                @RequestParam(value = "date", required = false) Date date) {
        logger.debug("getCurrencyExchange({}, {}, {})", currencyLeft, currencyRight, date);
        CurrencyExchange result = currencyExchangeService.getCurrencyExchange(currencyLeft, currencyRight, date);
        currencyExchangeHistoryService.saveExchangeInUserHistory(result);

        return result;
    }

    /**
     * Get list of exchange history
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "history")
    public List<CurrencyExchangeHistory> getCurrencyExchangeHistory() {

        return currencyExchangeHistoryService.getHistoryForCurrentUser();

    }


}