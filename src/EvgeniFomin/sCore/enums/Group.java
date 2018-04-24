package EvgeniFomin.sCore.enums;


import java.awt.*;

@SuppressWarnings("ALL")
public enum Group {
    Игрок(1, "§7Игрок", "§7Игрок", Color.WHITE, 1.0f),
    Вип(2, "§aВип§f", "§aВип§7", Color.WHITE, 2.0f),
    Исследователь(3, "§6Исследователь", "§6Исследователь", Color.WHITE, 3.0f),
    Премиум(4, "§eПремиум", "§eПремиум", Color.WHITE, 4.0f),
    Лорд(5, "§2Лорд", "§2Лорд", Color.WHITE, 5.0f),
    Король(6, "§cКороль", "§cКороль", Color.WHITE, 6.0f),
    Ютубер(7, "§fYou§cTube", "§fYou§cTube", Color.WHITE, 6.0f),
    Строитель(8, "§eСтроитель", "§eСтроитель", Color.WHITE, 2.0f),
    Хелпер(9, "§bХелпер", "§bХелпер", Color.WHITE, 2.0f),
    Модератор(10, "§3Модератор", "§3Модер", Color.WHITE, 3.0f),
    Администратор(11, "§cАдминистратор", "§cАдминистратор", Color.WHITE, 6.0f);

    private Integer id;
    private String prefix;
    private String tabprefix;
    private Color chatcolor;
    private Float multiplier;

    Group(int id, String prefix, String tabprefix, Color chatcolor, float multiplier) {
        this.id = id;
        this.prefix = prefix;
        this.tabprefix = tabprefix;
        this.chatcolor = chatcolor;
        this.multiplier = multiplier;
    }

    public Integer getId() {
        return id;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getTabprefix() {
        return tabprefix;
    }

    public Color getChatcolor() {
        return chatcolor;
    }

    public Float getMultiplier() {
        return multiplier;
    }
}
