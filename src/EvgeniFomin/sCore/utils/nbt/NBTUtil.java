package EvgeniFomin.sCore.utils.nbt;

import java.util.ArrayList;
import java.util.List;

public class NBTUtil {
    public static NBTTagList toNBTTagList(List<String> alist) {
        NBTTagList nbt = new NBTTagList();
        alist.forEach(value -> {
            nbt.appendTag(new NBTTagString(value));
        });
        return nbt;
    }

    public static List<String> toArrayList(NBTTagList nlist) {
        List<String> alist = new ArrayList<>();
        nlist.forEach(value -> {
            alist.add(value.toString());
        });
        return alist;
    }
}
