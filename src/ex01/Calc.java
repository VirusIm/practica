package ex01;

import java.io.*;

/**
 * Содержит реализацию методов для вычисления и отображения результатов.
 *
 * @author Vlada
 * @version 1.0
 */
@SuppressWarnings("SpellCheckingInspection")
public class Calc {
    /**
     * Имя файла, используемое при сериализации.
     */
    private static final String FNAME = "ex0.Data.bin";
    /**
     * Сохраняет результат вычислений. Объект класса {@linkplain Data}
     */
    private Data result;

    /**
     * Инициализирует {@linkplain Calc#result}
     */
    public Calc() {
        result = new Data();
    }

    /**
     * Установить значение {@linkplain Calc#result}
     *
     * @param result - новое значение ссылки на объект {@linkplain Data}
     */
    public void setResult(Data result) {
        this.result = result;
    }

    /**
     * Получить значение {@linkplain Calc#result}
     *
     * @return текущее значение ссылки на объект {@linkplain Data}
     */
    public Data getResult() {
        return result;
    }

    /**
     * Вычисляет значение функции.
     *
     * @param arguments - аргументы вычисляемой функции.
     * @return результат вычисления функции.
     */
    private byte calc(double []arguments) {
        int number = (int)((Math.sin(arguments[0]) + Math.sin(arguments[1]) + Math.sin(arguments[2]) + Math.sin(arguments[3])) / 4.0 * 1000);
        byte count = 0;

        if(number < 0) {
            number *= -1;
        }

        while (number > 0) {
            number &= (number - 1);
            count++;
        }

        return count;
    }

    /**
     * Вычисляет значение функции и сохраняет
     * результат в объекте {@linkplain Calc#result}
     *
     * @param arguments - аргументы вычисляемой функции.
     */
    public byte init(double []arguments) {
        result.setArguments(arguments);
        return result.setOnesNumber(calc(arguments));
    }

    /**
     * Выводит результат вычислений.
     */
    public void show() {
        System.out.println(result);
    }

    /**
     * Сохраняет {@linkplain Calc#result} в файле {@linkplain Calc#FNAME}
     *
     * @throws IOException
     */
    public void save() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new
                FileOutputStream(FNAME));
        os.writeObject(result);
        os.flush();
        os.close();
    }

    /**
     * Восстанавливает {@linkplain Calc#result} из файла {@linkplain Calc#FNAME}
     *
     * @throws Exception
     */
    public void restore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        result = (Data) is.readObject();
        is.close();
    }
}
