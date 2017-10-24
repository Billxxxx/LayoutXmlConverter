package linyuzai.plugin.xml.common;

import java.util.HashSet;
import java.util.Set;

public class ImportUtil {
    private static final String IMPORT = "import ";
    public static final String ANKO = "org.jetbrains.anko";
    public static final String ACTIVITY = "android.app.Activity";
    public static final String BUNDLE = "android.os.Bundle";

    public static final String COLOR = "android.graphics.Color";
    public static final String GRAVITY = "android.view.Gravity";

    public static final String LINEAR_LAYOUT = "android.widget.LinearLayout";
    public static final String IMAGE_VIEW = "android.widget.ImageView";

    private static final Set<String> importSet = new HashSet<>();

    public static void importClass(StringBuilder builder, String classTag) {
        builder.append(IMPORT).append(classTag).append("\n");
    }

    public static void importMultiClass(StringBuilder builder, String packageTag) {
        builder.append(IMPORT).append(packageTag).append(".*").append("\n");
    }

    public static void importR(StringBuilder builder, String packageTag) {
        builder.append("\n").append(IMPORT).append(packageTag).append(".R").append("\n");
    }

    public static void add(String importClass) {
        importSet.add(importClass);
    }

    public static void importFromSet(StringBuilder builder) {
        importSet.parallelStream().forEach(it -> importClass(builder, it));
    }

    public static void clearImport() {
        importSet.clear();
    }
}