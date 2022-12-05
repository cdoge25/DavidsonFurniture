package com.nhom6.davidsonfurniture.Utils;

import com.nhom6.davidsonfurniture.Adapters.SexAdapter;

public class SexDataUtils {
    public static SexAdapter[] getSexs() {
        SexAdapter sex1 = new SexAdapter("Nam");
        SexAdapter sex2 = new SexAdapter("Nữ");
        SexAdapter sex3 = new SexAdapter("Khác");
        return new SexAdapter[] {sex1, sex2, sex3};
    }
}
