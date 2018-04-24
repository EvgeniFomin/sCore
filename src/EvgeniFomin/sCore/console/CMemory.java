package EvgeniFomin.sCore.console;
/**
 * Получение ресурсов которые потребляет система.
 *
 * @author EvgeniFomin
 * @https://vk.com/evgenifomin2001
 */
public class CMemory {

    /**
     * @return возвращает количество используемой памяти Кором.
     */
    public long getUsedMemory() {
        return ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024);
    }

    /**
     * @return возвращает количество выделеной памяти Кору.
     */
    public long getMaximumMemory() {
        return ((Runtime.getRuntime().maxMemory() - getUsedMemory()) / 1024 / 1024);
    }

    /**
     * @return возвращает количество памяти которой Кор не использует но она доступна системе.
     */
    public long getFreeMemory() {
        return getMaximumMemory() - getUsedMemory();
    }
}
