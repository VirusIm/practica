package ex01;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Хранит исходные данные и результат вычислений.
 *
 * @author Vlada
 * @version 1.0
 */
@SuppressWarnings("SpellCheckingInspection")
public class Data implements Serializable {
    /**
     * Количество единиц в числе.
     */
    private byte onesNumber;

    /**
     * Аргументы функции.
     */
    private double []arguments;

    /**
     * Автоматически сгенерированная константа
     */
    private static final long serialVersionUID = 1L;

    /**
     * Инициализирует поля {@linkplain Data#onesNumber}, {@linkplain Data#arguments}
     */
    public Data() {
        onesNumber = 0;
        arguments = new double[4];
    }

    /**
     * Устанавливает значения полей: аргументов
     * и результата вычисления функции.
     *
     * @param onesNumber - значение для инициализации поля {@linkplain Data#onesNumber}
     * @param arguments - значение для инициализации поля {@linkplain Data#arguments}
     */
    public Data(byte onesNumber, double []arguments) {
        this.onesNumber = onesNumber;
        this.arguments = arguments;
    }

    /**
     * Установка значения поля {@linkplain Data#onesNumber}
     *
     * @param onesNumber - значение для {@linkplain Data#onesNumber}
     * @return Значение {@linkplain Data#onesNumber}
     */
    public byte setOnesNumber(byte onesNumber) {
        return this.onesNumber = onesNumber;
    }

    /**
     * Получение значения поля {@linkplain Data#onesNumber}
     *
     * @return Значение {@linkplain Data#onesNumber}
     */
    public byte getOnesNumber() {
        return onesNumber;
    }

    /**
     * Установка значения поля {@linkplain Data#arguments}
     *
     * @param arguments - значение для {@linkplain Data#arguments}
     * @return Значение {@linkplain Data#arguments}
     */
    public double []setArguments(double []arguments) {
        return this.arguments = arguments;
    }

    /**
     * Получение значения поля {@linkplain Data#arguments}
     *
     * @return значение {@linkplain Data#arguments}
     */
    public double []getArguments() {
        return arguments;
    }

    /**
     * Установка значений {@linkplain Data#onesNumber} и {@linkplain Data#arguments}
     *
     * @param onesNumber - значение для {@linkplain Data#onesNumber}
     * @param arguments - значение для {@linkplain Data#arguments}
     * @return this
     */
    public Data setOnesNumberAndArguments(byte onesNumber, double []arguments) {
        this.onesNumber = onesNumber;
        this.arguments = arguments;
        return this;
    }

    /**
     * Представляет результат вычислений в виде строки.{@inheritDoc}
     */
    @Override
    public String toString() {
        return "Number of one = " + onesNumber + ", arguments = " + Arrays.toString(arguments);
    }

    /**
     * Автоматически сгенерированный метод.{@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Data other = (Data) obj;
        if(onesNumber != other.onesNumber) {
            return false;
        }

        return !Arrays.equals(arguments, other.arguments);
    }
}