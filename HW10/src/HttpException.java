public class HttpException extends NetworkException {
    private int errorCode;

    public HttpException(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        switch (errorCode) {
            case 1: return "1: Недопустимий формат";
            case 2: return "2: Файл пошкоджений";
            case 3: return "3: Тип даних не підходить";
            case 4: return "4: Не найдено";
        }
        return "Сервер перевантажено спробуйте пізніше зараз ведутся роботи";
    }
}

}
