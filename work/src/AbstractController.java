import .slf4j.Logger;
        import .slf4j.LoggerFactory;
        import .springframework.http.HttpStatus;
        import .springframework.http.ResponseEntity;
        import .springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * Created by Mohamed Mekkawy.
 */
public abstract class AbstractController {

    private final Logger logger = LoggerFactory.getLogger(AbstractController.class);

    /**
     * error handler for backend errors - a 400 status code will be sent back, and the body
     * of the message contains the exception text.
     *
     * @param exc - the exception caught
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> errorHandler(Exception exc) {
        logger.error(exc.getMessage(), exc);
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
    }
}