package EvgeniFomin.sCore.utils;

public enum  DonateGroup {
        DEFAULT("Default", "§7Игрок", "§7Игрок", "§f"),
        VIP("Vip", "§aВип§f", "§aВип§7", "§f"),
        Researcher("Researcher", "§6Исследователь", "§6Исследователь", "§f"),
        Premium("Premium", "§eПремиум", "§eПремиум", "§f"),
        Lord("Lord", "§2Лорд", "§2Лорд", "§f"),
        King("King", "§cКороль", "§cКороль", "§f");

        private String group = "Default";
        private String prefix = "§7Игрок";
        private String tabPrefix = "§7Игрок";
        private String colorChat = "§f";


        DonateGroup(String group, String prefix, String tabPrefix, String colorChat) {
            this.group = group;
            this.prefix = prefix;
            this.tabPrefix = tabPrefix;
            this.colorChat = colorChat;
        }

        public String getGroup() {
            return group;
        }

        public String getPrefix() {
            return prefix;
        }

        public String getTabPrefix() {
            return tabPrefix;
        }

        public String getColor() {
            return colorChat;
        }
}
