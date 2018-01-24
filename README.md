# TestApp
Using DAO pattern to connect to database with JDBC.Transform one .xml file to other using XSLT

Ревью пректа показал следующее-

Плюсы:
+ Работа с параметрами вынесена в отдельный класс, присутствует обработка вводимых значений, завершение исполнения в случае неверных данных.

+ Присутствует хелпер, показывающий примеры корректного заполнения параметров(showHelp()).

+ Предпринята попытка следования JavaBeans

+ Многопоточная вставка в таблицу

+ Формирование XML с использованием JAXB

+ Лаконичные именования классов и методов, неплохая организация распределения по слоям, код читаем.
Минусы:
- Параметры программы вводятся в виде аргументов запуска приложения, а не вынесены в отдельный propertie файл.

- Нарушено условие выполнения задания - очистка таблицы безусловная.

- Запутывающие сообщения об ошибках - в случае ошибок при удалении данных из таблицы или вставке в нее, сообщение абсолютно одинаковое - ERROR: Can not insert fields to database, "+e.getMessage()

- Удаление записей из базы через Delete(возможно, для унификации)

- Непонимание правил работы с ресурсами и использования конструкции try-with-resources:

try(Statement stmt = getConnection().createStatement()) {
    ResultSet resultSet = stmt.executeQuery(SELECT_STATEMENT);

- Отсутствует обработка ситуации при "targetEntries != null", программа продолжает исполнение, хотя ситуация и отслеживается.

 

Вопросы:

? Типичная обработка исключений в работе представлена в виде конкструкции:

                                                                                    }catch(DAOException e){
    System.err.println("\nERROR: Can not select fields from database, "+ e.getMessage());
    System.err.println("Program terminated");
    System.exit(0);
}
Вызываться может с любого уровня, даже с уровня доступа к данным. Почему не организовано поднятие исключения с возвратом управления в точку вызова, отсутствует обработка результата и использован код 0 при наличии ошибки?

Будем исправлять,дорабатывать и улучшать!))


