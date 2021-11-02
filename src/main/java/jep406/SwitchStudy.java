package jep406;

public class SwitchStudy {

    public static void main(String[] args) {
        System.out.println(formatPatternSwitch("hello"));
        System.out.println(formatPatternSwitch(7.2f));
        System.out.println(formatPatternSwitch(null));
        System.out.println(formatPatternSwitch(10));
    }

    static String formatPatternSwitch(Object object) {
        return switch (object) {
            case Integer i && i < 10 -> String.format("int < 10, %d", i);
            case Integer i && i > 10 -> String.format("int > 10, %d", i);
            case Integer i && i == 10 -> String.format("int = 10, %d", i);
            case Integer i -> String.format("Never execute here, %d", i);// 这里不认定为bug
            case Long l -> String.format("long %d", l);
            //case CharSequence cs -> String.format("String %s", cs.toString()); 不能在 String 之前！！！
            case String s -> String.format("String %s", s);
            case CharSequence cs -> String.format("String %s", cs.toString());//但可以在 string 之后
            case String[] stringArray -> String.format("Array of String, %d", stringArray.length);
            case BookType bookType -> String.format("Book type %s", bookType.name());
            case Float f -> String.format("Float %f", f);
            //如果在 switch 里面没有判断过null, 最后就会 throw NullPointerException, 尽管最后的default 都没有用！
            case null, Double d1 -> String.format("This is null, or this is double value");
            default -> "default value";
        };
    }




    static String formatPatternSwitch2(Object object) {
        return switch (object) {
            case null, default -> "";//只有 null 和 default 能在一起
        };
    }

    static void formatPatternSwitch3(Object object) {
        switch (object) {
            case null: default: {//标签化, 只有 null 和 default 能在一起

            };
        };
    }

}
